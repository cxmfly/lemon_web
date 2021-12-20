package com.framework.testcases;

import com.common.BaseTest;
import com.framework.businesslogic.LoginFlow;
import com.framework.config.GlobalDatas;
//import com.framework.listener.RetryListener;
import com.pages.HomePage;
import com.pages.LoginPage;
import io.qameta.allure.Description;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class LoginTest2 extends BaseTest {
    //前置用例
    //打开浏览器
    //进入登录页面
    @BeforeMethod
    @Parameters({"browserName"})
    public void beforetest(String browserName) {
        //用例前置
        //1、打开浏览器
        openBrowser(browserName);
//        driver.manage().window().maximize();
        maxBrowser();
//        driver.get(GlobalDatas.INDEX_URL);
        toUrl(GlobalDatas.INDEX_URL);
        //2、进入登录页面
        HomePage homePage = new HomePage(driver);
        homePage.enterLoginPage();

    }
    @Test()
    public void login() {
        //用例步骤
//        driver.findElement(By.xpath("//input[@placeholder='请输入手机号/用户名']")).sendKeys(GlobalDatas.USER_NAME);
//        driver.findElement(By.xpath("//input[@placeholder='请输入密码']")).sendKeys(GlobalDatas.USER_PASSWORD);
//        driver.findElement(By.xpath("//a[@class='login-button']")).click();
//        二层po模式
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.inputPhone(GlobalDatas.USER_NAME);
//        loginPage.inputPassword(GlobalDatas.USER_PASSWORD);
//        HomePage homePage = loginPage.clickButton();

//        三层po模式
        LoginFlow loginFlow = new LoginFlow(driver);
        HomePage homePage = loginFlow.login(GlobalDatas.USER_NAME, GlobalDatas.USER_PASSWORD);

        //用例断言,测试结果是否符合预期
        //1、根据主页的提示【欢迎来到柠檬班】,根据它是否有显示？？
//        Assert.assertTrue(homePage.isTipsExist());
        myAssertTrue(homePage.isTipsExist(),"【欢迎来到柠檬班】");
        //2、根据主页的用户名
//        Assert.assertTrue(homePage.isNicenameExist());
        myAssertTrue(homePage.isNicenameExist(),"主页的用户名");
        //1、退出登录
        //1-1、鼠标移动到用户名上
        //1-2、点击退出登录
        homePage.quitLogin();
    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        //用例后置

        //2、关闭浏览器
//        driver.quit();
        closeBrowser();
    }


//    @Test(dataProvider = "getLoginFailureDatas")
    @Description("手机号码10位/手机号码12位/手机号码未注册")
    public void failLogin(String phone,String pwd){
        //        三层po模式
        LoginFlow loginFlow = new LoginFlow(driver);
        HomePage homePage = loginFlow.login(phone, pwd);
        //断言
        LoginPage loginPage = new LoginPage(driver);
        String actual = loginPage.getErrorAccountPwdText();
        myAssertEquals(actual,"账号或密码不正确xx","账号密码不正确提示信息");
    }

    @DataProvider
    public Object[][] getLoginFailureDatas(){
        Object[][] datas = {
                {"13642308713","123456"},
                {"13642308715","123456"},
                {"13642308716","123456"}
        };
        return datas;
    }


}
