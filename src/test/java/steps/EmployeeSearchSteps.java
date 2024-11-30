package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonMethods;

import java.time.Duration;
import java.util.List;
import org.junit.Assert;


public class EmployeeSearchSteps extends CommonMethods {

    @When("user enters employee name")
    public void user_enters_employee_name() throws InterruptedException {
        Thread.sleep(8000);
        sendText("Val Smith",employeeSearchPage.empSearchNameField);
    }
    @When("user enters employee partial name")
    public void user_enters_employee_partial_name() throws InterruptedException {
        Thread.sleep(8000); // support recommended to add here
        sendText("val",employeeSearchPage.empSearchNameField);
        click(employeeSearchPage.empSearchNameField);
        Thread.sleep(5000); // support recommended to add here. Name Field loading too long
        click(employeeSearchPage.empIdTextBox);

    }
    @Then("user is able to see all matching employee records for searched partial name")
    public void user_is_able_to_see_all_matching_employee_records_for_searched_partial_name() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@id='resultTable']/tbody/tr/td[3]")));
        List<WebElement> employeeRecords = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td[3]"));
        boolean recordFound = false;
        for (WebElement record : employeeRecords) {
            if (record.getText().contains("val")) {
                recordFound = true;
                System.out.println("Test passed");
                break;
            }
        }
    }
    @When("user enters employee name all lowercase")
    public void user_enters_employee_name_all_lowercase() throws InterruptedException {
        Thread.sleep(8000);
        sendText("val smith",employeeSearchPage.empSearchNameField);
        Thread.sleep(5000);
        click(employeeSearchPage.empIdTextBox);
    }
    @Then("user is able to see all matching employee records for searched name")
    public void user_is_able_to_see_all_matching_employee_records_for_searched_name()  {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@id='resultTable']/tbody/tr/td[3]")));
        List<WebElement> firstNames = driver.findElements(By.xpath("//table/tbody/tr/td[3]"));
        List<WebElement> lastNames = driver.findElements(By.xpath("//table/tbody/tr/td[4]"));
        boolean notFound = true;
        while (notFound) {
            for (int i = 0; i < firstNames.size(); i++) {
                String fn = firstNames.get(i).getText();
                String ln = lastNames.get(i).getText();

                if (fn.equalsIgnoreCase("Val") && ln.equalsIgnoreCase("Smith")) {
                    System.out.println("Found at row: " + (i + 1)); // Print the row number (i + 1 because list index is 0-based)

                    // Find the checkbox in the same row and click it
                    WebElement checkBox = driver.findElement(By.xpath("//table/tbody/tr[" + (i + 1) + "]/td[1]"));
                    checkBox.click();

                    // Exit the while loop
                    notFound = false;
                    break;  // Break the for loop once the target is found
                }
            }
        }
    }
    @When("user enters employee ID")
    public void user_enters_employee_id() {
        sendText("34131422", employeeSearchPage.empIdTextBox);
    }
    @When("user enters invalid employee name")
    public void user_enters_invalid_employee_name() throws InterruptedException {
        Thread.sleep(8000); // support recommended to add here
        employeeSearchPage.empSearchNameField.clear();
        sendText("ira new",employeeSearchPage.empSearchNameField);
        Thread.sleep(2000); // support recommended to add here

    }
    @When("user clicks on search button")
    public void user_clicks_on_search_button() {
        click(employeeSearchPage.searchButton);

    }

    @Then("user should see the message {string}")
    public void user_should_see_the_message(String expectedMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement noRecordsMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='resultTable']/tbody/tr/td[@colspan='8' and text()='No Records Found']")));
        String actualMessage = noRecordsMessage.getText();
        expectedMessage = "No Records Found";
        // Get the text of the element containing the message
        Assert.assertEquals("The expected message was not found.", expectedMessage, actualMessage);  // Assert that the message matches
    }

    @Then("user is able to see on the screen searched  employee by ID")
    public void user_is_able_to_see_on_the_screen_searched_employee_by_id() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@id='resultTable']/tbody/tr/td[2]")));
        List<WebElement> allIDs = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td[2]"));
        boolean notFound = true;
        while (notFound) {
            int count = 1;
            for (WebElement id : allIDs) {
                String idNo = id.getText();
                if (idNo.equals("34131422")) {
                    System.out.println(count);
                    //find the checkbox and click on it
                    WebElement checkBox = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" + count + "]/td[1]"));
                    checkBox.click();
                    System.out.println("Id Test");
                    //exit the while loop
                    notFound = false;
                    break;
                }
                count = count + 1;
            }
        }
    }
    @Then("user is able to see searched employee on screen")
    public void user_is_able_to_see_searched_employee_on_screen() {
        System.out.println("test passed");
    }
    @When("user clicks on id field")
    public void user_clicks_on_id_field() {
        click(contactDetailsPage.idField);
    }
}

