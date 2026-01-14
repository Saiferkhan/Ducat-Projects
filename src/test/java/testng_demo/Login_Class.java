package testng_demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login_Class {
	
	WebDriver driver;
	@Parameters({"browser","url"})
	@Test (groups="smoke",priority=0)
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
	
	@Test (groups="smoke",priority=1)
	public void Enter_Credentials() {
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
	}
	
	@Test (groups="Regression",priority=2)
	public void Click_on_button() {
		
		driver.findElement(By.xpath("//button[contains(@class,'login-button')]")).click();
		
	}
	
	@Test (groups="Functional",priority=3)
	public void Browser_Close() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
	}
 
}
