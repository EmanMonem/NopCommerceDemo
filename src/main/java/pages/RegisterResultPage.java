package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class RegisterResultPage extends MethodHandles {

    public RegisterResultPage(WebDriver driver) {
        super(driver);
    }

    final static By registerResultText = By.xpath("//div[contains(text(),'Your registration completed')]");
    final static By continueButton = By.xpath("//a[contains(text(),'Continue')]");

    final static By logOutLink = By.xpath("//a[contains(text(),'Log out')]") ;

    public String getRegisterResultText(){
       return getText(registerResultText , 5);
    }
    public void clickOnContinueButton(){
        click(continueButton , 5 );
    }
    public void clickOnLogOutLink(){
        click(logOutLink,5);
    }

}
