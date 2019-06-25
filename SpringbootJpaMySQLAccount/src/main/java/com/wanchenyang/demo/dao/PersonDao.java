package com.wanchenyang.demo.dao;

import com.wanchenyang.demo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author 晨阳
 * @version 1.0
 * @date 2019-06-20 17:39
 * @description
 **/

public interface PersonDao extends JpaRepository<Person,Integer>
{
    Person getByUsernameAndPassword(String username,String password);
    Person getByUsername(String username);
    void deleteById(Integer id);




}
