package pages;

import DomainObj.Product;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class StorePage extends BasePage{
    public StorePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "button[name='add-to-cart']") private WebElement addToCartBtn;
    @FindBy(xpath = "(//span[@class='count'])[1]") private WebElement cartIcon;



    public void clickProduct(Product product){
        By productLocator = By.linkText(product.getProductName());
         wait.until(ExpectedConditions.elementToBeClickable(productLocator)).click();
    }
    public void addProductToCart(){
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
    }

    public void addMultipleProductToCart(DataTable dataTable){
        List<String> products = dataTable.asList();
        for (String product : products) {
            WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[contains(@aria-label,'" + product + "')]")
            ));
            addToCartBtn.click();


            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[contains(@aria-label,'" + product + "') and contains(@class,'added')]")
            ));
        }
    }

    public void clickOnCartIcon(){
        WebElement visibleCartIcon = wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
        visibleCartIcon.click();
    }
}
