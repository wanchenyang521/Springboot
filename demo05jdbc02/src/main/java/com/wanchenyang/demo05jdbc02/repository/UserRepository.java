package com.wanchenyang.demo05jdbc02.repository;

import com.wanchenyang.demo05jdbc02.model.User;

import java.util.List;

/**
 * @program: demo05jdbc02
 * @author: wan chenyang
 * @create: 2019-06-24 15:12
 * @description:
 * @version: 1.0
 */
public interface UserRepository
{
    int save(User user);
    int delete(long id);
    int update(User user);

    List<User> findALL();
    User findById(long id);

}
