package com.wanchenyang.demo05jdbc02multi.repository.impl;


import com.wanchenyang.demo05jdbc02multi.model.User;
import com.wanchenyang.demo05jdbc02multi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @program: demo05jdbc02
 * @author: wan chenyang
 * @create: 2019-06-24 15:14
 * @description:
 * @version: 1.0
 */
//用于标注数据访问组件
@Repository
public class UserRepositoryImpl implements UserRepository
{
    @Autowired
//    Spring 操作jdbc提供的工具类
    private JdbcTemplate primaryJdbcTemplate;

    @Override
    public int save(User user,JdbcTemplate jdbcTemplate)
    {
        if(jdbcTemplate==null)
        {
            jdbcTemplate = primaryJdbcTemplate;
        }
        return jdbcTemplate.update("insert into users(name,password,age) value (?,?,?)",user.getName(),user.getPassword(),user.getAge());
    }

    @Override
    public int delete(long id,JdbcTemplate jdbcTemplate)
    {
        if(jdbcTemplate==null)
        {
            jdbcTemplate = primaryJdbcTemplate;
        }
        return jdbcTemplate.update("delete from users where id=?",id);
    }

    @Override
    public int update(User user,JdbcTemplate jdbcTemplate)
    {
        if(jdbcTemplate==null)
        {
            jdbcTemplate = primaryJdbcTemplate;
        }
        return jdbcTemplate.update("update users set name=?,password=?,age=? where id=?",
                user.getName(),user.getPassword(),user.getAge(),user.getId());
    }

    @Override
    public List<User> findALL(JdbcTemplate jdbcTemplate)
    {
        if(jdbcTemplate==null)
        {
            jdbcTemplate = primaryJdbcTemplate;
        }
        return jdbcTemplate.query("select * from users",new UserRowMapper());
//        return jdbcTemplate.query("select * from users",new BeanPropertyRowMapper<User>(User.class));
    }

    @Override
    public User findById(long id,JdbcTemplate jdbcTemplate)
    {
        if(jdbcTemplate==null)
        {
            jdbcTemplate = primaryJdbcTemplate;
        }
        return jdbcTemplate.queryForObject("select * from users where id=?",new Object[]{id},new BeanPropertyRowMapper<User>(User.class));
//        new BeanPropertyRowMapper<User>(User.class)
//        对返回的数据进行封装，它可自动将一行数据映射到指定类的实例中，首先将这个类实例化，然后通过名称匹配的方式，映射到属性中去
    }

    private class UserRowMapper implements RowMapper<User>
    {
        /**
         * RowMapper
         * 接口覆盖mapRow方法，在mapRow方法封装对数据的返回处理。
         * UserRowMapper 循环遍历查询返回的结果集，遍历的同时按照属性进行赋值
         * 在查询使用时只需要传入 new UserRowMapper()即可自动解析返回数据
         */
        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException
        {
            User user = new User();
            user.setId(resultSet.getLong("id"));
            user.setName(resultSet.getString("name"));
            user.setPassword(resultSet.getString("password"));
            user.setAge(resultSet.getInt("age"));
            return user;
        }
    }
}
