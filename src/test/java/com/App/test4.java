package com.App;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;

public class test4 {

    @Test
    public void test11() throws IOException, InterruptedException {
        //初始化配置
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName","127.0.0.1:62001");
        caps.setCapability("platformName","Android");
        caps.setCapability("appPackage","com.lemon.lemonban");
        caps.setCapability("appActivity",".activity.WelcomeActivity");
        //需要与appium建立连接
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver driver = new AndroidDriver(url,caps);

        Thread.sleep(3000);
        swipeLeft(driver,500);



    }

    //封装下拉方法，适应所有的机型
    public void swipeRight(AndroidDriver driver,int swipeTime){
        //模拟下拉操作
        //1.确定滑动起始点（426，598），滑动终止点（426，1192），坐标系统
        //1.确定滑动起始点（屏幕宽1/2，屏幕高度1/4），滑动终止点（屏幕宽1/2，屏幕高度3/4），坐标系统
        int width = driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getHeight();
        PointOption point1 = PointOption.point(width/4, height/2);
        PointOption point2 = PointOption.point(width*3/4, height/2);
        //2.通过TouchAction来模拟滑动过程
        TouchAction touchAction = new TouchAction(driver);
        //先按下，再移动，再手指释放
        //waitAction设置滑动的间隔时间
        Duration duration = Duration.ofMillis(swipeTime);
        WaitOptions waitOptions = WaitOptions.waitOptions(duration);
        touchAction.press(point1).waitAction().moveTo(point2).release().perform();

    }

    public void swipeLeft(AndroidDriver driver,int swipeTime){
        //模拟下拉操作
        //1.确定滑动起始点（426，598），滑动终止点（426，1192），坐标系统
        //1.确定滑动起始点（屏幕宽1/2，屏幕高度1/4），滑动终止点（屏幕宽1/2，屏幕高度3/4），坐标系统
        int width = driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getHeight();
        PointOption point1 = PointOption.point(width*3/4, height/2);
        PointOption point2 = PointOption.point(width/4, height/2);
        //2.通过TouchAction来模拟滑动过程
        TouchAction touchAction = new TouchAction(driver);
        //先按下，再移动，再手指释放
        //waitAction设置滑动的间隔时间
        Duration duration = Duration.ofMillis(swipeTime);
        WaitOptions waitOptions = WaitOptions.waitOptions(duration);
        touchAction.press(point1).waitAction().moveTo(point2).release().perform();

    }
}
