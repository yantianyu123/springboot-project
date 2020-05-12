package com.yan.mybatis.springbootmybatis;

import com.yan.mybatis.test.bean.Admin;
import com.yan.mybatis.test.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootMybatisApplicationTests {

    @Autowired
    AdminService adminService;

    @Test
    void contextLoads() {

        List<Admin> admins = adminService.findAll();

        admins.forEach(System.out::println);

    }

    @Test
    void test(){
        Admin wangwu = adminService.selectOne("wangwu", "123456");
        
        System.out.println(wangwu);
    }

}
