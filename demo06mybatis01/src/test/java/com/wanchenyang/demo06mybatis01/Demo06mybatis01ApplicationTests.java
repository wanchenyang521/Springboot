package com.wanchenyang.demo06mybatis01;

import com.wanchenyang.demo06mybatis01.enums.UserSexEnum;
import com.wanchenyang.demo06mybatis01.mapper.UserMapper;
import com.wanchenyang.demo06mybatis01.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo06mybatis01ApplicationTests
{

    @Test
    public void contextLoads()
    {
    }
    @Resource
    private UserMapper userMapper;


    @Test
    public void testUser()
    {
        userMapper.insert(new User("aa", "a123456", UserSexEnum.MAN));

    }
    @Test
    public void testInsert()  {
        userMapper.insert(new User("aa", "a123456", UserSexEnum.MAN));
        userMapper.insert(new User("bb", "b123456", UserSexEnum.WOMAN));
        userMapper.insert(new User("cc", "b123456", UserSexEnum.WOMAN));

        Assert.assertEquals(3, userMapper.getAll().size());
    }
}
