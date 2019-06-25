package com.wanchenyang.demo02web01.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class User
{
    @NotEmpty(message = "name不能为空")
    private String name;
    @Max(value = 100,message = "年龄不能大于100")
    @Min(value = 20,message = "年龄不能小于20")
    private int age;
    @NotEmpty(message = "密码不能为空")
    @Length(min = 6,message = "密码长度不能小于6")
    private String pass;

    @Override
    public String toString()
    {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", pass='" + pass + '\'' +
                '}';
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getPass()
    {
        return pass;
    }

    public void setPass(String pass)
    {
        this.pass = pass;
    }

    public User()
    {
    }

    public User(String name, int age, String pass)
    {
        this.name = name;
        this.age = age;
        this.pass = pass;
    }
}
