package com.wanchenyang.demo05jdbc.repository;

import com.wanchenyang.demo05jdbc.entity.User;

import java.util.List;

public interface UserRepository
{
    int save(User user);
    int update(User user);
    int delete(long id);
    List<User> findALL();
    User findById(long id);
}
