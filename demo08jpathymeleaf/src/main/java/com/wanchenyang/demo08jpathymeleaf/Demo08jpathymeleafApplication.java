package com.wanchenyang.demo08jpathymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Demo08jpathymeleafApplication extends SpringBootServletInitializer
{

    public static void main(String[] args)
    {
        SpringApplication.run(Demo08jpathymeleafApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
    {
        return application.sources(Demo08jpathymeleafApplication.class);
    }
}
