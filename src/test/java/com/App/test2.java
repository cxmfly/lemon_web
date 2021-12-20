package com.App;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class test2 {

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
        //id定位
//        driver.findElement(MobileBy.id("com.lemon.lemonban:id/navigation_tiku")).click();
        //accessibility id定位
        driver.findElement(MobileBy.AccessibilityId("题库")).click();
        //text定位
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"去登录\")")).click();
        Thread.sleep(1000);

        //xpath定位（App和web通用）
        driver.findElement(MobileBy.xpath("//android.widget.EditText[@text='手机号码']")).sendKeys("11111111");
        driver.findElement(MobileBy.id("com.lemon.lemonban:id/et_password")).sendKeys("1111111");

        //按键操作  返回
        //1.实例化keyevent的对象
        KeyEvent keyEvent = new KeyEvent();
        //2.1 设置按键操作为：返回
        keyEvent.withKey(AndroidKey.BACK);

        //2.2 设置按键操作为：减少音量
        //keyEvent.withKey(AndroidKey.VOLUME_DOWN);

        //3.执行对应的事件
        driver.pressKey(keyEvent);

        //截图
        File file = driver.getScreenshotAs(OutputType.FILE);
        //保存到本地
        File file2 = new File("D:\\test\\screenshot.png");
        FileUtils.copyFile(file,file2);

        //获取首页的页面名
        /*System.out.println( driver.currentActivity());
        //获取设备时间信息
        System.out.println(driver.getDeviceTime());
        //获取设备DPI，注意不是分辨率
        System.out.println(driver.getDisplayDensity());
        //获取automation name，默认为null，如果有指定automation name为uiautomator2就为对应的值
        System.out.println(driver.getAutomationName());
        //获取设备横竖屏状态，有PORTRAIT(竖屏)与LANDSCAPE(横屏)
        System.out.println(driver.getOrientation());*/
    }
}
