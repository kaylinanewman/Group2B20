package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenShots extends CommonMethods {

    public static void takeScreenshot(WebDriver driver, String screenshotName) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String destFilePath = "screenshots/" + screenshotName + "_" + timestamp + ".png";
            File destFile = new File(destFilePath);
            FileHandler.copy(srcFile, destFile);
            System.out.println("Screenshot taken: " + destFilePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to take screenshot: " + e.getMessage());
        }
    }

    public static void takeScreenshot(WebDriver driver) {
        takeScreenshot(driver, "screenshot");
    }
}
