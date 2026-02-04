package stepdefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutClassBDD {
	
	WebDriver driver;
	@Before
	
	public void setup() {
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@After
	public void teardown() {
		
		driver.quit();
		
	}
	
	
	@Given("User login to the application")
	public void User_login_to_the_application() {
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.tagName("button")).click();
		
		System.out.println("User landed login page");
	}

	@When("Click on the profile picture")
	public void Click_on_the_profile_picture() throws InterruptedException {
	
		driver.findElement(By.xpath("//img[@class=\"oxd-userdropdown-img\"]")).click();
		Thread.sleep(2000);
	}
	
	@And("Click on the logout")
	public void Click_on_the_logout() {
		
		driver.findElement(By.linkText("Logout")).click();
	}
	
	@Then("User logout the apps")
	public void User_logout_the_apps() {
		
		System.out.println("User logged out successfully");
		
	}
	
	@And("back to the login page")
	public void back_to_the_login_page() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Now user is on the login page");
		
	}
}
