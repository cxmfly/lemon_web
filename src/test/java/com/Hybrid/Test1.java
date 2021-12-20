package com.Hybrid;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;

public class Test1 {
    @Test
    public void test11() throws IOException, InterruptedException {
        //初始化配置
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "127.0.0.1:62001");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.lemon.lemonban");
        caps.setCapability("appActivity", ".activity.WelcomeActivity");
        //需要与appium建立连接
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver driver = new AndroidDriver(url, caps);

        Thread.sleep(3000);
        //点击【柠檬社区】
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"柠檬社区\")")).click();
        //进入到web页面【测试派】
        //切换状态  从原生页面元素状态————》切换到web页面元素状态（context）
        System.out.println(driver.getContextHandles());
        //通过context来进行切换
        //NATIVE_APP(原生APP)、WEBVIEW_com.lemon.lemonban(web页面)
        driver.context("WEBVIEW_com.lemon.lemonban");
        //定位web元素信息  点击注册
        driver.findElement(By.xpath("//a[@href='http://testingpai.com/register']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'登录')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='nameOrEmail']")).sendKeys("13642308714");
        driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("cxmfly54621323");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='verifyLogin']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='搜索帖子、标签和用户']")).sendKeys("web 自动化 API 练习和三大等待");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='搜索帖子、标签和用户']")).sendKeys(Keys.ENTER);//回车
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@rel='bookmark'][contains(text(),'web 自动化 API 练习和三大等待')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//details[@class='details articleMenuBtn']//summary")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[contains(text(),'回帖')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='vditor-ir']//pre[@placeholder='请输入回帖内容']")).sendKeys("这个是自动回帖");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='commentSubmitBtn']")).click();
        Thread.sleep(3000);

    }
}
