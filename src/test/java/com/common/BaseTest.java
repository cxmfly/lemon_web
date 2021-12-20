package com.common;

import com.framework.config.GlobalDatas;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BaseTest {
    //初始化log4j日志对象
    private static Logger logger= Logger.getLogger(BaseTest.class);

    public WebDriver driver;


    /**
     * 打开所有浏览器通用方法封装
     * @param browserName
     */
    public  void openBrowser(String browserName){
        WebDriver webDriver =null ;
        if("chrome".equalsIgnoreCase(browserName)){
            System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
            webDriver = new ChromeDriver();
            logger.info("================================打开chrome浏览器================================");
        }else if("firefox".equalsIgnoreCase(browserName)){
            System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\geckodriver.exe");
            webDriver = new FirefoxDriver();
            logger.info("================================打开firefox浏览器================================");
        }else if("ie".equalsIgnoreCase(browserName)){
            //取消IE安全设置（忽略IE的Protected Mode的设置）
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            //忽略浏览器缩放设置
            capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
            //异常三：The path to the driver executable must be set by the webdriver.ie.driver system property
            //解决方案
            System.setProperty("webdriver.ie.driver", "src\\test\\resources\\IEDriverServer.exe");
            //异常四：Unexpected error launching Internet Explorer. Protected Mode settings are not the same for all zones
            webDriver = new InternetExplorerDriver(capabilities);
            logger.info("================================打开ie浏览器================================");
        }
        driver = webDriver;
    }
    public void closeBrowser(){
        logger.info("================================关闭浏览器================================");
        driver.quit();
    }

    public void myAssertTrue(boolean condition,String assertDescription){
        logger.info("断言：【"+assertDescription+"】，条件表达式【"+condition+"】");
        Assert.assertTrue(condition);
    }

    public void myAssertEquals(String actual,String expected,String assertDescription){
        logger.info("断言：【"+assertDescription+"】，实际值【"+actual+"】期望值【"+expected+"】");
        Assert.assertEquals(actual,expected);
    }

    public void maxBrowser(){
        logger.info("================================最大化浏览器================================");
        driver.manage().window().maximize();
    }

    public void toUrl(String url){
        logger.info("================================访问网址【"+url+"】================================");
        driver.get(url);
    }
}
