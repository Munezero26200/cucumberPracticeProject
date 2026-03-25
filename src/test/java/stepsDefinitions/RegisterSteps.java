package stepsDefinitions;

import factory.DriverFactory;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
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
    @Given("I am on Account page")
    public void beOnAccountPage() {
        driver = DriverFactory.getDriver();
        accountPage = new AccountPage(driver);
        accountPage.navigateToAccountPage();

    }

    @When("I register with credentials set {int}")
    public void registerWithValidCredentials(int credentialSet) {
        String uniqueEmail = "testUser" + System.currentTimeMillis() + "@gmail.com";
        if(credentialSet == 1){
            accountPage.enterRegCredentials(
                    EnvConfig.getRegUsername1(),
                    uniqueEmail,
                    EnvConfig.getRegPassword1()
            );
        }else if(credentialSet == 2){
            accountPage.enterRegCredentials(
                    EnvConfig.getRegUsername2(),
                    uniqueEmail,
                    EnvConfig.getRegPassword2()
            );
        }
    }

    @And("I click on Register Button")
    public void clickOnRegisterBtn() {
        accountPage.clickRegisterBtn();
    }

    @Then("I should be on Dashboard page")
    public void iShouldBeOnDashboardPage() {
        accountPage.checkifWeReachOnDashboard();
    }

    @Then("I should see a welcome message says {string}")
    public void iShouldSeeAWelcomeMessageSays(String arg0) {

    }
    @And("I should see a welcome message says {string}")
    public void wlcmMsgDisplayed(String expectedWlcmMsg) {
        accountPage.verifyWelcomeMsg(expectedWlcmMsg);
    }
}
