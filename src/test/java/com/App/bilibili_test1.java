package com.App;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;

public class bilibili_test1 {

    @Test
    public void test11() throws IOException, InterruptedException {
        //初始化配置
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName","127.0.0.1:62001");
        caps.setCapability("platformName","Android");
        caps.setCapability("appPackage","tv.danmaku.bili");
        caps.setCapability("appActivity",".ui.splash.SplashActivity");
        //在通过代码启动App的时候不清除App的数据
        caps.setCapability("noReset",true);
        //需要与appium建立连接
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver driver = new AndroidDriver(url,caps);

        //点击同意
        /*driver.findElement(MobileBy.id("tv.danmaku.bili:id/agree")).click();
        Thread.sleep(5000);
        //点击【登录】
        driver.findElement(MobileBy.id("tv.danmaku.bili:id/avatar")).click();
        Thread.sleep(2000);

        System.out.println(driver.getPageSource());
        //点击密码登录
        driver.findElement(MobileBy.id("android:id/button1")).click();*/

        //随机弹窗处理，【我知道了】
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text('我知道了')")).click();


    }

}
