package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class LoginPage extends CommonMethods {
    private WebDriver driver;

    @FindBy(css = "#txtUsername")
    public WebElement usernameField;

    @FindBy(css = "#txtPassword")
    public WebElement passwordField;

    @FindBy(css = "#btnLogin")
    public WebElement loginButton;

    @FindBy(id = "spanMessage")
    public WebElement errorMessage;

    public LoginPage() {
        PageFactory.initElements((org.openqa.selenium.SearchContext) null, this);
    }

   public void enterUsername(String username) {
       sendText(username,usernameField);
    }

    public void enterPassword(String password) {
       sendText(password, passwordField);
    }

    public DashboardPage clickLoginButton() {
        loginButton.click();
        return new DashboardPage();
    }
}