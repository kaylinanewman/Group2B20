package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import utils.CommonMethods;
import utils.ConfigReader;

import java.time.Duration;
import java.util.List;

public class LoginSteps extends CommonMethods {

    // public WebDriver driver;
    // LoginPage loginPage = new LoginPage();

    @Given("user is able to access HRMS application")
    public void user_is_able_to_access_hrms_application() {
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("user enters admin username and admin password")
    public void user_enters_admin_username_and_admin_password() {
        //WebElement usernameField = driver.findElement(By.id("txtUsername"));
        //  usernameField.sendKeys("Elsayedmasoud10");
        sendText(ConfigReader.read("userName"), loginPage.usernameField);
        //  WebElement passwordField = driver.findElement(By.id("txtPassword"));
        //  passwordField.sendKeys("vaxTo6-quncid-qyrgyj");
        sendText(ConfigReader.read("password"), loginPage.passwordField);
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        //  WebElement loginButton = driver.findElement(By.id("btnLogin"));
        //  loginButton.click();
        click(loginPage.loginButton);
    }

    @Then("user is navigated to dashbaord page")
    public void user_is_navigated_to_dashbaord_page() {
        System.out.println("test passed");
    }
}

