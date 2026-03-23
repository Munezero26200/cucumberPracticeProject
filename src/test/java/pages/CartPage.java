package pages;

import DomainObj.Product;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

import static stepsDefinitions.UpdatesProductQtySteps.BlueShoesProductId;

public class CartPage extends BasePage{

    @FindBy(xpath = "//h1[text()='Cart']") private WebElement cartPageTitle;
    @FindBy(css = "input[value='1']") private WebElement qtyLocator;
    @FindBy(xpath = "//td[@class='product-subtotal']//bdi[1]") private WebElement subTotalCost;
    @FindBy(xpath = "//tr[@class='order-total']//bdi[1]") private WebElement totalPrice;
    @FindBy(css = "input[type='number']") private WebElement qtyBox;
    @FindBy(css = "button[name='update_cart']") private WebElement updateBtn;
    private String subtotalBefore;
    private String totalBefore;
    @FindBy (css = "a[aria-label='Remove this item']") private WebElement crossIcon;



    public CartPage(WebDriver driver) {
        super(driver);
    }





    public void cartPageTitleDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(cartPageTitle));
        String actualTitle = cartPageTitle.getText();
        Assert.assertEquals(actualTitle, "Cart");
    }
    public void productDisplayedInCart(Integer quantity, Product product) {
        By productLocator = By.xpath("//a[text()='" + product.getProductName() + "']");

        WebElement productEl = wait.until(ExpectedConditions.visibilityOfElementLocated(productLocator));

        // Get values
        String actualQty = qtyLocator.getAttribute("value");
        String actualProduct = productEl.getText();

        Assert.assertEquals(actualProduct, product.getProductName(), "Wrong added product");
        Assert.assertEquals(Integer.parseInt(actualQty), quantity.intValue(), "Wrong quantity of product");
    }


    public void allProductAddedAreVisible(DataTable dataTable){
        List<String> products = dataTable.asList();
        for (String product : products) {

            WebElement productElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//td[contains(@class,'product-name')]//*[contains(normalize-space(text()),'" + product + "')]")
            ));

            Assert.assertEquals(productElement.getText().trim(), product, "Product not found in cart: " + product);
            System.out.println("Found in cart: " + productElement.getText());
        }
    }

    public void checkIfTHereIsOneProductInCart() {

        List<WebElement> removeButtons = driver.findElements(By.cssSelector(".product-remove a"));
        for (WebElement removeBtn : removeButtons) {
            removeBtn.click();
            wait.until(ExpectedConditions.stalenessOf(removeBtn));
        }

        // adding product
        driver.get("https://askomdch.com/?add-to-cart=" + BlueShoesProductId);
        driver.get("https://askomdch.com/cart/");
        //confirm that product is in the cart
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".woocommerce-cart-form__cart-item")));

        List<WebElement> finalCartItems = driver.findElements(By.cssSelector(".woocommerce-cart-form__cart-item"));
        Assert.assertFalse(finalCartItems.isEmpty(), "Cart should have at least one product");

        subtotalBefore = wait.until(ExpectedConditions.visibilityOf(subTotalCost)).getText();
        totalBefore = wait.until(ExpectedConditions.visibilityOf(totalPrice)).getText();
    }
    public void updateProductQty(int qty){
        qtyBox.clear();
        qtyBox.sendKeys(String.valueOf(qty));
    }
    public void clickUpdateCart(){
        String totalBeforeClick = totalPrice.getText();
        wait.until(ExpectedConditions.elementToBeClickable(updateBtn)).click();

            wait.until(driver-> {
                try{

                String currentTotal = driver.findElement(By.xpath("//tr[@class='order-total']//bdi[1]")).getText();
                return !currentTotal.equals(totalBeforeClick);
                   }catch(StaleElementReferenceException e){
                return false;
            }


       });

    }
    public String getSubtotalBefore(){
        return subtotalBefore;
    }
    public String getTotalBefore(){
        return totalBefore;
    }
    public String getSubTotalAfter(){
        return wait.until(ExpectedConditions.visibilityOf(subTotalCost)).getText();
    }
    public String getTotalAfter(){
        return wait.until(ExpectedConditions.visibilityOf(totalPrice)).getText();
    }

    public void clickOnCrossIconToDeleteProduct(){
        wait.until(ExpectedConditions.elementToBeClickable(crossIcon)).click();
    }
    public void deleteConfirmationMsgDisplayed(String productName){
        wait.until((ExpectedCondition<Boolean>) driver->{
            String msgText = driver.findElement(By.cssSelector(".woocommerce-notices-wrapper .woocommerce-message")).getText().trim();
            return msgText.contains("removed") && msgText.contains("Undo");
        });
        String actualMsg = driver.findElement(By.cssSelector(".woocommerce-notices-wrapper .woocommerce-message")).getText().trim();
        Assert.assertTrue(actualMsg.contains("removed") && actualMsg.contains("Undo"), "Wrong confirmation message displayed");
    }
}
