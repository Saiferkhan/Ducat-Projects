package stepdefinition;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "C:\\Users\\user\\eclipse-workspace\\SeleniumMavemproject1\\src\\test\\resources\\featurefile\\Login.feature", // Path to your feature files
    glue = "stepdefinition",                 // Package name where step definitions are located
    plugin = {"pretty", "html:target/cucumber-reports.html"}, // Reporting options
   // tags = "@SmokeTest",                      // Filter to run specific scenarios by tag
    dryRun = false                            // If set to true, it checks for missing step definitions without running the actual code
)



public class CucumberTestRunner {

}
