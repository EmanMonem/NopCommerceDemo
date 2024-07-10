package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class EmailFriendResultPage extends MethodHandles {
    public EmailFriendResultPage(WebDriver driver) {
        super(driver);
    }
    private final By emailFriendText = By.xpath("//h1[contains(text(),'Email a friend')]");

    public Boolean emailFriendTextIsDisplayed(){
        return isDisplayed(emailFriendText , 5);
    }
}
