package stepsDefinitions;

import DomainObj.DisplayedLoginUsername;
import DomainObj.Password;
import DomainObj.Username;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.AccountPage;

import java.time.Duration;

public class LoginSteps {

    private WebDriver driver;
    AccountPage accountPage;

    @Given("I am on Account page")
    public void beOnAccountPage() {
      driver = DriverFactory.getDriver();
       accountPage = new AccountPage(driver);
       accountPage.navigateToAccountPage();

    }

@When("I enter my {username} and {password}")
public void enterCredentials(Username usernameOrEmail, Password password) {
        accountPage.enterCredentials(usernameOrEmail,password);
}
    @When("I click on LOG IN button")
    public void clickLoginBtn() {
         accountPage.clickLoginBtn();
    }
    @Then("I should be on Dashboard")
    public void iShouldBeOnDashboard() throws InterruptedException {
        accountPage.checkYouReachOnDashboard();
    }

    @And("I should see a welcome message says {string}")
    public void wlcmMsgDisplayed(String expectedWlcmMsg) {
        accountPage.verifyWelcomeMsg(expectedWlcmMsg);
    }



}
