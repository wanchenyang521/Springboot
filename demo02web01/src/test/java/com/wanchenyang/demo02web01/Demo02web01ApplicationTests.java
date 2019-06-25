package com.wanchenyang.demo02web01;

import com.wanchenyang.demo02web01.controller.UserController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo02web01ApplicationTests
{

    @Test
    public void contextLoads()
    {
    }
    private MockMvc mockMvc;
    @Before
    public void setUp() throws Exception
    {
        mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }
    @Test
    public void getUser() throws Exception
    {
        String responseString = mockMvc.perform(MockMvcRequestBuilders.post("/getUser"))
                        .andReturn().getResponse().getContentAsString();
        System.out.println("result : "+responseString);
    }

    @Test
    public void getUserList() throws Exception
    {
        String responseString = mockMvc.perform(MockMvcRequestBuilders.post("/getUserList"))
                .andReturn().getResponse().getContentAsString();
        System.out.println("result : "+responseString);
    }

    @Test
    public void saveUsers() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.post("/saveUser")
        .param("name","")
        .param("age","666")
        .param("pass","test")
        );

    }
    @Value("${demo02web01.title}")
    private String title;
    @Test
    public void testSingle()
    {
        Assert.assertEquals(title,"晨阳啊");
    }






}
