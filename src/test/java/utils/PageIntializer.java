package utils;


import pages.AddEmployeePage;
import pages.CreateLoginPage;
import pages.DashboardPage;
import pages.LoginPage;

//this class initialize the page objects and their web elements
public class PageIntializer {

    public static LoginPage loginPage;
    public static DashboardPage dashboardPage;
    public static AddEmployeePage addEmployeePage;
    public static CreateLoginPage createLoginPage;
    public static void initializePageObjects() {


        dashboardPage = new DashboardPage();
        addEmployeePage = new AddEmployeePage();
        createLoginPage = new CreateLoginPage();
    }

}