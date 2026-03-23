package stepsDefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.CartPage;
import utils.ConfigLoader;

import java.time.Duration;


public class UpdatesProductQtySteps {

    private WebDriver driver;
    private WebDriverWait wait;
    public static final String BlueShoesProductId = "1215";
    CartPage cartPage;

    @Given("I have one product in cart")
    public void haveOneProductInCart() {
     driver = DriverFactory.getDriver();
     cartPage = new CartPage(driver);
     wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    cartPage.checkIfTHereIsOneProductInCart();
    }
    @When("I change the quantity product to {int}")
    public void changeProductQty(int initialQty) {

        cartPage.updateProductQty(initialQty);
    }
    @And("I click on UPDATE CART button")
    public void iClickOnUPDATECARTButton() {

        cartPage.clickUpdateCart();
    }
    @Then("product should be updated which confirmed by updated subtotal and total")
    public void confirmationFromSubtotalAndTotal() {
      String updatedSubtotal = cartPage.getSubTotalAfter();
      String updatedTotal = cartPage.getTotalAfter();

      Assert.assertNotEquals(updatedSubtotal, cartPage.getSubtotalBefore(),"Subtotal didn't change");
      Assert.assertNotEquals(updatedTotal, cartPage.getTotalBefore(),"Total did not change");
    }



}
