package com.wanchenyang.demo07jpa;

import com.wanchenyang.demo07jpa.model.User;
import com.wanchenyang.demo07jpa.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo07jpaApplicationTests
{

    @Test
    public void contextLoads()
    {
    }
    @Resource
    private UserRepository userRepository;
    @Test
    public void test()
    {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);
        String formatteDate = dateFormat.format(date);

        userRepository.save(new User("aa1","aa132131","aa1@qq.com","aa1",formatteDate));
        userRepository.save(new User("aa2","aa132132","aa2@qq.com","aa2",formatteDate));
        userRepository.save(new User("aa3","aa132133","aa3@qq.com","aa3",formatteDate));
        userRepository.save(new User("aa4","aa132134","aa4@qq.com","aa4",formatteDate));
//        Assert.assertEquals(9,userRepository.findAll().size());
//        Assert.assertEquals("bb",userRepository.findByUserNameOrEmail("bb","cc@qq.com").getNickName());
        userRepository.delete(userRepository.findByUserName("aa1"));
    }

}
