package com.panda;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class jietu {


    private final String CHROMEPATH = "/Users/panda/Downloads/chromedriver";
    private String URL = "https://www.baidu.com";
    private final String PthotPath = "/Users/panda/Downloads/";
    private WebDriver driver = null;

    public jietu() {

    }

    public void login() {
        //登陆
        System.setProperty("webdriver.chrome.bin", CHROMEPATH);
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

    }

    public void Allscreen() {
        //全凭截图
        this.login();
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //讲截取的图片以文件的形式返回,全屏截图
        try {
            org.apache.commons.io.FileUtils.copyFile(srcFile, new File("/Users/panda/Downloads/screenshot.png")); //使用copyFile()方法保存获取到的截图文件
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        driver.quit();
    }

    public void elementPhoto() {
        //元素截图
        this.login();
        File eleFile = driver.findElement(By.id("su")).getScreenshotAs(OutputType.FILE);
        //File destination=new File("Image.png");
        try {
            org.apache.commons.io.FileUtils.copyFile(eleFile, new File("/Users/panda/Downloads/112233.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.quit();

    }

    public void LongShot() {
        this.login();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //向下拉到底//
        js.executeScript("document.documentElement.scrollTop=10000");

        BufferedImage image = null;
        try {
            image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        } catch (AWTException e) {
            e.printStackTrace();
        }
        try {
            ImageIO.write(image, "png", new File("/Users/panda/Downloads/112233.png"));
        } catch (IOException e) {

            System.out.println(e.getMessage());
        }
        driver.quit();
    }

    public static void main(String[] args) {
        jietu a = new jietu();
        //a.Allscreen();
        a.elementPhoto();
//        a.LongShot();


    }

    public String getURL() {
        return URL;
    }

    public String getCHROMEPATH() {
        return CHROMEPATH;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getPthotPath() {
        return PthotPath;
    }

}
