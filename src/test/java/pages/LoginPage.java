package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class LoginPage extends CommonMethods {
    private WebDriver driver;

    @FindBy(css = "#txtUsername")
    private WebElement usernameField;

    @FindBy(css = "#txtPassword")
    private WebElement passwordField;

    @FindBy(css = "#btnLogin")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements((org.openqa.selenium.SearchContext) null, this);
    }

    public void enterUsername(String username) {
        sendText(usernameField, username);
    }

    public void enterPassword(String password) {
        sendText(passwordField, password);
    }

    public DashboardPage clickLoginButton() {
        loginButton.click();
        return new DashboardPage(driver);
    }
}