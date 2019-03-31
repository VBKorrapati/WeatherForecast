package TestAutomation.webApplication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.Properties;

public class webHelper {

    public static final Properties commonProperties = TestAutomation.Services.CommonProperties.setProperties();

    private static final String appURL = commonProperties.getProperty("application.url");
    public static WebDriver launchWebDriver() {


        File file = new File(commonProperties.getProperty("drivername"));
        String filepath = System.getProperty("user.dir")+"/drivers/"+file;
        System.setProperty("webdriver.gecko.driver",filepath);
        WebDriver driver = new FirefoxDriver();
        driver.get(appURL);
        return driver;
    }
}
