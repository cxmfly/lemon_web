package com.common;

import com.framework.testcases.Log4jTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    //初始化log4j日志对象
    private static Logger logger= Logger.getLogger(BasePage.class);
    /**
     * 显式等待元素可见二次封装
     * @param driver
     * @param by
     */
    public WebElement waitElementVisible(WebDriver driver, By by ){
        WebElement webElement = null;
        try{
            //1、实例化WebDriverWait 超时时间10s
            WebDriverWait webDriverWait = new WebDriverWait(driver,10);
            //2、通过until方法等到某个条件满足时为止
            webElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }catch (Exception e){
            logger.error("定位元素【"+by+"】异常");
        }
        return webElement;
    }

    /**
     * 显式等待元素可被点击二次封装
     * @param driver
     * @param by
     */
    public WebElement waitElementClickable(WebDriver driver, By by ){
        WebElement webElement =null;
        try{//1、实例化WebDriverWait 超时时间10s
            WebDriverWait webDriverWait = new WebDriverWait(driver,10);
            //2、通过until方法等到某个条件满足时为止
            webElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
        }catch (Exception e){
            logger.error("定位元素【"+by+"】异常");
        }
         return webElement;
    }

    //封装输入方法
    public void type(WebDriver driver,By by,String data,String elementName){
        logger.info("往元素【"+elementName+"】输入数据【"+data+"】");
        waitElementVisible(driver,by).sendKeys(data);
    }

    //封装点击方法
    public void click(WebDriver driver,By by,String elementName){
        logger.info("对元素【"+elementName+"】进行点击");
        waitElementClickable(driver,by).click();
    }

    public String getText(WebDriver driver,By by,String elementName){
        String text = waitElementVisible(driver, by).getText();
        logger.info("获取元素【"+elementName+"】文本【"+text+"】");
        return text;
    }
}

















