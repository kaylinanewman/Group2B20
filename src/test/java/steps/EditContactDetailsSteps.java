package steps;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonMethods;



import java.time.Duration;




public class EditContactDetailsSteps extends CommonMethods {
    public  void selectFromDropdown(WebElement dropdown, String visibleText) {
        if (isStandardSelect(dropdown)) {

            Select select = new Select(dropdown);
            select.selectByVisibleText(visibleText);
        } else {

            click(dropdown);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(@class, 'dropdown') or contains(@class, 'select')]//li[text()='" + visibleText + "']")));
            click(option);
        }
    }

     boolean isStandardSelect(WebElement element) {
        return element.getTagName().equalsIgnoreCase("select");
    }





    @When("user clicks on id field")
    public void user_clicks_on_id_field() {
     click(contactDetailsPage.idField);
    }


    @Then("user clicks the Contact Details section")
    public void user_clicks_the_contact_details_section() {
        click(contactDetailsPage.contactDetailsMenu);
    }


    @When("user clicks on edit button")
    public void user_clicks_on_edit_button() {
      //  WebElement editButton= driver.findElement(By.xpath("//input[@value='Edit']"));
        click(contactDetailsPage.editButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }



    @Then("user updates his common information with the following details: {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string}")
    public void user_updates_his_common_information_with_the_following_details_and_and_and_and_and_and_and_and_and_and(
            String addressStreet1, String addressStreet2, String city, String state,
            String zipCode, String country, String homePhone, String mobilePhone,
            String workPhone, String workEmail, String otherEmail) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        sendText(addressStreet1, wait.until(ExpectedConditions.elementToBeClickable(contactDetailsPage.contactStreet1Field)));
        sendText(addressStreet2, wait.until(ExpectedConditions.elementToBeClickable(contactDetailsPage.contactStreet2Field)));
        sendText(city, wait.until(ExpectedConditions.elementToBeClickable(contactDetailsPage.contactCityField)));

        sendText(zipCode, wait.until(ExpectedConditions.elementToBeClickable(contactDetailsPage.contactZipCodeField)));

        WebElement countryDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("contact_country")));
        selectFromDropdown(countryDropdown, country);


        WebElement stateDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("contact_state"))); // adjust the locator as needed
        selectFromDropdown(stateDropdown, state);


        sendText(homePhone, wait.until(ExpectedConditions.elementToBeClickable(contactDetailsPage.contactHomeTelephoneField)));
        sendText(mobilePhone, wait.until(ExpectedConditions.elementToBeClickable(contactDetailsPage.contactMobilePhoneField)));
        sendText(workPhone, wait.until(ExpectedConditions.elementToBeClickable(contactDetailsPage.contactWorkTelephonePhoneField)));
        sendText(workEmail, wait.until(ExpectedConditions.elementToBeClickable(contactDetailsPage.contactWorkEmailField)));
        sendText(otherEmail, wait.until(ExpectedConditions.elementToBeClickable(contactDetailsPage.contactOtherEmailField)));


        click(contactDetailsPage.saveButton);
        }





    @Then("the contact information should be updated successfully")
    public void the_contact_information_should_be_updated_successfully() {
        String expectedStreet1 = "2630 Ocean Ave";
        String expectedStreet2 = "Apt A4";
        String expectedCity = "Brooklyn";
        String expectedState = "NY";
        String expectedZipCode = "11229";
        String expectedCountry = "US";
        String expectedHomeTelephone = "123-456-7890";
        String expectedMobilePhone = "987-654-3210";
        String expectedWorkTelephone = "456-789-0123";
        String expectedWorkEmail = "nick@gmail.com";
        String expectedOtherEmail = "nick@aol.com";

        // Retrieve actual values directly from the WebElements
        String actualStreet1 = contactDetailsPage.contactStreet1Field.getAttribute("value");
        String actualStreet2 = contactDetailsPage.contactStreet2Field.getAttribute("value");
        String actualCity = contactDetailsPage.contactCityField.getAttribute("value");
        String actualState = contactDetailsPage.contactProvinceField.getAttribute("value");
        String actualZipCode = contactDetailsPage.contactZipCodeField.getAttribute("value");
        String actualCountry = contactDetailsPage.contactCountryField.getAttribute("value");
        String actualHomeTelephone = contactDetailsPage.contactHomeTelephoneField.getAttribute("value");
        String actualMobilePhone = contactDetailsPage.contactMobilePhoneField.getAttribute("value");
        String actualWorkTelephone = contactDetailsPage.contactWorkTelephonePhoneField.getAttribute("value");
        String actualWorkEmail = contactDetailsPage.contactWorkEmailField.getAttribute("value");
        String actualOtherEmail = contactDetailsPage.contactOtherEmailField.getAttribute("value");


        // Assert the values
        Assert.assertEquals(expectedStreet1, actualStreet1);
        Assert.assertEquals(expectedStreet2, actualStreet2);
        Assert.assertEquals(expectedCity, actualCity);
        Assert.assertEquals(expectedState, actualState);
        Assert.assertEquals(expectedZipCode, actualZipCode);
        Assert.assertEquals(expectedCountry, actualCountry);
        Assert.assertEquals(expectedHomeTelephone, actualHomeTelephone);
        Assert.assertEquals(expectedMobilePhone, actualMobilePhone);
        Assert.assertEquals(expectedWorkTelephone, actualWorkTelephone);
        Assert.assertEquals(expectedWorkEmail, actualWorkEmail);
        Assert.assertEquals(expectedOtherEmail, actualOtherEmail);
    }

}
