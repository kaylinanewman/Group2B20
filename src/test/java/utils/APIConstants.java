package utils;

public class APIConstants {

    public static final String BASE_URI = APIConfigReader.getBaseURI();
    public static final String GENERATE_TOKEN_ENDPOINT = "/generateToken.php";
    public static final String EMAIL_PARAM = "email";
    public static final String PASSWORD_PARAM = "password";

    public static final String ERROR_EMAIL_OR_PASSWORD_INCORRECT = "Email or Password is incorrect.";
    public static final String ERROR_FILL_ALL_INPUTS = "Please fill all inputs";
}
