package com.yan.lock;

import com.yan.lock.zookeeper.component.ZookeeperLockComponent;
import com.yan.lock.zookeeper.service.ZkService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DistributedLockApplicationTests {

    @Autowired
    ZookeeperLockComponent zkComponent;

    @Autowired
    ZkService zkService;



}
