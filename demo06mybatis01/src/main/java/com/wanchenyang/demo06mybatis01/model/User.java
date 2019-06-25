package com.wanchenyang.demo06mybatis01.model;

import com.wanchenyang.demo06mybatis01.enums.UserSexEnum;

import java.io.Serializable;

/**
 * @program: demo06mybatis01
 * @author: wan chenyang
 * @create: 2019-06-24 19:49
 * @description:
 * @version: 1.0
 */
public class User implements Serializable
{
    private static final long serialVersionUID = 1L;
    private Long id;
    private String userName;
    private String passWord;
    private UserSexEnum userSex;
    private String nickName;

    public User(String userName, String passWord, UserSexEnum userSex)
    {
        this.userName = userName;
        this.passWord = passWord;
        this.userSex = userSex;
    }


    @Override
    public String toString()
    {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", userSex=" + userSex +
                ", nickName='" + nickName + '\'' +
                '}';
    }

    public User(String userName, String passWord, UserSexEnum userSex, String nickName)
    {
        this.userName = userName;
        this.passWord = passWord;
        this.userSex = userSex;
        this.nickName = nickName;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPassWord()
    {
        return passWord;
    }

    public void setPassWord(String passWord)
    {
        this.passWord = passWord;
    }

    public UserSexEnum getUserSex()
    {
        return userSex;
    }

    public void setUserSex(UserSexEnum userSex)
    {
        this.userSex = userSex;
    }

    public String getNickName()
    {
        return nickName;
    }

    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }

    public User()
    {
    }

    public User(Long id, String userName, String passWord, UserSexEnum userSex, String nickName)
    {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.userSex = userSex;
        this.nickName = nickName;
    }
}
