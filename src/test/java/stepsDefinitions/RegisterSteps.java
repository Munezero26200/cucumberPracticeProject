package stepsDefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.AccountPage;
import utils.EnvConfig;


public class RegisterSteps {
    private WebDriver driver;
    private AccountPage accountPage;

    public RegisterSteps() {
        driver = DriverFactory.getDriver();
        accountPage = new AccountPage(driver);
    }

    @When("I register with credentials set {int}")
    public void registerWithValidCredentials(int credentialSet) {
        if(credentialSet == 1){
            accountPage.enterRegCredentials(
                    EnvConfig.getRegUsername1(),
                    EnvConfig.getRegEmail1(),
                    EnvConfig.getRegPassword1()
            );
        }else if(credentialSet == 2){
            accountPage.enterRegCredentials(
                    EnvConfig.getRegUsername2(),
                    EnvConfig.getRegEmail2(),
                    EnvConfig.getRegPassword2()
            );
        }
    }

    @And("I click on Register Button")
    public void clickOnRegisterBtn() {
        accountPage.clickRegisterBtn();
    }
}
