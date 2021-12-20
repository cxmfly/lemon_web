package com.App;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;

public class test3 {

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
//        swipdown(driver,500);

        //多次连续滑动
//        driver.findElement(MobileBy.AccessibilityId("题库")).click();
//        Thread.sleep(1000);
//        PointOption point1 = PointOption.point(178, 465);
//        PointOption point2 = PointOption.point(706, 465);
//        PointOption point3 = PointOption.point(178, 1000);
//        PointOption point4 = PointOption.point(706, 1000);
//        TouchAction touchAction = new TouchAction(driver);
//        touchAction.press(point1).moveTo(point2).moveTo(point3).moveTo(point4).release().perform();

        //多点手势操作  图片放大  缩小
        //核心点：一根手指代表一个TouchAction
        //放大效果模拟
        /*driver.findElement(MobileBy.AccessibilityId("题库")).click();

        PointOption pointA = PointOption.point(368, 565);
        PointOption pointB = PointOption.point(561, 1102);
        PointOption pointC = PointOption.point(722, 1307);
        PointOption pointD = PointOption.point(173, 330);
        //通过touchAction1模拟A-->D
        TouchAction touchAction1 = new TouchAction(driver);
        touchAction1.press(pointA).moveTo(pointD).release();
        //通过touchAction1模拟B-->C
        TouchAction touchAction2 = new TouchAction(driver);
        touchAction2.press(pointB).moveTo(pointC).release();
        //同时执行两根手指的操作
        MultiTouchAction multiTouchAction = new MultiTouchAction(driver);
        multiTouchAction.add(touchAction1);
        multiTouchAction.add(touchAction2);
        multiTouchAction.perform();*/
    }

    //封装下拉方法，适应所有的机型
    public void swipdown(AndroidDriver driver,int swipeTime){
        //模拟下拉操作
        //1.确定滑动起始点（426，598），滑动终止点（426，1192），坐标系统
//        //1.确定滑动起始点（426，598），滑动终止点（426，1192），坐标系统
//        PointOption point1 = PointOption.point(426, 598);
//        PointOption point2 = PointOption.point(426, 1192);

        //1.确定滑动起始点（426，598），滑动终止点（426，1192），坐标系统
        //1.确定滑动起始点（屏幕宽1/2，屏幕高度1/4），滑动终止点（屏幕宽1/2，屏幕高度3/4），坐标系统
        int width = driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getHeight();
        PointOption point1 = PointOption.point(width/2, height/4);
        PointOption point2 = PointOption.point(width/2, height*3/4);
        //2.通过TouchAction来模拟滑动过程
        TouchAction touchAction = new TouchAction(driver);
        //先按下，再移动，再手指释放
        //waitAction设置滑动的间隔时间
        Duration duration = Duration.ofMillis(swipeTime);
        WaitOptions waitOptions = WaitOptions.waitOptions(duration);
        touchAction.press(point1).waitAction().moveTo(point2).release().perform();

    }
}
