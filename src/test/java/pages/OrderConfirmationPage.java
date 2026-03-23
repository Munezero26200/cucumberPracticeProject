package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class OrderConfirmationPage extends BasePage{


    @FindBy(css = "p.woocommerce-notice.woocommerce-notice--success.woocommerce-thankyou-order-received") private WebElement confirmationMsgLocator;
    @FindBy( css = ".woocommerce-order-overview__order.order") private WebElement orderNbrlocator;
    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public void confirmationMsgDisplayed(){
        WebElement confirmationMsg = wait.until(ExpectedConditions.visibilityOf(confirmationMsgLocator));
        confirmationMsg.getText();
        String expectedMsg = "Thank you. Your order has been received.";
        Assert.assertEquals(confirmationMsg.getText(),expectedMsg, "Order doesn't being placed successfully");
    }
    public void getOrderNumber(){
        WebElement orderNumber = wait.until(ExpectedConditions.visibilityOf(orderNbrlocator));
        Assert.assertTrue(orderNumber.getText().contains("ORDER NUMBER:"), "Order doesn't placed successfully");
    }


}
