package com.wanchenyang.demo01helloworld.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController
{
    @RequestMapping("/hello")
    public String hello(String name)
    {
        return "fuckWorld"+name+"热部署测试！！";
    }

}
