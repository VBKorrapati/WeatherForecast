package CucumberSteps;


import org.openqa.selenium.WebDriver;
import TestAutomation.Services.ObjectRepositoy;

import java.util.Properties;


public class WebApplicationObjectDeclaration {

    public static final Properties properties = ObjectRepositoy.setProperties();
    public static WebDriver driver;


    protected final String City = properties.getProperty("City");

    public WebApplicationObjectDeclaration() {

    }



}