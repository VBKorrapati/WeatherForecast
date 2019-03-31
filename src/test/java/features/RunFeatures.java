package features;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import com.cucumber.listener.Reporter;
import java.io.File;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features/",
        glue = "CucumberSteps",
        format = {"pretty", "html:target/cucumber", "json:target/cucumber.json"},
        plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
        tags = {"@all"})

public class RunFeatures {

    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File("resources/report.xml"));
    }
}
