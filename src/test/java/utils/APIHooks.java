package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;

public class APIHooks {

    @Before
    public void setUp(Scenario scenario) {
        // Load configuration settings before each scenario
        RestAssured.baseURI = APIConfigReader.getBaseURI();

        // Log scenario name
        System.out.println("Starting scenario: " + scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        // Reset RestAssured base URI
        RestAssured.reset();

        // Log scenario status
        System.out.println("Scenario " + scenario.getName() + " ended with status: " + scenario.getStatus());
    }
}
