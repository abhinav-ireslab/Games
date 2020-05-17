package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Games {

	public static WebDriver driver;
	public static HttpsURLConnection huc = null;
	public static int rescode = 200;

	@Test
	public static void main() throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\E2E\\Desktop\\Drivers\\chromedriver.exe");
		// driver = new FirefoxDriver();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.game.tv/");

		WebElement element = driver.findElement(By.xpath("/html/body/div/section[11]/div/h3"));

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", element);

		// List <WebElement> game = (List<WebElement>)
		// driver.findElements(By.xpath("/html/body/div/section[11]/div/div[1]/ul"));

		for (WebElement game : driver.findElements(By.xpath("/html/body/div/section[11]/div/div[1]/ul"))) {

			// Print All game names
			System.out.println("List of Games: " + "\n" + game.getText());

			int elementCount = driver.findElements(By.xpath("//ul[contains(@class, 'games-list')]//li")).size();
			System.out.println(elementCount);

			for (int i = 0; i < elementCount; i++) {
				List<WebElement> elements = driver.findElements(By.xpath("//ul[contains(@class, 'games-list')]//li"));
				WebElement list = elements.get(i);
				list.click();

				System.out.println(
						"****************************************************************************************");
				Thread.sleep(2000);

				WebElement names = driver.findElement(By.xpath("//h1[contains(@class, 'heading')]"));
				System.out.println("Game name: " + names.getText());

				// Current Url
				System.out.println("Page URL: " + driver.getCurrentUrl());

				// Status Code
				huc = (HttpsURLConnection) (new URL(driver.getCurrentUrl()).openConnection());
				huc.setRequestMethod("HEAD");
				huc.connect();

				rescode = huc.getResponseCode();
				

				if (rescode == 200) {
					System.out.println("Page Status Code:" + 200);
				} else {
					System.out.println("Status Code:" + 400);
				}

				// Tournament Count
				WebElement count = driver.findElement(By.xpath("//span[contains(@class, 'count-tournaments')]"));
				System.out.println("Tournament Counr: " + count.getText());

				driver.navigate().back();

			}
		}
	}

}