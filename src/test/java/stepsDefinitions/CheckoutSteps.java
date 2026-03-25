package stepsDefinitions;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CheckoutPage;
import pages.OrderConfirmationPage;



public class CheckoutSteps{
  private WebDriver driver;
  private WebDriverWait wait;
  private final CheckoutPage checkoutPage;
  private final  OrderConfirmationPage orderConfirmationPage;

    public CheckoutSteps(){
      driver = DriverFactory.getDriver();
      checkoutPage = new CheckoutPage(driver);
      orderConfirmationPage = new OrderConfirmationPage(driver);
  }

    @And("I am on the checkout page")
    public void iAmOnCheckOutPage() {
     checkoutPage.clickProceedToCheckoutBtn();

    }
    @When("I enter required valid credentials")
    public void enterCredentials(DataTable dataTable) {
      checkoutPage.enterValidBillingDetails(dataTable);
    }
    @And("I click on {string} button")
    public void ClickPlaceOrderBtn(String button) {
      checkoutPage.clickPlaceOrderBtn();
    }
    @Then("I should see confirmation message says {string}")
    public void confirmationMessageDisplayed(String message) {
        orderConfirmationPage.confirmationMsgDisplayed();
    }
    @Then("I should  get the {string}")
    public void orderNumberDisplayed(String orderNum) {
      orderConfirmationPage.getOrderNumber();

    }

}

