package com.wanchenyang.demo09log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo09logApplicationTests
{

    @Test
    public void contextLoads()
    {
    }


    Logger logger = LoggerFactory.getLogger(getClass()) ;
    @Test
    public void printLog()
    {
        logger.trace("trace-----------");
        logger.debug("debug-----------");
        logger.info("info-------------");
        logger.warn("warn-------------");
        logger.error("error-------------");
    }


}
