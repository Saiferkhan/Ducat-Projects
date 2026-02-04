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

public class BackgroundClass_BDD {
	WebDriver driver;
	
	@Before
	public void setup() {
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	@After
	public void teardown() {
		driver.quit();
		
	}
	 // ================= BACKGROUND STEPS =================

	 @Given("User is on the login Application")
	    public void user_is_on_the_login_Application() {
		 driver.findElement(By.name("username")).sendKeys("admin");
         driver.findElement(By.name("password")).sendKeys("admin123");
         driver.findElement(By.tagName("button")).click();
		 
	        System.out.println("User is on login application");
	    }

	    @And("Verify the login details")
	    public void verify_the_login_details() {
	        System.out.println("Login details are verified");
	    }

	    // ================= SCENARIO 1 =================
	    
	    @And("User verify login details carefully")
	    public void User_verify_login_details_carefully() {
	        System.out.println("User verified login details carefully");
	    }

	    // ================= SCENARIO 2 =================

	    @When("User Click on Profile")
	    public void User_Click_on_Profile() throws InterruptedException {
	    	driver.findElement(By.xpath("//img[@class=\"oxd-userdropdown-img\"]")).click();
			Thread.sleep(2000);
	    	
	    }
	    @And("User click on logout button")
	    public void User_click_on_logout_button() {
	    	driver.findElement(By.linkText("Logout")).click();
	        System.out.println("User clicked on logout button");
	    }

	    @Then("User should logged out page")
	    public void User_should_logged_out_page() {
	    	
	        System.out.println("User is logged out successfully");
	    }

	    @And("User should see homepage")
	    public void User_should_see_homepage() {
	        // Assert home page is displayed
	        System.out.println("Home page is displayed");
	    }
	}


