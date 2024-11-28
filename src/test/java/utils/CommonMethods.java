package utils;

import org.apache.commons.io.FileUtils;
<<<<<<< HEAD
import org.junit.Assert;
=======
>>>>>>> main
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
<<<<<<< HEAD
import org.openqa.selenium.support.ui.Select;
=======
>>>>>>> main
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class CommonMethods extends PageInitializer {

    public static WebDriver driver;

    public void openBrowserAndLaunchApplication() {
<<<<<<< HEAD
        switch (ConfigReader.read("browser")) {
=======
        switch (ConfigReader.read("browser")){
>>>>>>> main

            case "Chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
<<<<<<< HEAD
                driver = new ChromeDriver();
                break;
            case "FireFox":
                driver = new FirefoxDriver();
=======
                driver=new ChromeDriver();
                break;
            case "FireFox":
                driver=new FirefoxDriver();
>>>>>>> main
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
<<<<<<< HEAD
        //this ,method will call all the objects
=======
>>>>>>> main
        initializePageObjects();
    }

    public void closeBrowser() {
<<<<<<< HEAD
        if (driver != null) {
=======
        if(driver!= null) {
>>>>>>> main
            driver.quit();
        }
    }

<<<<<<< HEAD
    public void sendText(String text, WebElement element) {
        element.clear();
        element.sendKeys(text);
    }

    public void selectFromDropDown(WebElement dropDown, String visibleText) {
        Select sel = new Select(dropDown);
        sel.selectByVisibleText(visibleText);
    }

    public void selectFromDropDown(String value, WebElement dropDown) {
        Select sel = new Select(dropDown);
        sel.selectByValue(value);
    }

    public void selectFromDropDown(WebElement dropDown, int index) {
        Select sel = new Select(dropDown);
        sel.selectByIndex(index);
    }

    public WebDriverWait getwait() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));
        return wait;
    }

    public void waitForElementToBeClickAble(WebElement element) {
        getwait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public void click(WebElement element) {
=======
    public void sendText(String text, WebElement element){
        element.clear();
        element.sendKeys(text);
    }
    public WebDriverWait getwait(){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));
        return  wait;
    }

    public void waitForElementToBeClickAble(WebElement element){
        getwait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public void click(WebElement element){
>>>>>>> main
        waitForElementToBeClickAble(element);
        element.click();
    }

<<<<<<< HEAD

    public JavascriptExecutor getJSExecutor() {
=======
    public JavascriptExecutor getJSExecutor(){
>>>>>>> main
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js;
    }

<<<<<<< HEAD
    public void jsClick(WebElement element) {
        getJSExecutor().executeScript("arguments[0].click();", element);
    }


    public byte[] takeScreenshot(String fileName) {
        //it accepts array of byte in cucumber for the screenshot
=======
    public void jsClick(WebElement element){
        getJSExecutor().executeScript("arguments[0].click();", element);
    }

    public byte[] takeScreenshot(String fileName){
>>>>>>> main
        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] picByte = ts.getScreenshotAs(OutputType.BYTES);
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(sourceFile,
                    new File(Constants.SCREENSHOT_FILEPATH +
<<<<<<< HEAD
                            fileName + " " +
                            getTimeStamp("yyyy-MM-dd-HH-mm-ss") + ".png"));
=======
                            fileName+" "+
                            getTimeStamp("yyyy-MM-dd-HH-mm-ss")+".png"));
>>>>>>> main
        } catch (IOException e) {
            e.printStackTrace();
        }
        return picByte;
    }

<<<<<<< HEAD
    public String getTimeStamp(String pattern) {
=======
    public String getTimeStamp(String pattern){
>>>>>>> main
        //this method will return the timestamp which we will add in ss method
        Date date = new Date();
        //12-01-1992-21-32-34
        //yyyy-mm-dd-hh-mm-ss
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

<<<<<<< HEAD
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
}
=======
}
>>>>>>> main
