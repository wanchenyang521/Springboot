package com.wanchenyang.demo08jpathymeleaf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
/**
 * @program: demo08jpathymeleaf
 * @author: wan chenyang
 * @create: 2019-06-23 08:41
 * @description: 实体类映射数据库表
 * @version: 1.0
 */
@Entity
//@Entity 表明该类 (UserEntity) 为一个实体类，它默认对应数据库中的表名是user_entity。
public class User
{
    @Id
//    @Id 标注用于声明一个实体类的属性映射为数据库的主键列。
//    该属性通常置于属性声明语句之前，可与声明语句同行，也可写在单独行上。
//    @Id标注也可置于属性的getter方法之前。
    @GeneratedValue
//    @GeneratedValue 用于标注主键的生成策略，通过strategy 属性指定。
//    默认情况下，JPA 自动选择一个最适合底层数据库的主键生成策略：SqlServer对应identity，MySQL 对应 auto increment。
    private long id;
//    @Column标记表示所持久化属性所映射表中的字段
    @Column(nullable = false,unique = true)
    private String userName;
    @Column(nullable = false)
    private String passWord;
    @Column(nullable = false)
    private int age;
    @Column(nullable = false)
    private Date regTime;

    @Override
    public String toString()
    {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", age=" + age +
                ", regTime=" + regTime +
                '}';
    }

    public User()
    {
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
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

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public Date getRegTime()
    {
        return regTime;
    }

    public void setRegTime(Date regTime)
    {
        this.regTime = regTime;
    }

    public User(String userName, String passWord, int age, Date regTime)
    {
        this.userName = userName;
        this.passWord = passWord;
        this.age = age;
        this.regTime = regTime;
    }
}
