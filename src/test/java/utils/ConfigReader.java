package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
<<<<<<< HEAD
    public static String read(String key)  {
        return read(key, Constants.CONFIG_FILE_PATH);
    }

    public static String read(String key, String path)  {

        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(path))
        {
            properties.load(fis);
        } catch (IOException ioException) {
=======
    public static String read (String key)
    {return read(key, Constants.CONFIG_FILE_PATH);}

    public static String read(String key, String path){

        Properties properties = new Properties();
        try(FileInputStream fis = new FileInputStream(path))
        {
            properties.load(fis);
        }catch(IOException ioException){
>>>>>>> main
            ioException.printStackTrace();
        }
        return properties.getProperty(key);
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> main
