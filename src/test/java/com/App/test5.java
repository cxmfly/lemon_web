package com.App;

import com.sun.org.apache.bcel.internal.generic.MONITORENTER;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;

public class test5 {

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
        driver.findElement(MobileBy.AccessibilityId("题库")).click();
        //text定位
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"去登录\")")).click();
        Thread.sleep(1000);

        //xpath定位（App和web通用）
        driver.findElement(MobileBy.xpath("//android.widget.EditText[@text='手机号码']")).sendKeys("");
        driver.findElement(MobileBy.id("com.lemon.lemonban:id/et_password")).sendKeys("");
        driver.findElement(MobileBy.id("com.lemon.lemonban:id/btn_login")).click();
        //获取toast元素【手机号码火密码不能为空】
        //显示等待，toast元素：不可见元素，在页面中存在
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        By by = MobileBy.xpath("//*[contains(@text,'手机号码或密码不能为空')]");
        WebElement webElement = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        System.out.println(webElement.getText());

    }

}
