package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

import java.time.Duration;

public class LoginSteps extends CommonMethods {
    private WebDriver driver;
    private LoginPage loginPage;

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver = openBrowserAndNavigateToURL(ConfigReader.getProperty("url"));
        loginPage = new LoginPage(driver);
    }

    @When("I enter the username {string}")
    public void i_enter_the_username(String username) {
        loginPage.enterUsername(username);
    }

    @And("I enter the password {string}")
    public void i_enter_the_password(String password) {
        loginPage.enterPassword(password);
    }

    @And("I click the login button")
    public void i_click_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("I should see the dashboard page")
    public void i_should_see_the_dashboard_page() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dashboardHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#dashboard-header")));
        Assert.assertTrue(dashboardHeader.isDisplayed());
    }

    @But("I should see an error message {string}")
    public void i_should_see_an_error_message(String errorMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".message.error")));
        Assert.assertTrue(errorMessageElement.getText().contains(errorMessage));
    }
}
