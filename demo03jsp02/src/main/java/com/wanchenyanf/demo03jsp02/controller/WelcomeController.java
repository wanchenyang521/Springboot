package com.wanchenyanf.demo03jsp02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.Map;

@Controller
public class WelcomeController
{
    @GetMapping("/")
    public String welcomeController(Map<String,Object> map)
    {
        map.put("time",new Date());
        map.put("message","fuck World");
        return "welcome";
    }
}
