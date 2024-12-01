package utils;

import pages.*;

public class PageInitializer {

    public static LoginPage loginPage;

    public static AddEmployeePage addEmployeePage;
    public static EmployeeSearchPage employeeSearchPage;
    public static DashboardPage dashboardPage;
    public static ContactDetailsPage contactDetailsPage;
    public static JobDetailsPage jobDetailsPage;

    public static void initializePageObjects() {
        loginPage = new LoginPage();
        addEmployeePage = new AddEmployeePage();
        employeeSearchPage = new EmployeeSearchPage();
        dashboardPage = new DashboardPage();
        contactDetailsPage = new ContactDetailsPage();
        jobDetailsPage = new JobDetailsPage();
    }


}
