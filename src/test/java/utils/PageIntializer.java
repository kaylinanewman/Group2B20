package utils;
import pages.LoginPage;
import pages.MembershipPage;

public class PageIntializer {

    public static LoginPage loginPage;
    public static MembershipPage MembershipPage;


    public static void initializePageObjects(){
        loginPage = new LoginPage();
        MembershipPage = new MembershipPage();



    }

}
