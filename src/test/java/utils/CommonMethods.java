
package utils;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class CommonMethods extends PageInitializer {

    public static WebDriver driver;

    public void openBrowserAndLaunchApplication() {

        switch (ConfigReader.read("browser")){

            case "Chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                driver = new ChromeDriver();
                break;
            case "FireFox":
                driver = new FirefoxDriver();
                driver=new ChromeDriver();
                break;
            case "Edge":
                driver = new EdgeDriver();
                break;
            case "Safari":
                driver = new SafariDriver();
                break;
            default:
                throw new RuntimeException("Invalid Browser Name");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(ConfigReader.read("url"));
        initializePageObjects();
    }

    public void closeBrowser() {
        if(driver!= null) {
            driver.quit();
        }
    }

    public void sendText(String text, WebElement element){
        element.clear();
        element.sendKeys(text);
    }

    public void selectFromDropDown(WebElement dropDown, int index) {
        Select sel = new Select(dropDown);
        sel.selectByIndex(index);
    }

    public WebDriverWait getwait() {
        return new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));
    }

    public void waitForElementToBeClickAble(WebElement element) {
        getwait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public void click(WebElement element) {
        waitForElementToBeClickAble(element);
        element.click();
    }

    public JavascriptExecutor getJSExecutor(){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js;
    }

    public void jsClick(WebElement element) {
        getJSExecutor().executeScript("arguments[0].click();", element);
    }


    public byte[] takeScreenshot(String fileName){
        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] picByte = ts.getScreenshotAs(OutputType.BYTES);
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(sourceFile,
                    new File(Constants.SCREENSHOT_FILEPATH +
                            fileName + " " +
                            getTimeStamp("yyyy-MM-dd-HH-mm-ss") + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return picByte;
    }

    public String getTimeStamp(String pattern){

        //this method will return the timestamp which we will add in ss method
        Date date = new Date();
        //12-01-1992-21-32-34
        //yyyy-mm-dd-hh-mm-ss
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public void sendKeysWithVerification(WebElement element, String value) {
        if (value != null && !value.trim().isEmpty()) {
            try {
                // Wait and ensure element is interactable
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));

                // Clear existing text
                clickableElement.clear();

                // Send keys
                clickableElement.sendKeys(value);

                // Verify value was set
                String actualValue = clickableElement.getAttribute("value");
                Assert.assertEquals("Value not set correctly for element", value, actualValue);

            } catch (Exception e) {
                // Fallback to JavaScript if standard method fails
                try {
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("arguments[0].value = arguments[1];", element, value);

                    // Verify JS-set value
                    String jsSetValue = (String) js.executeScript("return arguments[0].value", element);
                    Assert.assertEquals("JS value not set correctly", value, jsSetValue);
                } catch (Exception jsError) {
                    throw new RuntimeException("Failed to send keys to element: " + jsError.getMessage());
                }
            }
        }

    }
    boolean isStandardSelect(WebElement element) {
        return element.getTagName().equalsIgnoreCase("select");
    }

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
    public static void selectDropdownOption(WebElement dropdownElement, String visibleText) {
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(visibleText);
    }
    public static void sendText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public static String getText(WebElement element) {
        return element.getText().trim();
    }


}



