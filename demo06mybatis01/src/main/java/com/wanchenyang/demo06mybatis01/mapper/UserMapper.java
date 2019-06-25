package com.wanchenyang.demo06mybatis01.mapper;

import com.wanchenyang.demo06mybatis01.model.User;
import com.wanchenyang.demo06mybatis01.param.UserParam;

import java.util.List;

/**
 * @program: demo06mybatis01
 * @author: wan chenyang
 * @create: 2019-06-24 19:46
 * @description:
 * @version: 1.0
 */
public interface UserMapper
{
    List<User> getAll();

    List<User> getList(UserParam userParam);

    int getCount(UserParam userParam);

    User getOne(Long id);

    void insert(User user);

    int update(User user);

    int delete(Long id);

}
