package com.wanchenyang.demo05jdbc02multi.model;



/**
 * @program: demo05jdbc02
 * @author: wan chenyang
 * @create: 2019-06-24 15:09
 * @description:
 * @version: 1.0
 */
public class User
{
    private Long id;
    private String name;
    private String password;
    private int age;

    public User(Long id, String name, String password, int age)
    {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }

    public User()
    {
    }

    public User(String name, String password, int age)
    {
        this.name = name;
        this.password = password;
        this.age = age;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }
}
