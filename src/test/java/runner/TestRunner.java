package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;




@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepsDefinitions","customParameter", "domainobj","hooks"},
        plugin = {"pretty","html:target/cucumber.html","summary",
                  "html:target/cucumber/cucumber.html"},
        tags = "@register"



)
public class TestRunner extends AbstractTestNGCucumberTests {

}

