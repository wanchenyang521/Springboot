package com.wanchenyang.demo.controller;

import com.wanchenyang.demo.dao.PersonDao;
import com.wanchenyang.demo.entity.Person;
import com.wanchenyang.demo.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author 晨阳
 * @version 1.0
 * @date 2019-06-20 17:38
 * @description
 **/
@Controller
public class PersonController
{

    @Autowired
    PersonServiceImpl personService;

    @RequestMapping("/login")
    public String login(){
        return "login";
    }


    @RequestMapping("doLogin")
    public String doLogin(Person person, Map<String,Object> map)
    {
        Person person1 = personService.getByUsernameAndPassword(person.getUsername(),person.getPassword());
        if(person1 == null)
        {
            map.put("msg","登入失败");
        }
        else
        {
            map.put("msg","登入成功");
            map.put("person",person1);
            map.put("username",person1.getUsername());
            map.put("password",person1.getPassword());
        }

        return "success";
    }

    @RequestMapping("/register")
    public String regist(){
        return "register";
    }

    @RequestMapping("doRegist")
    public String doRegist(Person person, Map<String,Object> map){
        personService.insertPerson(person);
        map.put("msg","注册成功");
        map.put("person",person);
        return "success";
    }

    @RequestMapping("/delete")
    public String delete(Integer id) {
        personService.delete(id);
        return "success";
    }



//    @RequestMapping("/delete")
//    public String deletePerson(Person person,Map<String,Object> map)
//    {
//
//        if(person!=null)
//        {
//            System.out.println(person.toString());
//            personService.delete(person);
//            map.put("msg","删除成功");
//        }
//        else
//            {
//                map.put("msg","无对象");
//            }
//        return "success";
//    }
}



