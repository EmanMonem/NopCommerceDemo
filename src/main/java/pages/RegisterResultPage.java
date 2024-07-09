package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class RegisterResultPage extends MethodHandles {

    public RegisterResultPage(WebDriver driver) {
        super(driver);
    }

    private final By registerResultText = By.xpath("//div[contains(text(),'Your registration completed')]");
    private final By continueButton = By.xpath("//a[contains(text(),'Continue')]");
    private final By myAccountLink = By.xpath("(//a[contains(text(),'My account')])");
    private final By logOutLink = By.xpath("//a[contains(text(),'Log out')]") ;

    public String getRegisterResultText(){
       return getText(registerResultText , 5);
    }
    public void clickOnContinueButton(){
        click(continueButton , 5 );
    }
    public void clickOnLogOutLink(){
        click(logOutLink,5);
    }
    public MyAccountPage clickOnMyAccountLink(){
        click(myAccountLink ,5);
        return new MyAccountPage(driver);
    }


}
