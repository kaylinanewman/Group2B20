package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.CommonMethods;
import utils.ConfigReader;

public class Hooks extends CommonMethods {

    @Before
    public void start() {
        if (driver == null) {
            driver = openBrowserAndNavigateToURL(ConfigReader.getProperty("url"));
            System.out.println("🌟✨ Starting the browser... Brace yourself, adventure awaits! 🕵️‍♂️✨🌟");
        }
    }
    @After
        public void end () {
            if (driver != null) {
                closeBrowser();
                driver = null;
                System.out.println("🚀💥🛸 Closing the browser... Hope it had a smooth ride! 🛸💥🚀");
            }
        }
    }
