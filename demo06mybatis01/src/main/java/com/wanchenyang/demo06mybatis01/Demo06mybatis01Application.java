package com.wanchenyang.demo06mybatis01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot 启动时数据源会自动注入到 SqlSessionFactory 中，
 * 使用 SqlSessionFactory 构建SqlSessionFactory，
 * 再自动注入到 Mapper 中，最后我们直接使用 Mapper 即可
 *
 * 在启动类中添加对 Mapper 包扫描 @MapperScan，
 * Spring Boot 启动的时候会自动加载包路路径下的Mapper。
 */
@SpringBootApplication
@MapperScan("com,wanchenyang.mapper")
public class Demo06mybatis01Application
{

    public static void main(String[] args)
    {
        SpringApplication.run(Demo06mybatis01Application.class, args);
    }

}
