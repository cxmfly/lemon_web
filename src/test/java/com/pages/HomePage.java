package com.pages;

import com.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    //1.登录连接
    private By loginBy =By.xpath("//a[text()='登录']");
    //2.购物车
    private By cartBy=By.xpath("//span[@data-route='cart']");
    //3.登录成功的提示语
    private By tipsBy=By.xpath("//span[text()='欢迎来到柠檬班']");
    //4.用户名
    private By nicknameBy=By.xpath("//a[text()='cxmfly']");
    //5.退出登录
    private By quitBy=By.xpath("//a[text()='退出登录']");

    private WebDriver driver;

    public HomePage (WebDriver driver){
        this.driver=driver;
    }

    public LoginPage enterLoginPage(){
//        waitElementClickable(driver,loginBy).click();
        click(driver,loginBy,"登录按钮");
        return new LoginPage(driver);
    }

    public CartPage enterCartPage(){
        waitElementClickable(driver,cartBy).click();
        return new CartPage(driver);
    }

    public boolean isTipsExist(){
        return waitElementVisible(driver,tipsBy).isDisplayed();
    }

    public boolean isNicenameExist(){
        return waitElementVisible(driver,nicknameBy).isDisplayed();
    }

    public void quitLogin(){
        Actions actions = new Actions(driver);
        WebElement webElement = waitElementVisible(driver,By.xpath("//a[text()='cxmfly']"));
        actions.moveToElement(webElement).perform();
        waitElementClickable(driver,quitBy).click();
    }




}
