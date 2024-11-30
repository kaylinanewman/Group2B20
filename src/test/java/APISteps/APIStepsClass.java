package APISteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import utils.APIConstants;
import utils.APIPayloadConstants;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class APIStepsClass {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    RequestSpecification request;
    Response response;
    public static String employee_id;
    public static String message_respond;
    public static String error_message;
    public static String token;



    @Given("a request is prepared for creating a user with {string} and {string} and {string}")
    public void a_request_is_prepared_for_creating_a_user_with_and_and
            (String name, String email, String password) {
        request = given().
                header(APIConstants.HEADER_CONTENT_TYPE_KEY, APIConstants.HEADER_CONTENT_TYPE_VALUE).
                body(APIPayloadConstants.createUserJsonPayloadDynamic(name,email,password));

    }
    @When("a POST call is made to create the user")
    public void a_post_call_is_made_to_create_the_user() {
        response = request.when().post(APIConstants.CREATE_USER);
        //employee_id=response.jsonPath().getString(APIConstants.RESPONSE_EMPLOYEE_ID_PATH);
        //System.out.println(employee_id);
    }

    @Then("the {string} for this request is verified")
    public void the_for_this_request_is_verified(String string) {
        int statusCode = response.getStatusCode();
        String strCode=Integer.toString(statusCode);
        //status code from Scenario in feature file
        //compare the two values
        Assert.assertEquals(strCode,string);

        System.out.println("Status code for create user 201 is "+statusCode);

    }

    @Then("the respond {string} for creating a user is stored and values are validated")
    public void the_respond_for_creating_a_user_is_stored_and_values_are_validated(String msgPath) {
        message_respond=response.jsonPath().getString(msgPath);
        System.out.println("The message response is: "+message_respond);
        response.then().assertThat().body(APIConstants.MESSAGE,equalTo(message_respond));

    }
    //-----------------------------------------------

    @Given("a JWT bearer token is generated")
    public void a_jwt_bearer_token_is_generated() {
        request = given().
                header(APIConstants.HEADER_CONTENT_TYPE_KEY,APIConstants.HEADER_CONTENT_TYPE_VALUE).
                body(APIPayloadConstants.createTokenPayload());
        response = request.when().post(APIConstants.GENERATE_TOKEN);
        token = APIConstants.BEARER+ response.jsonPath().getString(APIConstants.TOKEN_PATH);
        System.out.println(token);
    }

    //dynamic
    @Given("a JWT bearer token is generated using {string} and {string}")
    public void a_jwt_bearer_token_is_generated_using_and(String email, String password) {
        request = given().
                header(APIConstants.HEADER_CONTENT_TYPE_KEY, APIConstants.HEADER_CONTENT_TYPE_VALUE).
                header(APIConstants.HEADER_AUTHORIZATION_KEY,token).
                body(APIPayloadConstants.createTokenPayloadDynamic(email,password));
        response = request.when().post(APIConstants.GENERATE_TOKEN);
        token = APIConstants.BEARER+ response.jsonPath().getString(APIConstants.TOKEN_PATH);




    }

    @Given("a request is prepared for creating the employee")
    public void a_request_is_prepared_for_creating_the_employee() {
        request = given().
                header(APIConstants.HEADER_CONTENT_TYPE_KEY,APIConstants.HEADER_CONTENT_TYPE_VALUE).
                header(APIConstants.HEADER_AUTHORIZATION_KEY,token).
                body(APIPayloadConstants.createEmployeePayload());
    }

    @When("a POST call is made to create the employee")
    public void a_post_call_is_made_to_create_the_employee() {
        response = request.when().post(APIConstants.CREATE_EMPLOYEE);
        employee_id=response.jsonPath().getString(APIConstants.RESPONSE_EMPLOYEE_ID_PATH);
        System.out.println(employee_id);
    }
    @Then("the status code for this request is {int}")
    public void the_status_code_for_this_request_is(Integer int1) {
        //retrieving the status code
        int statusCode = response.getStatusCode();
        String strCode=Integer.toString(statusCode);
        //status code from Scenario in feature file
        String code=Integer.toString(int1);
        //compare the two values
        Assert.assertEquals(strCode,code);

        System.out.println("Status code for create employee 201 is "+statusCode);


    }

    @Then("the respond {string} is stored and values are validated")
    public void the_respond_is_stored_and_values_are_validated(String msgPath) {
        message_respond=response.jsonPath().getString(msgPath);
        System.out.println("The message response is: "+message_respond);
        response.then().assertThat().body(APIConstants.MESSAGE,equalTo(message_respond));
    }

    @Then("the employee id {string} is stored and values are validated")
    public void the_employee_id_is_stored_and_values_are_validated(String path) {
        employee_id = response.jsonPath().getString(path);
        System.out.println("The employee id is: " + employee_id);
        response.then().assertThat().
                body(APIConstants.RESPONSE_EMPLOYEE_ID_PATH,equalTo(employee_id));
    }

    @Given("a request is prepared for creating the employee with incorrect birthday field format")
    public void a_request_is_prepared_for_creating_the_employee_with_incorrect_birthday_field_format() {
        request = given().
                header(APIConstants.HEADER_CONTENT_TYPE_KEY,APIConstants.HEADER_CONTENT_TYPE_VALUE).
                header(APIConstants.HEADER_AUTHORIZATION_KEY,token).
                body(APIPayloadConstants.createEmployeePayloadIncorrectBDayFormat());
    }
    @Then("the message {string} is stored and values are validated")
    public void the_message_is_stored_and_values_are_validated(String errorPath) {
        error_message=response.jsonPath().getString(errorPath);
        System.out.println("The error message for incorrect birthday format is: "+error_message);
        response.then().assertThat().body(APIConstants.ERROR,equalTo(error_message));
    }

    @Given("a request is prepared for creating the employee with invalid gender field")
    public void a_request_is_prepared_for_creating_the_employee_with_invalid_gender_field() {
        request = given().
                header(APIConstants.HEADER_CONTENT_TYPE_KEY,APIConstants.HEADER_CONTENT_TYPE_VALUE).
                header(APIConstants.HEADER_AUTHORIZATION_KEY,token).
                body(APIPayloadConstants.createEmployeePayloadInvalidGenderField());
    }

    @Then("the error {string} for invalid gender is stored and values are validated")
    public void the_error_for_invalid_gender_is_stored_and_values_are_validated(String error) {
        error_message=response.jsonPath().getString(error);
        System.out.println("The error message for invalid gender is: "+error_message);
        response.then().assertThat().body(APIConstants.MESSAGE,equalTo(error_message));

    }


    @Given("a request is prepared for creating the employee with empty field")
    public void a_request_is_prepared_for_creating_the_employee_with_empty_field() {
        request = given().
                header(APIConstants.HEADER_CONTENT_TYPE_KEY,APIConstants.HEADER_CONTENT_TYPE_VALUE).
                header(APIConstants.HEADER_AUTHORIZATION_KEY,token).
                body(APIPayloadConstants.createEmployeePayloadEmptyField());
    }

    @Then("the {string} {string} is stored and values are validated")
    public void the_is_stored_and_values_are_validated(String errorPath, String msgPath) {
        error_message=response.jsonPath().getString(errorPath);
        message_respond=response.jsonPath().getString(msgPath);

        System.out.println("The error is: "+error_message);
        System.out.println("The message is:"+message_respond);
        response.then().assertThat().body(APIConstants.ERROR,equalTo(error_message));
        response.then().assertThat().body(APIConstants.MESSAGE,equalTo(message_respond));

    }

    @Given("a request is prepared for creating the employee using {string}, {string}, {string},{string}, {string},{string},{string}")
    public void a_request_is_prepared_for_creating_the_employee_using
            (String firstname, String lastname, String middlename,
             String gender, String birthday, String status,
             String jobtitle) {

        request = given().
                header(APIConstants.HEADER_CONTENT_TYPE_KEY,
                        APIConstants.HEADER_CONTENT_TYPE_VALUE).
                header(APIConstants.HEADER_AUTHORIZATION_KEY,token).
                body(APIPayloadConstants.createEmployeeJsonPayloadDynamic
                        (firstname,lastname,middlename,
                                gender,birthday,status,jobtitle));
    }


}
