package dataProviderTestng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.TestUtil;


public class LoginTest {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:/mytools/chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		driver.get("https://freecrm.com/");
 

	}
	@DataProvider
	public Object[][] getData() {
		Object[][] data=TestUtil.getTestData("data");
		return data;
		
	}
	@Test(dataProvider="getData")
	public void loginTest(String username,String password) throws InterruptedException {
		WebElement loginButton=driver.findElement(By.xpath("/html/body/div[1]/header/div/nav/div[2]/div/div[3]/ul/a/span[2]"));
		loginButton.click();
		
		WebElement email=driver.findElement(By.xpath("//input[@name='email']"));
		email.sendKeys(username);
		WebElement pass=driver.findElement(By.xpath("//input[@name='password']"));
		pass.sendKeys(password);
		WebElement login=driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']"));
		login.click();
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}

}
