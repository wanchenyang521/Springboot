package com.wanchenyang.demo.service;

import com.wanchenyang.demo.dao.PersonDao;
import com.wanchenyang.demo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 晨阳
 * @version 1.0
 * @date 2019-06-20 17:53
 * @description
 **/
@Service
public class PersonServiceImpl
{
    @Autowired
    PersonDao personDao;
    public  Person getByUsernameAndPassword(String username, String password)
    {
        return personDao.getByUsernameAndPassword(username,password);

    }
    public Person getPerson(String username)
    {
        return personDao.getByUsername(username);
    }

    public void insertPerson(Person person)
    {
        personDao.save(person);
    }
    public void delete(Integer id)
    {
        personDao.deleteById(id);
    }



}
