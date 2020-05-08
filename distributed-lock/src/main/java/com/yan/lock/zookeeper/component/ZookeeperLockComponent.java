package com.yan.lock.zookeeper.component;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * @author 闫天宇
 * @date 2020/5/8 16:27
 */
@Component
public class ZookeeperLockComponent {

    private String host = "192.168.99.100:2181";
    private String path = "/lock";
    private CountDownLatch count = null;

    private ZkClient client = new ZkClient(host);

    //上锁
    public void zkLock() {
        //创建临时节点，
        if (createNode()) {
            System.out.println("====抢到锁了!====");
        } else {
            //创建失败，没有抢到锁，进行等待，等待结束后继续
            waitLock();
            //重新进行抢锁
            zkLock();

        }

    }

    //解锁
    public void zkUnLock() {

        if (client != null) {
            //关闭客户端，临时节点会自动删除！
            client.delete(path);
            System.out.println("====释放锁了!====");
        }
    }

    /**
     * 创建临时节点。如果临时节点已经存在，在进行创建就会报异常
     *
     * @return true 创建成功；false 创建失败
     */
    private boolean createNode() {

        try {
            client.createEphemeral(path);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 等待方法
     */
    private void waitLock() {

        //监听器
        IZkDataListener listener = new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {

            }

            /**
             * 节点被删除时，触发的方法
             * @param s
             * @throws Exception
             */
            @Override
            public void handleDataDeleted(String s) throws Exception {
                if (count != null) {
                    //将计数器减一
                    count.countDown();
                }
            }
        };

        //监听节点
        client.subscribeDataChanges(path, listener);

        //判断节点是否已经存在
        if (client.exists(path)) {
            //存在
            count = new CountDownLatch(1);
            //计数器没有到0，进行等待
            try {
                count.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
