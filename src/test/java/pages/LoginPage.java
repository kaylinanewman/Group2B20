package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class LoginPage extends CommonMethods {

<<<<<<< HEAD
    //object repositories

=======
>>>>>>> main
    @FindBy(id="txtUsername")
    public WebElement usernameField;

    @FindBy(id="txtPassword")
    public WebElement passwordField;

    @FindBy(id="btnLogin")
    public WebElement loginButton;

<<<<<<< HEAD
    @FindBy(id="spanMessage")
    public WebElement errorMessage;

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }






}
=======

    public LoginPage(){PageFactory.initElements(driver, this);
    }


}
>>>>>>> main
