package com.wanchenyang.demo05jdbc02;

import com.wanchenyang.demo05jdbc02.model.User;
import com.wanchenyang.demo05jdbc02.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo05jdbc02ApplicationTests
{

    @Autowired
    private UserRepository userRepository;
    @Test
    public void contextLoads()
    {
    }
    @Test
//    插入数据
    public void testSave()
    {
        userRepository.save(new User("wan","123",30));
    }
//    删除数据
    @Test
    public void testDel()
    {
        userRepository.delete(2);
    }
//    修改数据
    @Test
    public void testUpdate()
    {
        userRepository.update(new User(1L,"update","123",20));
    }
//    查询一个
    @Test
    public void testQueryOne()
    {
        User user=userRepository.findById(1L);
        System.out.println(user.toString());
    }

//    查询所有
    @Test
    public void testQueryALL()
    {
        List<User> userList = userRepository.findALL();
        for (User thisUser:userList)
        {
            System.out.println(thisUser.toString());
        }
    }

}
