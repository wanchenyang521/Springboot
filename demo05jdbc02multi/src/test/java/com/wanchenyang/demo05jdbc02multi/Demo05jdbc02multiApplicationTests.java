package com.wanchenyang.demo05jdbc02multi;

import com.wanchenyang.demo05jdbc02multi.model.User;
import com.wanchenyang.demo05jdbc02multi.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo05jdbc02multiApplicationTests
{

    @Test
    public void contextLoads()
    {
    }

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JdbcTemplate primaryJdbcTemplate;
    @Autowired
    private JdbcTemplate secondaryJdbcTemplate;
    @Test
    public void testSave()
    {
        User user = new User("smile","123",30);
        userRepository.save(user,primaryJdbcTemplate);
        userRepository.save(user,secondaryJdbcTemplate);
    }

}
