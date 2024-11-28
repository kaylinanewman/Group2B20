package utils;

<<<<<<< HEAD

import pages.*;
=======
import pages.DashboardPage;
import pages.LoginPage;
>>>>>>> main

public class PageInitializer {

    public static LoginPage loginPage;
<<<<<<< HEAD
    public static AddEmployeePage addEmployeePage;
    public static EmployeeSearchPage employeeSearchPage;
    public static DashboardPage dashboardPage;
    public static ContactDetailsPage contactDetailsPage;

    public static void initializePageObjects(){
        loginPage = new LoginPage();
        addEmployeePage = new AddEmployeePage();
        employeeSearchPage = new EmployeeSearchPage();
        dashboardPage = new DashboardPage();
        contactDetailsPage=new ContactDetailsPage();
    }

}
=======
    public static DashboardPage dashboardPage;

    public static void initializePageObjects(){
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
    }
}
>>>>>>> main
