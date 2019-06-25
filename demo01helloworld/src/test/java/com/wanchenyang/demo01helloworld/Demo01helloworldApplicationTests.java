package com.wanchenyang.demo01helloworld;

import com.wanchenyang.demo01helloworld.controller.HelloWorldController;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo01helloworldApplicationTests
{

    @Test
    public void contextLoads()
    {
    }

    @Test
    public void hellworld()
    {
        System.out.println("helloworld");
    }


    private MockMvc mockMvc;
    @Before
    public void setUp() throws Exception
    {
        mockMvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
    }
    @Test
    public void getHello() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.post("/hello?name=cy")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("cy")));

//        抛出异常说明：期望的结果是包含“cyw”，结果返回内容是“fuckWorldcy热部署测试！！”，不符合预期。
//                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("cyw")));
//                .accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
    }


}
