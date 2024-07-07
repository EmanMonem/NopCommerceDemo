package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class HomePage extends MethodHandles {

    public HomePage(WebDriver driver) {
        super(driver);

    }
    final static By registerLink = By.xpath("(//a[contains(text(),'Register')])");
    final static By loginLink = By.xpath("(//a[contains(text(),'Log in')])");
    final static By myAccountLink = By.xpath("(//a[contains(text(),'My account')])");
    public RegisterPage clickOnRegisterLink(){
        click(registerLink,5);
        return new RegisterPage(driver);
    }
    public LoginPage clickOnLoginPage(){
        click(loginLink,5);
        return new LoginPage(driver);
    }
    public boolean myAccountLinkIsDisplayed(){
        return isDisplayed(myAccountLink,5);
    }
}
