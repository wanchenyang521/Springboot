package com.wanchenyang.demo05jdbc02multi.repository;

import com.wanchenyang.demo05jdbc02multi.model.User;
import org.springframework.jdbc.core.JdbcTemplate;

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
    int save(User user, JdbcTemplate jdbcTemplate);
    int delete(long id,JdbcTemplate jdbcTemplate);
    int update(User user,JdbcTemplate jdbcTemplate);

    List<User> findALL(JdbcTemplate jdbcTemplate);
    User findById(long id,JdbcTemplate jdbcTemplate);

}
