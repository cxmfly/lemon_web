package com.pages;

import com.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoodsDetailPage extends BasePage {
    //商品名称
    private By goodsNameBy=By.xpath("//div[@class='name-box']/div[@class='name']");
    //加入购物车
    private By addToCartBy=By.xpath("//a[@class='add-cart']");
    private WebDriver driver;

    public GoodsDetailPage(WebDriver driver){
        this.driver=driver;
    }

    public String getGoodsName(){
        return waitElementVisible(driver,goodsNameBy).getText();
    }

    public void addToCart(){
        waitElementClickable(driver,addToCartBy).click();
    }
}
