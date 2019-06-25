package com.wanchenyang.demo06mybatis01.param;

/**
 * @program: demo06mybatis01
 * @author: wan chenyang
 * @create: 2019-06-24 20:17
 * @description:
 * @version: 1.0
 */
public class UserParam extends PageParam
{
    private String userName;

    private String userSex;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }
}
