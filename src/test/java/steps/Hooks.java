
package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.CommonMethods;
import utils.ConfigReader;
import io.cucumber.java.Scenario;

public class Hooks extends CommonMethods {

    @Before
    public void start() {
        openBrowserAndLaunchApplication();

    }

    @After
    public void end(Scenario scenario) {
        //scenario class in cucumber has complete information about the execution
        // driver.quit();
        byte[] pic;
        if (scenario.isFailed()) {
            pic = takeScreenshot("failed/" + scenario.getName());
        } else {
            pic = takeScreenshot("passed/" + scenario.getName());
        }
        scenario.attach(pic, "image/png", scenario.getName());
        closeBrowser();
    }
}


