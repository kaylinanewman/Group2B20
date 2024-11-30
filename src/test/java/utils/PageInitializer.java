package utils;

import pages.LoginPage;
import pages.DashboardPage;

import static utils.CommonMethods.driver;

public class PageInitializer {
    public static LoginPage loginPage;
    public static DashboardPage dashboardPage;

    public static void initialize() {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }
}
