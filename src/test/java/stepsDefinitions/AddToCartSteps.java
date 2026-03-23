package stepsDefinitions;

import DomainObj.Product;
import constants.EndPoint;
import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CartPage;
import pages.ProductDetailPage;
import pages.StorePage;
import utils.ConfigLoader;


public class AddToCartSteps {
    private WebDriver driver;
    private WebDriverWait wait;
    StorePage storePage;


    @Given("I am on store page")
    public void iAmOnStorePage() {
        driver = DriverFactory.getDriver();
        storePage= new StorePage(driver);
        storePage .load(EndPoint.STORE.url);
    }
    @When("I click on the {product}")
    public void iClickOnTheproductName(Product product) {
        storePage.clickProduct(product);
    }
    @And("I click on ADD TO CART button on the product page")
    public void clickAddToCartBtn() {
        storePage.addProductToCart();
    }
    @And("I click on VIEW CART link")
    public void clickToViewCartBtn() {
       new ProductDetailPage(driver ).clickOnViewCartBtn();
    }
    @Then("I should see the cart's page title")
    public void iShouldSeeThisTitle() {
      new CartPage(driver).cartPageTitleDisplayed();
    }

    @And("I should see {int} {product} in the cart")
    public void iShouldSeeInTheCart(Integer quantity, Product product) {
        new CartPage(driver).productDisplayedInCart(quantity, product);
    }

    @When("I click on ADD TO CART button of the following products")
    public void iClickOnAddToCartButtonOfTheFollowingProducts(DataTable dataTable) {
       storePage.addMultipleProductToCart(dataTable);
    }

    @And("I click on Cart icon")
    public void iClickOnCartIcon() {
       new StorePage(driver).clickOnCartIcon();
    }

    @Then("I should be redirected to cart page")
    public void iShouldBeRedirectedToCartPage() {
     new CartPage(driver).cartPageTitleDisplayed();
    }

    @And("I should see all the added products")
    public void iShouldSeeAllTheAddedProducts(DataTable dataTable) {
        new CartPage(driver).allProductAddedAreVisible(dataTable);
    }

}