package utils;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "APISteps",
        dryRun = false,
        tags = "@API_Authentication",
        plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json",
                "rerun:target/failed.txt"}
)
public class ApiRunnerTest {
}