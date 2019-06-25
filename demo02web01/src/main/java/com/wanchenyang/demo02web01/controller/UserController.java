package com.wanchenyang.demo02web01.controller;

import com.wanchenyang.demo02web01.model.User;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
//相当于 @ResponseBody ＋ @Controller 合在⼀一起的作⽤用
//就代表这个类中所有的⽅方法都会以 JSON 的形式返回结果，也相当于 JSON 的⼀一种快捷使⽤用⽅方式
public class UserController
{
    @RequestMapping(value = "/getUser",method = RequestMethod.POST)
//    以 /getUser 的⽅方式去请求，
//method= RequestMethod.POST 是指只可以使⽤用 Post 的⽅方式去请求，如果使⽤用 Get 的⽅方式去请求的
//话，则会报 405 不不允许访问的错误。
    public User getUser()
    {
        User user = new User();
        user.setName("wcy");
        user.setAge(18);
        user.setPass("123456");
        return user;
    }
    @RequestMapping(value = "/getUserList",method = RequestMethod.GET)
    public List<User> getUserList()
    {
        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setName("wcy");
        user1.setAge(18);
        user1.setPass("123456");
        users.add(user1);

        User user2 = new User();
        user2.setName("wcy2");
        user2.setAge(18);
        user2.setPass("1234562");
        users.add(user2);
        return users;
    }


//使⽤用 URL 进行传参，这种形式的传参地址栏会更更加美观一些。
    @RequestMapping(value="get/{name}", method=RequestMethod.POST)
    public String get(@PathVariable String name) {
        return name;
    }
//    在浏览器中输入网址：http://localhost:8080/get/cy，返回：cy，说明 name 值已经成功传⼊入



//    @RequestMapping(name = "/getUser",method = RequestMethod.POST)
//    public String getUser(User user)
//    {
//        return user.getName();
//    }

//    数据校验
//    @Valid 代表此对象使用了数据校验
//    BindingResult 校验结果保存在此对象中，根据对象属性获取相关值
//    如判断校验是否通过，获取错误信息
    @RequestMapping("/saveUser")
    public void saveUser(@Valid User user, BindingResult result)
    {
        System.out.println("user:"+user);
        if(result.hasErrors())
        {
            List<ObjectError> objectErrorList = result.getAllErrors();
            for (ObjectError objectError
                    :objectErrorList
            )
            {
                System.out.println(objectError.getCode()+"-"+objectError.getDefaultMessage());
            }
        }
    }


}
