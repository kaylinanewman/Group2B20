package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.CommonMethods;
import utils.ConfigReader;

import java.time.Duration;

public class LoginSteps extends CommonMethods {

    @Given("user is able to access HRMS application")
    public void user_is_able_to_access_hrms_application() {
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @When("user enters admin username and admin password")
    public void user_enters_admin_username_and_admin_password() {
        sendText(ConfigReader.read("userName"),loginPage.usernameField);
        sendText(ConfigReader.read("password"),loginPage.passwordField);

    }
    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        click(loginPage.loginButton);
    }
    @Then("user is navigated to dashboard page or landing page")
    public void user_is_navigated_to_dashboard_page_or_landing_page() {
        Assert.assertTrue(dashboardPage.welcomeText.isDisplayed());
        System.out.println("test passed");
    }

}
