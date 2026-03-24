package hooks;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {
    private WebDriver driver;

    @Before
    public void before(){
        driver = DriverFactory.initializeDriver(System.getProperty("browser","chrome"));
    }

//    @After
//    public void tearDown() {
//        if (DriverFactory.getDriver() != null) {
//            DriverFactory.getDriver().quit();
//        }
//    }
}
