package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class MyAccountPage extends MethodHandles {
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }
    private final By changePasswordLink = By.xpath("//a[contains(text(),'Change password')]");

    public ChangePasswordPage clickOnChangePasswordLink(){
        click(changePasswordLink,5);
        return new ChangePasswordPage(driver);
    }
}
