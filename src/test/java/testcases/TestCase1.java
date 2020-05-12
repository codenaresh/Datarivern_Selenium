package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase1 {

	@Test
	public void verifyTitle() {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("http://www.google.com");

		String title = driver.getTitle();
		
		System.out.println("title is :"+title);
		
		Assert.assertEquals(title,"Google","Title not match");
		
		driver.quit();

	}

}
