package com.wanchenyang.demo08jpathymeleaf.param;


import org.hibernate.validator.constraints.Length;

import javax.persistence.MapsId;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * @program: demo08jpathymeleaf
 * @author: wan chenyang
 * @create: 2019-06-23 08:43
 * @description:
 * 在处理前端业务的时候一般是使用 param 结尾的参数来处理理，
 * 在项目下新建 param 包，在 param 包下创建
 * UserParam 类接收添加用户的请求参数。
 * 另外，需要对接收的参数做校验，引入hibernate-validator 做校验。
 * @version: 1.0
 */


public class UserParam
{

    private long id;
    @NotEmpty(message="姓名不能为空")
    private String userName;

    @NotEmpty(message="密码不能为空!")
    @Length(min=6,message="密码⻓度不能小于6位")
    private String passWord;

    @Max(value = 100, message = "年龄不能大于100岁")
    @Min(value= 18 ,message= "必须年满18岁！" )
    private int age;

    public UserParam()
    {
    }

    @Override
    public String toString()
    {
        return "UserParam{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", age=" + age +
                '}';
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

    public UserParam(@NotEmpty(message = "姓名不能为空") String userName, @NotEmpty(message = "密码不能为空") @Length(min = 6, message = "密码长度不能小于6位") String passWord, @Max(value = 100, message = "年龄不能大于100岁") @Min(value = 18, message = "必须年满18岁！") int age)
    {
        this.userName = userName;
        this.passWord = passWord;
        this.age = age;
    }

    public UserParam(long id, @NotEmpty(message = "姓名不能为空") String userName, @NotEmpty(message = "密码不能为空") @Length(min = 6, message = "密码⻓度不能小于6位") String passWord, @Max(value = 100, message = "年龄不能大于100岁") @Min(value = 18, message = "必须年满18岁！") int age)
    {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.age = age;
    }
}
