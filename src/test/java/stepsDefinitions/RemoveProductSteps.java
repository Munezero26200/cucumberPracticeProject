package stepsDefinitions;


import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CartPage;
import utils.ConfigLoader;

public class RemoveProductSteps {
 private WebDriver driver;
 private WebDriverWait wait;
 CartPage cartPage;

    @Given("I am on cart page")
    public void iAmOnCartPage() {
     driver = DriverFactory.getDriver();
     cartPage = new CartPage(driver);
    }
    @When("I Click on cross icon beside the {string}")
    public void iClickOnCrossIconBesideThe(String productName) {
        cartPage.clickOnCrossIconToDeleteProduct();
    }

    @Then("Product should be deleted confirmed with confirmation message says {string}")
    public void confirmationMsgDisplayed(String productName) {
        cartPage.deleteConfirmationMsgDisplayed(productName);
    }
}
