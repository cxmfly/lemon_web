package com.framework.listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListener implements IRetryAnalyzer {
    //最大重试次数
    private int maxRetryCount=1;
    //当前的重试次数
    private int currentRetryCount=0;

    @Override
    public boolean retry(ITestResult iTestResult) {
        //如果你的测试方法要重新运行的话，当前retry方法要返回true
        System.out.println("执行到了retry这里");
        //限制重试的最大次数，否则会进入死循环
        if(currentRetryCount<maxRetryCount){
            //如果当前重试次数没有达到限制，就去执行重试机制
            currentRetryCount++;
            return true;
        }else {
            return false;
        }

    }
}
