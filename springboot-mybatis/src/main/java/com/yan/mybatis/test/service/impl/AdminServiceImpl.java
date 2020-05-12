package com.yan.mybatis.test.service.impl;

import com.yan.mybatis.test.bean.Admin;
import com.yan.mybatis.test.bean.AdminExample;
import com.yan.mybatis.test.mapper.AdminMapper;
import com.yan.mybatis.test.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

/**
 * @author 闫天宇
 * @date 2020/5/12 12:47
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    /**
     * 查询全部
     * @return
     */
    public List<Admin> findAll(){

        AdminExample adminExample = new AdminExample();
        //按照createtime字段降序排序
        adminExample.setOrderByClause("createtime desc");

        List<Admin> admins = adminMapper.selectByExample(adminExample);

        return admins;
    }

    /**
     * 登录
     * @param loginacct
     * @param userpswd
     * @return
     */
    @Override
    public Admin selectOne(String loginacct, String userpswd) {
        //md5加密后的密码
        String md5Userpswd = DigestUtils.md5DigestAsHex(userpswd.getBytes());

        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria c1= adminExample.createCriteria();
        c1.andLoginacctEqualTo(loginacct);
        c1.andUserpswdEqualTo(md5Userpswd);

        List<Admin> admins = adminMapper.selectByExample(adminExample);

        if(admins !=null && admins.size() > 0){
            return admins.get(0);
        }else {
            return null;
        }
    }


}
