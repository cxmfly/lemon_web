package com.App;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;

public class bilibili_test2 {

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
        Thread.sleep(5000);

//        tv.danmaku.bili:id/agree
        try{
            //点击【登录】
            driver.findElement(MobileBy.id("tv.danmaku.bili:id/avatar")).click();
        }catch(Exception e){
            try {
                //可能会有弹窗，处理弹窗
                //随机弹窗处理，【我知道了】
                //tv.danmaku.bili:id/text3
                driver.findElement(MobileBy.id("tv.danmaku.bili:id/text3")).click();
                Thread.sleep(1000);
                //处理完弹窗后，点击【登录】
                driver.findElement(MobileBy.id("tv.danmaku.bili:id/avatar")).click();
            }catch(Exception e1){
                //可能会有弹窗，处理弹窗
                //随机弹窗处理，【登录注册解锁更多内容】
                driver.findElement(MobileBy.id("tv.danmaku.bili:id/close")).click();
                Thread.sleep(1000);
                //处理完弹窗后，点击【登录】
                driver.findElement(MobileBy.id("tv.danmaku.bili:id/avatar")).click();
            }
        }
        Thread.sleep(2000);
        //点击密码登录
        driver.findElement(MobileBy.id("android:id/button1")).click();
        Thread.sleep(2000);
        //进行登录
        driver.findElement(MobileBy.id("tv.danmaku.bili:id/username")).sendKeys("13642308714");
        driver.findElement(MobileBy.id("tv.danmaku.bili:id/userpwd")).sendKeys("cxmfly54621323");
        //勾选同意
        driver.findElement(MobileBy.id("tv.danmaku.bili:id/log_reg_checkbox")).click();
        //点击登录
        driver.findElement(MobileBy.id("tv.danmaku.bili:id/btn_login")).click();
        Thread.sleep(2000);
        //点击搜索框搜索
        driver.findElement(MobileBy.id("tv.danmaku.bili:id/expand_search")).click();
        Thread.sleep(2000);
        //输入柠檬班软件测试
        driver.findElement(MobileBy.id("tv.danmaku.bili:id/search_src_text")).sendKeys("柠檬班软件测试");
        Thread.sleep(2000);
        //回车
        KeyEvent key = new KeyEvent();
        key.withKey(AndroidKey.ENTER);
        driver.pressKey(key);

        //找到 软件测试柠檬班Pro
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"软件测试柠檬班Pro\")")).click();
        Thread.sleep(2000);
        try {
            //点击关注
            driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"关注\")")).click();
        }catch (Exception e){
            //如果已经关注 取消关注
            driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"已关注\")")).click();
            Thread.sleep(2000);
            driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"取消关注\")")).click();
            System.out.println(driver.getPageSource());
        }
        System.out.println(driver.getPageSource());






    }

}
