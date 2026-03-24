package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ConfigLoader;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver initializeDriver(String browser){
        switch (browser){
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless=new");       // modern headless mode
                options.addArguments("--disable-gpu");        // avoid GPU issues in CI
                options.addArguments("--no-sandbox");         // required in GitHub runners
                options.addArguments("--disable-dev-shm-usage"); // prevent shared memory errors
                options.addArguments("--window-size=1920,1080"); // consistent viewport
                driver = new ChromeDriver(options);
                break;



            case "firefox":
                driver = new FirefoxDriver();
                break;

            default:
                throw new IllegalStateException("INVALID BROWSER" + browser);
        }

        //driver.manage().window().maximize();
        driver.get(ConfigLoader.getInstance().getBaseUrl());
        return driver;
    }

    public static WebDriver getDriver(){
        return driver;
    }
}
