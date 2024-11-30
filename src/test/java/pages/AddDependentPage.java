package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;


public class AddDependentPage extends CommonMethods {

    @FindBy(id="menu_pim_viewEmployeeList")
    public WebElement employeeListOption;

    @FindBy(id="empsearch_id")
    public WebElement employeeIDField;

    @FindBy(id="searchBtn")
    public WebElement searchBtn;

    @FindBy(xpath = "//table/tbody/tr/td[2]")
    public WebElement desiredId;

    @FindBy(xpath = "//a[text()=\"Dependents\"]")
    public WebElement dependentsButton;

    @FindBy(xpath = "//h1[text()=\"Personal Details\"]")
    public WebElement personalDetailsDisplay;

    @FindBy(id="btnAddDependent")
    public WebElement addButton;

    @FindBy(id="dependent_name")
    public WebElement dependentNameField;

    @FindBy(id="dependent_relationshipType")
    public WebElement dependentRelationshipField;

    @FindBy(id="dependent_relationshipType")
    public WebElement DD;

    @FindBy(xpath="//select[@class='ui-datepicker-month']")
    public WebElement monthDD;

    @FindBy(xpath="//select[@class='ui-datepicker-year']")
    public WebElement yearDD;

    @FindBy(id="btnSaveDependent")
    public WebElement saveButton;

    @FindBy(xpath="//a[@class='messageCloseButton']")
    public WebElement successfulySavedCloseButton;

    @FindBy(id="dependent_list")
    public WebElement createdDependentList;

    @FindBy(xpath="//span[text()='Required']")
    public WebElement requiredMessage;

    @FindBy(xpath="//*[@id=\"frmEmpDependent\"]/fieldset/ol/li[2]/span")
    public WebElement relationshipRequiredMessage;

    @FindBy(id="delDependentBtn")
    public WebElement deleteBtn;

    @FindBy(xpath ="//*[@id=\"listing\"]/div[2]/div/a")
    public WebElement succesfullyDeletedCloseBtn;

    @FindBy(xpath ="//table/tbody/tr[count]/td[1]")
    public WebElement selectDependentCheckBox;

    @FindBy(xpath = "//input[@name='dependent[relationship]']")
    public WebElement specifyRelationshipTab;

    @FindBy(xpath ="//*[@id=\"dependent_relationshipType\"]")
    public WebElement relationshipTab;


    @FindBy(id="dependent_dateOfBirth")
    public WebElement dobTab;

    public AddDependentPage(){
        PageFactory.initElements(driver,this);
    }

}
