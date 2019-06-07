package com.panda;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class test1 {

    private final String chromdriver="/Applications/Appium.app/Contents/Resources/app/node_modules/appium/node_modules/appium-chromedriver/chromedriver/mac/chromedriver";
    private WebDriver driver=null;
    private String URL="https://kingss.xyz/";




    public void BaiduChrome() {
        System.setProperty("webdriver.chrome.driver",chromdriver);
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(URL);
        driver.manage().window().maximize();//窗口最大话
        driver.findElement(By.xpath("//*[@id=\"left-side\"]/div/nav/ul/li[1]/a")).click();
        driver.findElement(By.id("inputUsername")).sendKeys("panda");
        driver.findElement(By.id("inputPassword")).sendKeys("123456");
        driver.findElement(By.xpath("/html/body/div/div/div/form/div/div[3]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div[1]/div[2]/div[1]/div[2]/a[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/div/table/tbody/tr/td[6]/div/a[1]")).click();
        try {
            driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/button")).click();
        }catch (Exception e){
            e.printStackTrace();
        }
        String a=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/section/div/div/div[3]/div/div/div/table/thead/tr[11]/td")).getText();
        System.out.print("这是一个文本"+a);
        driver.quit();
    }
    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public String getChromdriver() {
        return chromdriver;
    }
    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public static void main(String[] args) {
        test1 t=new test1();
        t.BaiduChrome();
    }
}
