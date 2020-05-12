package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestCase1 {

	public static WebDriver driver;

	@BeforeSuite
	public void doLaunchBrowser() {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("http://www.google.com");

	}

	@Test
	public void verifyTitle() {

		String title = driver.getTitle();

		System.out.println("title is :" + title);

		Assert.assertEquals(title, "Google", "Title not match");

	}

	@Test
	public void verifUrl() {

		String url = driver.getCurrentUrl();

		System.out.println("Url is :" + url);
	}

	@Test
	public void getAllLinks() {

		List<WebElement> links = driver.findElements(By.tagName("a"));

		System.out.println("total links are:" + links.size());
		
		for(WebElement ele: links) {
			
			String str=ele.getAttribute("href");
			
			System.out.println("link is :"+str);
		}
	}

	@AfterSuite
	public void closeBrowser() {

		driver.quit();
	}

}
