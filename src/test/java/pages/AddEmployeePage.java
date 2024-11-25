package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployeePage extends CommonMethods {
    @FindBy(id="btnSave")
    public WebElement saveButton;

    @FindBy(id="logoutButton")
    public WebElement logoutButton;

    @FindBy(id = "firstName")
    public WebElement firstNameField;

    @FindBy(id = "middleName")
    public WebElement middleNameField;

    @FindBy(id = "lastName")
    public WebElement lastNameField;

    @FindBy(id = "searchSystemUser_userName")
    public WebElement usernameTxtBox;

    @FindBy(id = "searchBtn")
    public WebElement searchBtn;

    @FindBy(xpath = "//table[@id='resultTable']/tbody/tr/td[@class='left']/a")
    public WebElement searchResult;

    public AddEmployeePage(){
        PageFactory.initElements(driver, this);
    }
    }


