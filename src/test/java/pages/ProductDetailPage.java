package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductDetailPage extends BasePage{
    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy( css ="a[class='button wc-forward']:nth-child(1)") private WebElement viewCartBtn;

    public void clickOnViewCartBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(viewCartBtn)).click();
    }

}
