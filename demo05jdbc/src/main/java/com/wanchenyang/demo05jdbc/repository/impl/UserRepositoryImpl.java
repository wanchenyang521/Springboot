package com.wanchenyang.demo05jdbc.repository.impl;

import com.wanchenyang.demo05jdbc.entity.User;
import com.wanchenyang.demo05jdbc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository
{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int save(User user)
    {
        int i = jdbcTemplate.update("insert into users(name,password,age) value (?,?,?)",
                user.getName(),user.getAge(),user.getAge());
        return i;
    }

    @Override
    public int update(User user)
    {
        int i = jdbcTemplate.update("update users set name = ? , password = ? , age = ? where id= ?",
                user.getName(),user.getPassword(),user.getAge(),user.getId());
        return i;
    }

    @Override
    public int delete(long id)
    {
        int i = jdbcTemplate.update("delete from users where id = ?",id);
        return i;
    }

    @Override
    public List<User> findALL()
    {
//        List<User> userList = jdbcTemplate.query("select * form users",new BeanPropertyRowMapper<>(User.class));
        List<User> userList = jdbcTemplate.query("select * from users",new UserRowMapper());
        return userList;
    }

    @Override
    public User findById(long id)
    {
        User user = jdbcTemplate.queryForObject("select * from users where id = ?",
                new Object[]{id},new BeanPropertyRowMapper<User>(User.class));
//        对返回的数据进行封装，它可自动
//将一行数据映射到指定类的实例中，首先将这个类实例化，然后通过名称匹配的方式，映射到属性中去。
        return user;
    }


     class UserRowMapper implements RowMapper<User>
    {
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
