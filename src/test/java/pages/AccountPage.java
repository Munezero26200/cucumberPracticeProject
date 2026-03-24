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
    @FindBy ( xpath = "(//nav[@class='woocommerce-MyAccount-navigation']//ul/li/a)[1]") private WebElement dashboard;
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
    public void checkYouReachOnDashboard() throws InterruptedException {
        Thread.sleep(5000);
        WebElement reachDashboard = wait.until(ExpectedConditions.visibilityOf(dashboard));
        reachDashboard.getText();
    }
    public String getWelcomeMsg(){
        return wait.until(ExpectedConditions.visibilityOf(wlcmMsg)).getText();
    }
    public void verifyWelcomeMsg(String expectedWlcmMsg){
        String actualMsg = getWelcomeMsg();
        Assert.assertEquals(actualMsg,expectedWlcmMsg,"Welcome message is incorrect");
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
    }

}
