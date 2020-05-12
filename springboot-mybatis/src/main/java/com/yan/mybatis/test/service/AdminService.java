package com.yan.mybatis.test.service;

import com.yan.mybatis.test.bean.Admin;

import java.util.List;

/**
 * @author 闫天宇
 * @date 2020/5/12 12:47
 */
public interface AdminService {


    List<Admin> findAll();

    Admin selectOne(String loginacct,String userpswd);

}
