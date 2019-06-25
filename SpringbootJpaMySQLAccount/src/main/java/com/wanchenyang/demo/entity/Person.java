package com.wanchenyang.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * @author 晨阳
 * @version 1.0
 * @date 2019-06-20 17:35
 * @description
 **/
@Entity
public class Person
{
    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private String password;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    @Override
    public String toString()
    {
        return "Person{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Person()
    {
    }

    public Person(String username, String password)
    {
        this.username = username;
        this.password = password;
    }
}
