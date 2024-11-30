package utils;

import org.json.JSONObject;

public class APIPayloadConstants {
    // Common Payload Fields
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";

    public static String createUserJsonPayloadDynamic
            (String name,
             String email,
             String password) {
        JSONObject obj = new JSONObject();
        obj.put("name", name);
        obj.put("email", email);
        obj.put("password", password);
        return obj.toString();
    }


    public static String createTokenPayload(){
        String createTokenPayload="{\n" +
                "  \"email\": \"berry@gmail.com\",\n" +
                "  \"password\": \"berry12345\"\n" +
                "}";
        return createTokenPayload;
    }

    public static String createTokenPayloadDynamic
            (String email, String password){
        JSONObject obj = new JSONObject();
        obj.put("email",email);
        obj.put("password",password);
        return obj.toString();
    }


    public static String createEmployeePayload(){
        String createEmployeePayload = "{\n" +
                "  \"emp_firstname\": \"Maria\",\n" +
                "  \"emp_lastname\": \"Smith\",\n" +
                "  \"emp_middle_name\": \"A\",\n" +
                "  \"emp_gender\": \"F\",\n" +
                "  \"emp_birthday\": \"2000-01-12\",\n" +
                "  \"emp_status\": \"permanent\",\n" +
                "  \"emp_job_title\": \"Tester\"\n" +
                "}";
        return createEmployeePayload;
    }

    public static String createEmployeePayloadIncorrectBDayFormat(){
        String createEmployeePayload = "{\n" +
                "  \"emp_firstname\": \"Maria\",\n" +
                "  \"emp_lastname\": \"Smith\",\n" +
                "  \"emp_middle_name\": \"A\",\n" +
                "  \"emp_gender\": \"F\",\n" +
                "  \"emp_birthday\": \"12/01/2000\",\n" +
                "  \"emp_status\": \"permanent\",\n" +
                "  \"emp_job_title\": \"Tester\"\n" +
                "}";
        return createEmployeePayload;
    }

    public static String createEmployeePayloadInvalidGenderField(){
        String createEmployeePayload = "{\n" +
                "  \"emp_firstname\": \"Maria\",\n" +
                "  \"emp_lastname\": \"Smith\",\n" +
                "  \"emp_middle_name\": \"A\",\n" +
                "  \"emp_gender\": \"S\",\n" +
                "  \"emp_birthday\": \"2000-01-12\",\n" +
                "  \"emp_status\": \"permanent\",\n" +
                "  \"emp_job_title\": \"Tester\"\n" +
                "}";
        return createEmployeePayload;
    }


    public static String createEmployeePayloadEmptyField(){
        String createEmployeePayload = "{\n" +
                "  \"emp_firstname\": \"\",\n" +
                "  \"emp_lastname\": \"Smith\",\n" +
                "  \"emp_middle_name\": \"A\",\n" +
                "  \"emp_gender\": \"S\",\n" +
                "  \"emp_birthday\": \"2000-01-12\",\n" +
                "  \"emp_status\": \"permanent\",\n" +
                "  \"emp_job_title\": \"Tester\"\n" +
                "}";
        return createEmployeePayload;
    }

    public static String createEmployeeJsonPayloadDynamic
            (String emp_firstname,
             String emp_lastname,
             String emp_middle_name,
             String emp_gender,
             String emp_birthday,
             String emp_status,
             String emp_job_title){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname",emp_firstname);
        obj.put("emp_lastname",emp_lastname);
        obj.put("emp_middle_name",emp_middle_name);
        obj.put("emp_gender",emp_gender);
        obj.put("emp_birthday",emp_birthday);
        obj.put("emp_status",emp_status);
        obj.put("emp_job_title",emp_job_title);
        return obj.toString();
    }

}
