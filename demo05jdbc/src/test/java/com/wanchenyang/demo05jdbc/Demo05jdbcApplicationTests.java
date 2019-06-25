package com.wanchenyang.demo05jdbc;

import com.wanchenyang.demo05jdbc.entity.User;
import com.wanchenyang.demo05jdbc.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo05jdbcApplicationTests
{

    @Test
    public void contextLoads()
    {
    }
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSave()
    {
//        增加
        User user = new User("cy","123456",19);
        userRepository.save(user);
    }
//    更新
    @Test
    public void testUpdate()
    {
        User user = new User("cy","21111",20);
        user.setId(1L);
        userRepository.update(user);
    }
//    查一个
    @Test
    public void testQueryOne()
    {
        User user = userRepository.findById(1L);
        System.out.println(user.toString());
    }
// 查询所有
    @Test
    public void testQueryAll()
    {
        List<User> userList = userRepository.findALL();
        for(User thisUser:userList)
        {
            System.out.println(thisUser.toString());
        }
    }
}

