package com.wanchenyang.demo04thymeleaf.controller;

import com.wanchenyang.demo04thymeleaf.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class HelloWorldController
{
//    @GetMapping("/")
//    public String index(ModelMap map)
//    {
//        map.addAttribute("message","ccccc");
//        return "hello";
//    }

    @GetMapping("/hello")
    public String hello(Map<String,Object>map)
    {
        map.put("message","aaaa");
        map.put("age",50);
        map.put("sex","male");
        return "hello";
    }

    @GetMapping("/ifhtml")
    public String ifhtml(Map<String,Object>map)
    {
        map.put("flag","yes");

        return "if";
    }

    @GetMapping("/listhtml")
    public String listhtml(Map<String,Object>map)
    {
        map.put("users",getUserList());

        return "list";
    }

    public List<User> getUserList()
    {
        List<User> userList = new ArrayList<>();
        User user1 = new User();
        user1.setPassword("123");
        user1.setUsername("wcy");

        User user2 = new User();
        user2.setPassword("1232");
        user2.setUsername("wcy2");

        userList.add(user1);
        userList.add(user2);



        return userList;
    }



}
