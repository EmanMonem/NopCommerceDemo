package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class LoginPage extends MethodHandles {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    private final By emailField = By.id("Email");

    private final By passwordField = By.id("Password");

    private final By loginButton = By.cssSelector(".button-1.login-button");
    private final By emailErrorMSG = By.id("Email-error");
    private final By loginMSG = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div[2]/form/div[1]");
    // private final By loginMSG = By.cssSelector(".message-error validation-summary-errors");

    private void insertEmail(String text){
        sendKeys(emailField,10,text);
    }
    private void insertPassword(String password){
        sendKeys(passwordField,10,password);
    }

    private void clickOnLoginButton(){
        click(loginButton,10);
    }

    public void loginFeature(String username ,String password ){
        insertEmail(username);
        insertPassword(password);
        clickOnLoginButton();
    }
    public boolean emailErrorMSGIsDisplayed(){
        return isDisplayed(emailErrorMSG,5);
    }
    public String getEmailValidation(){
        return getText(emailErrorMSG,5);
    }

    public String getLoginValidation(){
        return getText(loginMSG,5);
    }
}
