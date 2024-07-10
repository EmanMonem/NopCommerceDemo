package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class ContactUsResultPage extends MethodHandles {
    public ContactUsResultPage(WebDriver driver) {
        super(driver);
    }
    private final By contactUsText = By.xpath("//h1[contains(text(),'Contact Us')]");

    public Boolean contactUsTextIsDisplayed(){
        return isDisplayed(contactUsText,5);
    }


}
