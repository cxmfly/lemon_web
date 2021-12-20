package com.pages;

import com.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    private By goodsNameBy = By.xpath("//a[@class='name']");
    private By AllSelectBy = By.xpath("//input[@class='checkbox default']");
    private By deleteCartBy = By.xpath("//a[text()='删除选中商品']");
//    private By confirmBy = By.cssSelector(".btn-r");
//    private By confirmBy = By.xpath("//a[@class='btn-r']");
    private By confirmBy = By.xpath("//div[@class='btns']//a[text()='删除']");
    private WebDriver driver;
    public CartPage(WebDriver driver){
        this.driver=driver;
    }
    public String getGoodsName(){
        return waitElementVisible(driver,goodsNameBy).getText();
    }

    public void deleteCart(){
//        waitElementClickable(driver,AllSelectBy).click();
//        waitElementClickable(driver,deleteCartBy).click();
//        waitElementClickable(driver,confirmBy).click();
        click(driver,AllSelectBy,"全选复选框");
        click(driver,deleteCartBy,"删除按钮");
        click(driver,confirmBy,"确认删除按钮");
    }

}
