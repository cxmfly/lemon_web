package com.pages;

import com.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoodsListPage extends BasePage {
    //商品列表
    private By goodsListBy = By.xpath("//a[text()='商品列表']");
    //第一个商品
    private By firstGoodsBy = By.xpath("//div[@class='goods-img']");

    private WebDriver driver;

    public GoodsListPage(WebDriver driver){
        this.driver=driver;
    }

    public void clickGoodsList(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        waitElementClickable(driver,goodsListBy).click();
    }

    public GoodsDetailPage clickFirstGoods(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        waitElementClickable(driver,firstGoodsBy).click();
        return new GoodsDetailPage(driver);
    }
}
