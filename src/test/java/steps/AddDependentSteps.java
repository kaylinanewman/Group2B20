package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonMethods;
import utils.Constants;
import utils.DBReader;

import java.sql.Driver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AddDependentSteps extends CommonMethods {

    @When("user enters employeeID {string} in respective field")
    public void user_enters_employee_id_in_respective_field(String trialEmpID) {
        addDependentPage.employeeIDField.sendKeys(trialEmpID);
    }

    @When("user clicks on Search button")
    public void user_clicks_on_search_button() {
        //WebElement searchBtn= driver.findElement(By.id("searchBtn"));
        //searchBtn.click();
        click(addDependentPage.searchBtn);
    }

    @When("user clicks on desired id number")
    public void user_clicks_on_desired_id_number() {
        //WebElement desiredId=driver.findElement(By.xpath("//table/tbody/tr/td[2]"));
        // desiredId.click();
        click(addDependentPage.desiredId);
    }

    @Then("user is navigated to Personal Details page")
    public void user_is_navigated_to_personal_details_page() {
        Assert.assertTrue(addDependentPage.personalDetailsDisplay.isDisplayed());
        //WebElement personalDetailsDisplay= driver.findElement(By.xpath("//h1[text()=\"Personal Details\"]"));
    }

    @Then("user clicks on Dependents button")
    public void user_clicks_on_dependents_button() {
        //WebElement dependentsButton= driver.findElement(By.xpath("//a[text()=\"Dependents\"]"));
        //dependentsButton.click();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        click(addDependentPage.dependentsButton);
    }

    @Given("user clicks on Add button")
    public void user_clicks_on_add_button() {
        click(addDependentPage.addButton);
    }

    @Then("user verifies that Name, Relationship and Date of Birth fields are displayed and editable")
    public void user_verifies_that_name_relationship_and_date_of_birth_fields_are_displayed_and_editable() {
        Assert.assertTrue(addDependentPage.dependentNameField.isDisplayed());
        Assert.assertTrue(addDependentPage.dependentNameField.isEnabled());
        Assert.assertTrue(addDependentPage.dependentRelationshipField.isDisplayed());
        Assert.assertTrue(addDependentPage.dependentRelationshipField.isEnabled());
        Assert.assertTrue(addDependentPage.dobTab.isDisplayed());
        Assert.assertTrue(addDependentPage.dobTab.isEnabled());
    }

    @When("user enters {string} number")
    public void user_enters_number(String string) {
        sendText(string,addDependentPage.employeeIDField);
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(3));
    }

    @Then("user enters {string}")
    public void user_enters(String Name) {
        sendText(Name, addDependentPage.dependentNameField);
        Constants.allNames.add(Name);

    }

    @Then("user selects {string} from dropdown menu")
    public void user_selects_from_dropdown_menu(String relationship) {
        Select sel=new Select(addDependentPage.DD);
        sel.selectByVisibleText(relationship);
    }

    @Then("user selects date of birth {string} and {string} and {string}")
    public void user_selects_date_of_birth_and_and(String year, String month, String day) {
        //selecting the month and year
        click(addDependentPage.dobTab);
        Select sel=new Select(addDependentPage.monthDD);
        sel.selectByVisibleText(month);
        Select sel1=new Select(addDependentPage.yearDD);
        sel1.selectByVisibleText(year);

//selecting the day
        List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
        for(WebElement date: dates){
            if(date.getText().equals(day)){
                date.click();
            }
        }
    }

    @Then("user clicks on Save button")
    public void user_clicks_on_save_button() {
        click(addDependentPage.saveButton);
    }

    @Then("dependent is successfully saved")
    public void dependent_is_successfully_saved() {
        Assert.assertTrue(addDependentPage.successfulySavedCloseButton.isDisplayed());
    }

    @Then("the HRMS application should clearly display the list of dependents added by the employee")
    public void the_hrms_application_should_clearly_display_the_list_of_dependents_added_by_the_employee() {

        //getting the names of the dependents found in table
        List<WebElement> allDependents=driver.findElements(By.xpath(Constants.allDependentsNameXPath));
        ArrayList<String> allDependentsText=new ArrayList<>();
        allDependents.forEach(x-> {
            String text = x.getText().trim();

            allDependentsText.add(text);


        });
        allDependentsText.forEach(System.out::println);
        System.out.println("-----------------the next is the names entered in feature file");
        Constants.allNames.forEach(System.out::println);

        Assert.assertEquals(allDependentsText,Constants.allNames);
    }

    @Then("changes are verified through database using {string}")
    public void changes_are_verified_through_database_using(String string) {
        List<Map<String, String>> data = DBReader.fetch("Select ed_name,ed_name from hs_hr_emp_dependents where emp_number='112943A'");
        System.out.println(data);

        Map<String, String> m = data.get(0);

        String value = m.get("ed_name");

        System.out.println(value);
        Assert.assertEquals(string,value);
    }

    @Then("user can see {string} error message")
    public void user_can_see_error_message(String string) {
        String actualMessage=addDependentPage.requiredMessage.getText();
        Assert.assertEquals(actualMessage,string);
        Assert.assertTrue(addDependentPage.requiredMessage.isDisplayed());
    }

    @Then("user can see {string} message")
    public void user_can_see_message(String string) {
        String actualMessage=addDependentPage.relationshipRequiredMessage.getText();
        Assert.assertEquals(actualMessage,string);
        Assert.assertTrue(addDependentPage.relationshipRequiredMessage.isDisplayed());
    }


    @Then("selects the {string} of the dependent to be deleted")
    public void selects_the_of_the_dependent_to_be_deleted(String string) {
        List<WebElement> allDependents=driver.findElements(By.xpath(Constants.allDependentsNameXPath));
//getting the line to delete
        int count=1;
        for (WebElement dependent:allDependents){
            String text = dependent.getText();
            if (text.equals(string)){
                System.out.println("Line to delete is: "+count);
                WebElement checkBox = driver.findElement(By.xpath("//table/tbody/tr[" + count + "]/td[1]"));
                click(checkBox);
            }
            count=count+1;
        }

    }
    @Then("deletes the dependent from list")
    public void deletes_the_dependent_from_list() {
        click(addDependentPage.deleteBtn);

    }
    @Then("dependent is successfully deleted")
    public void dependent_is_successfully_deleted() {
        Assert.assertTrue(addDependentPage.succesfullyDeletedCloseBtn.isDisplayed());
    }

    @Then("user selects the {string} of the dependent to be edited")
    public void user_selects_the_of_the_dependent_to_be_edited(String string) {
        List<WebElement> allDependents=driver.findElements(By.xpath(Constants.allDependentsNameXPath));
//getting the line to delete
        int count=1;
        for (WebElement dependent:allDependents){
            String text = dependent.getText();
            if (text.equals(string)){

                WebElement nameLink = driver.findElement(By.xpath("//table/tbody/tr[" + count + "]/td[2]/a"));
                click(nameLink);
                System.out.println("The line to click is :"+count);
            }

            count=count+1;

        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Edit Dependent']")));
        WebElement editDependent= driver.findElement(By.xpath("//h1[text()='Edit Dependent']"));
        Assert.assertTrue(editDependent.isDisplayed());

    }

    @Then("user selects {string} from dropdown menu to edit")
    public void user_selects_from_dropdown_menu_to_edit(String string) {
        Select sel=new Select(addDependentPage.relationshipTab);
        sel.selectByValue(string);
    }

    @Then("user {string}")
    public void user(String string) {
        sendText(string, addDependentPage.specifyRelationshipTab);
    }

    @Then("user saves the changes successfully")
    public void user_saves_the_changes_successfully() {
        click(addDependentPage.saveButton);
        Assert.assertTrue(addDependentPage.successfulySavedCloseButton.isDisplayed());

    }

}


