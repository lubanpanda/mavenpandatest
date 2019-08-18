package panda;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;

public class jiujiuchengfa {

	public void OpenChromeTest() {
		//String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", "/Users/panda/Downloads/chromedriver");
		ChromeOptions chromeOptions = new ChromeOptions();
//        设置为 headless 模式 （必须）
		chromeOptions.addArguments("--headless");
//        设置浏览器窗口打开大小  （非必须）
		chromeOptions.addArguments("--window-size=1920,1080");
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.get("http://www.baidu.com");
		String title = driver.getTitle();
		System.out.println(title);
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//讲截取的图片以文件的形式返回,全屏截图
		try {
			org.apache.commons.io.FileUtils.copyFile(srcFile, new File("/Users/panda/Downloads/111screenshot.png")); //使用copyFile()方法保存获取到的截图文件
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		for (int i=1;i<=9;i++) {
//			for (int a=1;a<=i;a++) {
//				System.out.print(i+"*"+a+"="+i*a+"\t");
//			}System.out.println();
//		}
		new jiujiuchengfa().OpenChromeTest();
			
	}

}
