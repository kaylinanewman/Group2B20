package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class APIConfigReader {
    private static final Properties properties = new Properties();
    private static final String DEFAULT_BASE_URI = "http://hrm.syntaxtechs.net/syntaxapi/api";

    static {
        try (InputStream inputStream = APIConfigReader.class.getClassLoader().getResourceAsStream("Config/config.properties")) {
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new RuntimeException("Config file not found");
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config properties", e);
        }
    }

    public static String getBaseURI() {
        return properties.getProperty("BASE_URI", DEFAULT_BASE_URI);
    }

    public static String getEndpoint() {
        return properties.getProperty("ENDPOINT");
    }
}
