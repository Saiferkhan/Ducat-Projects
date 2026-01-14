package testng_demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginWith_DataProvider {
	WebDriver driver;
	@BeforeMethod (groups="smoke")
	@Parameters({"browser","url"})
	public void setup(String browser,String url) {
		
		if(browser.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		}
		else if(browser.equalsIgnoreCase("edge")) {
			
			driver=new EdgeDriver();
			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
	}
	
	@Test (dataProvider="logindata",groups="smoke",priority=1)
	public void Enter_Credentials(String username,String password) {
		
		WebElement user=driver.findElement(By.xpath("//input[@name='username']"));
		user.clear();
		user.sendKeys(username);
		
		WebElement pass=driver.findElement(By.cssSelector("input[name='password']"));
		pass.clear();
		pass.sendKeys(password);
		
		driver.findElement(By.xpath("//button[contains(@class,'login-button')]")).click();
		
		WebElement pro=driver.findElement(By.xpath("//img[@alt=\\\"profile picture\\\"]"));
		
		Assert.assertTrue(pro.isDisplayed(),"Login Successful");
	}
	
//	@Test (groups="Regression",priority=2)
//	public void Click_on_button() {
//		
//		driver.findElement(By.xpath("//button[contains(@class,'login-button')]")).click();
//		
//	}
	
	@DataProvider(name="logindata" )
	public Object [][] getdata(){
		
		return new Object[][] {
			
			{"Admin","admin123"},
			{"newadmin","admin"},
			{"Admin","new123"},
			{"new","12344"}
			
		};
		
	}
	
	@AfterMethod (groups="Functional")
	public void Browser_Close() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
 
}



