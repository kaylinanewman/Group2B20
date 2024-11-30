package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.CommonMethods;
import utils.ConfigReader;
import io.cucumber.java.Scenario;

public class Hooks extends CommonMethods {

    @Before
    public void start() {
        if (driver == null) {
            driver = openBrowserAndNavigateToURL(ConfigReader.getProperty("url"));
            System.out.println("🌟✨ Starting the browser... Brace yourself, adventure awaits! 🕵️‍♂️✨🌟");
        }
    }
    @After
        public void end (Scenario scenario) {
            if (driver != null) {
                closeBrowser();
                driver = null;
                System.out.println("🚀💥🛸 Closing the browser... Hope it had a smooth ride! 🛸💥🚀");
            }

        byte[] pic;
        if(scenario.isFailed()){
            pic = takeScreenshot("failed/"+scenario.getName());
        }else{
            pic = takeScreenshot("passed/"+scenario.getName());
        }
        scenario.attach(pic,"image/png",scenario.getName());
        closeBrowser();
    }

}


