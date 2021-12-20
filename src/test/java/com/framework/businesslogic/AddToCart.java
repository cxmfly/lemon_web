package com.framework.businesslogic;

import com.pages.GoodsDetailPage;
import com.pages.GoodsListPage;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class AddToCart {
    private WebDriver driver;
    public AddToCart(WebDriver driver){
        this.driver=driver;
    }
    public HashMap<String,Object> doAction(){
        GoodsListPage goodsListPage = new GoodsListPage(driver);
        //点击商品列表
        goodsListPage.clickGoodsList();
        //点击第一个商品
        GoodsDetailPage goodsDetailPage = goodsListPage.clickFirstGoods();
        //加入购物车
        goodsDetailPage.addToCart();
        //获取商品的名称
        String goodsTitle = goodsDetailPage.getGoodsName();
        //获取商品的价格
        //获取商品的数量
        HashMap<String,Object> hashMap = new HashMap<String,Object>();
        hashMap.put("goodsTitle",goodsTitle);

        return hashMap;

    }
}
