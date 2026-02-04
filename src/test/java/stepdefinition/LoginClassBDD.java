package stepdefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginClassBDD {
	
	    WebDriver driver;

	    @Given("User is on the login page")
	   public void user_is_on_the_login_page() {
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    }

	   @When("Enter the username and password")
	   public void Enter_the_username_and_password() {
		   
		   driver.findElement(By.name("username")).sendKeys("Admin");
		   driver.findElement(By.name("password")).sendKeys("admin123");
	        
	    }

	   @And("User click on the login button")
	   public void user_click_on_the_login_button() {
	        
		   driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
	    }

	    @Then("User should see the homepage")
	    public void user_should_see_homepage() {
	        
	        }
	    @And("profile picture display")
	    public void profile_picture_display() {
	    	
	    	driver.quit();
	    }
	       
	    }
	


