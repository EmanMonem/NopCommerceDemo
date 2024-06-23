package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class HomePage extends MethodHandles {

    public HomePage(WebDriver driver) {
        super(driver);

    }
    final static By registerLink = By.xpath("(//a[contains(text(),'Register')])");

    public RegisterPage clickOnRegisterLink(){
        driver.findElement(registerLink).click();
        return new RegisterPage(driver);
    }
}
