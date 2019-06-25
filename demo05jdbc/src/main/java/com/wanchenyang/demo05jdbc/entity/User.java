package com.wanchenyang.demo05jdbc.entity;

public class User
{
    private long id;
    private String name;
    private String password;
    private int age;

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

    public User(String name, String password, int age)
    {
        this.name = name;
        this.password = password;
        this.age = age;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
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

    public User()
    {
    }

    public User(long id, String name, String password, int age)
    {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
    }
}
