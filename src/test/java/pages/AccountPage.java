package pages;

import DomainObj.Email;
import DomainObj.Password;
import DomainObj.Username;
import constants.EndPoint;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AccountPage extends BasePage{

    @FindBy( css = "#username") private WebElement usernameOrEmailField;
    @FindBy( css = "#password") private WebElement passwordField;
    @FindBy( css = "button[name='login']") private WebElement loginBtn;
    @FindBy( xpath = "(//div[@class='woocommerce-MyAccount-content']/p)[1]") private WebElement wlcmMsg;
    @FindBy( css = "#reg_username") private WebElement usernameRegField;
    @FindBy ( css = "#reg_email") private WebElement emailRegField;
    @FindBy( css = "#reg_password") private WebElement passwordRegField;
    @FindBy( css = "button[name='register']") private WebElement registerBtn;


    public AccountPage(WebDriver driver) {
        super(driver);
    }


    public void enterCredentials(Username usernameOrEmail, Password passcode){
        WebElement usernameOrEm = wait.until(ExpectedConditions.visibilityOf(usernameOrEmailField));
        usernameOrEm.sendKeys(usernameOrEmail.getUsername());
        WebElement password = wait.until(ExpectedConditions.visibilityOf(passwordField));
        password.sendKeys(passcode.getPassword());
    }

    public void clickLoginBtn(){
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        loginButton.click();
    }
    public void checkYouReachOnDashboard()  {
        wait.until(ExpectedConditions.urlContains("/account"));
        String welcome = getWelcomeMsg();
        Assert.assertTrue(welcome.contains("Hello"), "Not logged in, welcome message missing");
        WebElement dashboardNav = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("nav.woocommerce-MyAccount-navigation li.woocommerce-MyAccount-navigation-link--dashboard a")
        ));
        dashboardNav.getText();

    }
    public String getWelcomeMsg(){
        System.out.println(wlcmMsg.getText());
        return wait.until(ExpectedConditions.visibilityOf(wlcmMsg)).getText();
    }
    public void verifyWelcomeMsg(String expectedWlcmMsg){
        String actualMsg = getWelcomeMsg();
       Assert.assertTrue(actualMsg.contains(expectedWlcmMsg),"Wrong welcome message");
    }
    public void navigateToAccountPage(){
        load(EndPoint.ACCOUNT.url);
    }

    public void enterRegCredentials(String usernameReg, String emailAddressReg, String  passwordReg){
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOf(usernameRegField));
        usernameField.clear();
        usernameField.sendKeys(usernameReg);

        WebElement emailField = wait.until(ExpectedConditions.visibilityOf(emailRegField));
        emailField.clear();
        emailField.sendKeys(emailAddressReg);

        WebElement passwordField = wait.until(ExpectedConditions.visibilityOf(passwordRegField));
        passwordField.clear();
        passwordField.sendKeys(passwordReg);
    }
    public void clickRegisterBtn(){
        WebElement registerButton = wait.until(ExpectedConditions.visibilityOf(registerBtn));
        registerButton.click();
        System.out.println(driver.getPageSource());
    }
    public void checkifWeReachOnDashboard(){
        wait.until(ExpectedConditions.urlContains("/account"));
        String welcome = getWelcomeMsg();
        Assert.assertTrue(welcome.contains("Hello"), "Not logged in, welcome message missing");
        WebElement dashboardNav = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("nav.woocommerce-MyAccount-navigation li.woocommerce-MyAccount-navigation-link--dashboard a")
        ));
        dashboardNav.getText();
    }


}
