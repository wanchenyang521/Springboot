package com.wanchenyang.demo08jpathymeleaf.controller;

import com.wanchenyang.demo08jpathymeleaf.Repository.UserRepository;
import com.wanchenyang.demo08jpathymeleaf.model.User;
import com.wanchenyang.demo08jpathymeleaf.param.UserParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @program: demo08jpathymeleaf
 * @author: wan chenyang
 * @create: 2019-06-23 08:48
 * @description:
 * Controller 负责接收请求
 * 首先判断参数是否正确，如果有错误直接返回⻚页面，将错误信息展示给用户
 * 再判断用户是否存在，如果用户已经存在同样返回⻚页面给出提示。
 * 验证通过后，将 UserParam 属性复制到 User并添加用户注册时间，最后将用户信息保存到数据库中
 * @version: 1.0
 */
@Controller
public class UserController
{

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public String index() {
        return "redirect:/list";
    }

//    @RequestMapping("/toAdd")
//    public String toAdd()
//    {
//        return "user/userAdd";
//    }
//    实现添加功能
    @RequestMapping("/add")
    public String add(@Valid UserParam userParam, BindingResult result, Model model)
    {
//        错误信息
        String errorMsg ="";
//        进行参数校验
        if(result.hasErrors())
        {
            List<ObjectError> errorList = result.getAllErrors();
            for(ObjectError objectError:errorList)
            {
                errorMsg = objectError.getCode()+"-"+objectError.getDefaultMessage();
            }
            model.addAttribute("errorMsg",errorMsg);
            return "user/userAdd";
        }
//        判断用户是否存在
        User u = userRepository.findByUserName(userParam.getUserName());
        if(u!=null)
        {
            model.addAttribute("errorMsg","用户已存在");
//            map.put("errorMsg",errorMsg);
            return "user/userAdd";
        }
//        增加代码
        User user = new User();
        BeanUtils.copyProperties(userParam,user);
        user.setRegTime(new Date());
        userRepository.save(user);
        return "redirect:/list";
    }

    @RequestMapping("/list")
//    @RequestParam 常⽤用来处理简单类型的绑定，注解有三个属性：value、required 和 defaultValue；
//    value 用来指定要传入值的 ID 名称
//    required 用来指示参数是否必须绑定
//    defaultValue 可以设置参数的默认值
    public String list(Model model,@RequestParam(value = "page", defaultValue = "0") Integer page,
                       @RequestParam(value = "size", defaultValue = "3") Integer size)
    {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<User> users=userRepository.findList(pageable);
        model.addAttribute("users", users);
        return "user/list";
    }

    @RequestMapping("/toEdit")
    public String toEdit(Model model,Long id)
    {
        User user = userRepository.findById((long) id);
        model.addAttribute("user", user);
        return "user/userEdit";
    }

    @RequestMapping("/edit")
    public String edit(@Valid UserParam userParam, BindingResult result,Model model) {
        String errorMsg="";
        if(result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list) {
                errorMsg=errorMsg + error.getCode() + "-" + error.getDefaultMessage() +";";
            }
            model.addAttribute("errorMsg",errorMsg);
            model.addAttribute("user", userParam);
            return "user/userEdit";
        }

        User user=new User();
        BeanUtils.copyProperties(userParam,user);
        user.setRegTime(new Date());
        userRepository.save(user);
        return "redirect:/list";
    }

    @RequestMapping("/delete")
    public String delete(Long id) {
        userRepository.deleteById(id);
        return "redirect:/list";
    }



    @RequestMapping("/toLogin")
    public String loginHtml()
    {
        return "user/login";
    }

    @RequestMapping("/login")
    public String login(@Valid UserParam userParam, BindingResult result, Model model)
    {
//        错误信息
        String errorMsg="";
        //        判断用户是否存在
        User user = userRepository.findByUserName(userParam.getUserName());
        if(user==null)
        {
            model.addAttribute("errorMsg","用户不存在");
        }
        else
        {
            User u = userRepository.findByUserNameAndPassWord(userParam.getUserName(),userParam.getPassWord());
            if(u==null)
            {
                model.addAttribute("errorMsg","密码错误");
            }
            else
            {
                model.addAttribute("user", u);
                return "user/personMsg";
            }
        }
        return "user/login";
    }


}
