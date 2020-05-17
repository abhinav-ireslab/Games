package com;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Mobile {

	public static WebDriver driver;

	@Test
	public static void main() throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\E2E\\Desktop\\Drivers\\chromedriver.exe");
		// driver = new FirefoxDriver();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.t-mobile.com/business/cell-phones");
		
		/*JavascriptExecutor jse1 = (JavascriptExecutor)driver;
		jse1.executeScript("window.scrollBy(0,1000)");*/
		

		/*WebElement text = driver.findElement(By.xpath("//a[@href='/business/cell-phone/apple-iphone-xs?sku=190198793942']"));
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();",text);
		System.out.println("Success");*/

		
		driver.findElement(By.xpath("/html/body/tfb-activation-root/div[1]/div/section/div[2]/tfb-product-list/tfb-product-grid/div/tfb-virtual-scroller/div/div/div/div/span[1]/a/div[1]/h2/span[2]")).click();
		Thread.sleep(6000);
		
		try {
		Alert alt = driver.switchTo().alert();
		alt.dismiss();
		}
		finally {
			System.out.println("No Alert exist");
			
		}
		
		/*WebElement Ele = driver.findElement(By.xpath(
				"//div[contains(@class, 'plp-product-cards__inner')]/following::span[@class= 'plp-product-card__model' and text()= ' iPhone XS']"));
		Ele.click();
*/
	}

}