package com.framework.testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class Log4jTest {
    //初始化log4j日志对象
    private static Logger logger= Logger.getLogger(Log4jTest.class);

    @Test
    public  void test1() {
        //测试使用log4j日志框架
        logger.debug("这是debug级别的日志");
        logger.info("这是info级别的日志");
        logger.warn("这是warn级别的日志");
        logger.error("这是error级别的日志");
    }
}
