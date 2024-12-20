
package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "steps",
        dryRun = false,
        tags = "@namesearch",
        plugin = {"pretty", "html:target/cucumber-reports.html"}

        //plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json",
               // "rerun:target/failed.txt"}
)

public class TestRunner {
}

