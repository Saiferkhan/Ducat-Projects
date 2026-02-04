package stepdefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class BDD_Datatable {
	WebDriver driver;
    //WebDriverWait wait;

    @Before
    public void setup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void teardown() {

        driver.quit();
    }
    @Given("user open the url")
    public void user_open_the_url() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @When("enter the valid (.*) and (.*)$")
    public void enter_the_valid_user_and_pass(String user, String pass) {
        driver.findElement(By.name("username")).sendKeys(user);
        driver.findElement(By.name("password")).sendKeys(pass);
    }

    @And("press the enter button")
    public void press_the_enter_button() {
        driver.findElement(By.tagName("Button")).click();
    }

    @Then("home page should display with valid data")
    public void home_page_should_display_with_valid_data() {

      WebElement profilepic =driver.findElement(By.cssSelector("[alt=\"profile picture\"]"));
      Assert.assertTrue(profilepic.isDisplayed(),"login successful");
    }

    @And("Throws erros with invalid data")
    public void throws_errors_with_invalid_data() throws InterruptedException {

         Thread.sleep(3);
       WebElement errormg=driver.findElement(By.xpath("//p['Invalid credentials']"));

       Assert.assertTrue(errormg.isDisplayed(),"unsuccessful");
    }

}