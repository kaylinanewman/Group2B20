package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class DashboardPage extends CommonMethods {

    @FindBy(css = "#dashboard-header")
    private WebElement dashboardHeader;

    @FindBy(css = "#dashboard-content")
    private WebElement dashboardContent;

    @FindBy(css = "#dashboard-footer")
    private WebElement dashboardFooter;

    public DashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getDashboardHeader() {
        return dashboardHeader.getText();
    }

    public String getDashboardContent() {
        return dashboardContent.getText();
    }

    public String getDashboardFooter() {
        return dashboardFooter.getText();
    }

    public void verifyDashboardPage() {
        Assert.assertTrue(dashboardHeader.isDisplayed());
        Assert.assertTrue(dashboardContent.isDisplayed());
        Assert.assertTrue(dashboardFooter.isDisplayed());
    }
}