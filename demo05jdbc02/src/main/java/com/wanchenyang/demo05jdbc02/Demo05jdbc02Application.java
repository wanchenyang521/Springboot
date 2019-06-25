package com.wanchenyang.demo05jdbc02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * jdbc基础操作
 * 1.建立数据库
 * 2.添加依赖、配置数据源信息
 * 3.创建model
 * 4.repository 接口 增删改查
 * 5.实现接口
 * 6.测试
 */
@SpringBootApplication
public class Demo05jdbc02Application
{

    public static void main(String[] args)
    {
        SpringApplication.run(Demo05jdbc02Application.class, args);
    }

}
