package com.framework.businesslogic;

import com.framework.config.GlobalDatas;
import com.pages.HomePage;
import com.pages.LoginPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class LoginFlow {
    private WebDriver driver;
    public LoginFlow(WebDriver driver){
        this.driver=driver;
    }
    public HomePage login(String phone,String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputPhone(phone);
        loginPage.inputPassword(password);
        HomePage homePage = loginPage.clickButton();
        return homePage;
    }
}
