package pages;

import DomainObj.BillingDetails;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class CheckoutPage extends BasePage{

    @FindBy(css = "div.wc-proceed-to-checkout>a") private WebElement proceedToCheckoutBtn;
    @FindBy(css = "#billing_first_name") private WebElement firstNameField;
    @FindBy (css = "#billing_last_name") private WebElement lastNameField;
    @FindBy (css = "input[id='billing_address_1']") private WebElement streetAddressField;
    @FindBy (css = "input[id='billing_city']") private WebElement townField;
    @FindBy(css = "span[id='select2-billing_state-container']") private WebElement stateField;
    @FindBy(css = "input.select2-search__field") private WebElement stateSearchField;
    @FindBy (css = "input[id='billing_postcode']") private WebElement postCodeField;
    @FindBy (css = "#billing_email") private WebElement emailField;
    @FindBy (id = "place_order") private WebElement placeOrderBtn;
    @FindBy (css = "div.blockUI.blockOverlay") private WebElement overlay;



    public CheckoutPage(WebDriver driver) {

        super(driver);
    }

    public void clickProceedToCheckoutBtn(){
        WebElement proceedToCheckoutButton = wait.until(ExpectedConditions.visibilityOf(proceedToCheckoutBtn));
        proceedToCheckoutButton.click();
    }

    public void enterValidBillingDetails(DataTable dataTable){
        List<Map<String,String>> data = dataTable.asMaps(String.class, String.class);
        Map<String,String> billing = data.get(0);

        BillingDetails billingDetails = new BillingDetails(
                billing.get("FirstName"),
                billing.get("LastName"),
                billing.get("Street address"),
                billing.get("Town"),
                billing.get("State"),
                billing.get("Postcode"),
                billing.get("Email"));
        //first name
        WebElement fillFirstNameField = wait.until(ExpectedConditions.visibilityOf(firstNameField));
        fillFirstNameField.sendKeys(billingDetails.getFirstName());
        //last name
        WebElement fillLastNameField = wait.until(ExpectedConditions.visibilityOf(lastNameField));
        fillLastNameField.sendKeys(billingDetails.getLastName());
        //street address
         wait.until(ExpectedConditions.visibilityOf(streetAddressField)).sendKeys(billingDetails.getStreetAddress());
        //town
         wait.until(ExpectedConditions.visibilityOf(townField)).sendKeys(billingDetails.getTown());
        //state
        wait.until(ExpectedConditions.elementToBeClickable(stateField)).click();
        wait.until(ExpectedConditions.visibilityOf(stateSearchField)).sendKeys(billingDetails.getState());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".select2-results__option"))).click();
        //postcode
        wait.until(ExpectedConditions.visibilityOf(postCodeField)).sendKeys(billingDetails.getPostCode());
        //email
        wait.until(ExpectedConditions.visibilityOf(emailField)).sendKeys(billingDetails.getEmail());

    }

    public void clickPlaceOrderBtn(){
        wait.until(ExpectedConditions.invisibilityOf(overlay));
        wait.until(ExpectedConditions.visibilityOf(placeOrderBtn)).click();
    }



}