package com.framework.testcases;

import com.common.BaseTest;
import com.framework.businesslogic.AddToCart;
import com.framework.businesslogic.LoginFlow;
import com.framework.config.GlobalDatas;
import com.pages.CartPage;
import com.pages.HomePage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.HashMap;

public class AddCartTest extends BaseTest {

    @BeforeTest
    @Parameters({"browserName"})
    public void test1(String browserName){
        //用例前置
        //打开浏览器-->登录
        openBrowser(browserName);
//        driver.manage().window().maximize();
        maxBrowser();
//        driver.get(GlobalDatas.INDEX_URL);
        toUrl(GlobalDatas.INDEX_URL);
        //2、进入登录页面
        HomePage homePage = new HomePage(driver);
        homePage.enterLoginPage();

        //三层po模式
        LoginFlow loginFlow = new LoginFlow(driver);
        loginFlow.login(GlobalDatas.USER_NAME, GlobalDatas.USER_PASSWORD);

//        driver.findElement(By.xpath("//a[text()='登录']")).click();
//        driver.findElement(By.xpath("//input[@placeholder='请输入手机号/用户名']")).sendKeys(GlobalDatas.USER_NAME);
//        driver.findElement(By.xpath("//input[@placeholder='请输入密码']")).sendKeys(GlobalDatas.USER_PASSWORD);
//        driver.findElement(By.xpath("//a[@class='login-button']")).click();
    }
    @Test
    public void Addtest1() throws InterruptedException {   //测试步骤
        //1、选择商品
        //获取商品的名称
        //2、添加到购物车
        AddToCart addToCart = new AddToCart(driver);
        HashMap<String, Object> datas = addToCart.doAction();
        //断言
        //进入到购物车
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = homePage.enterCartPage();
        //1、商品的名称
        Assert.assertEquals(cartPage.getGoodsName(),datas.get("goodsTitle"));
        //2、商品的价格
        //3、商品的数量
    }


    @AfterTest
    public void teardown() throws InterruptedException {
        //测试后置
        //删除购物车商品
//        waitElementClickable(driver,By.xpath("//input[@class='checkbox default']")).click();
//        waitElementClickable(driver,By.xpath("//a[text()='删除选中商品']")).click();
//        driver.findElement(By.cssSelector(".btn-r")).click();
        CartPage cartPage = new CartPage(driver);
        cartPage.deleteCart();

        Thread.sleep(2000);
        //1、退出登录
        //1-1、鼠标移动到用户名上、
//        Thread.sleep(5000);
//        Actions actions = new Actions(driver);
//        WebElement webElement = driver.findElement(By.xpath("//a[text()='cxmfly']"));
//        actions.moveToElement(webElement).perform();
        //1-2、点击退出登录
//        waitElementVisible(driver,By.xpath("//a[text()='退出登录']")).click();
        HomePage homePage = new HomePage(driver);
        homePage.quitLogin();
        //2、关闭浏览器
        driver.quit();
    }





}
