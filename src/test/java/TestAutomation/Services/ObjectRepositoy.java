package TestAutomation.Services;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ObjectRepositoy {

    public static Properties setProperties() {
        Properties properties = new Properties();
        FileInputStream file;
        try {
            file = new FileInputStream("ObjectRepository.properties");
            properties.load(file);
            file.close();
        } catch (IOException e) {
            System.out.println("ERROR LOADING COMMON PROPERTIES");
        }

        return properties;
    }
}
