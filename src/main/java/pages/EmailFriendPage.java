package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class EmailFriendPage extends MethodHandles {
    public EmailFriendPage(WebDriver driver) {
        super(driver);
    }
    private final By emailFriendField = By.id("FriendEmail");
    private final By personalMessageField = By.id("PersonalMessage");
    private final By sendEmailButton = By.xpath("//button[contains(text(),'Send email')]");

    private void insertEmailFriend(String emailFriend){
        sendKeys(emailFriendField,5,emailFriend);
    }

    private void insertPersonalMessage(String personalMessage){
        sendKeys(personalMessageField,5,personalMessage);
    }
    private void clickOnSendEmailButton(){
        click(sendEmailButton,5);
    }
    public EmailFriendResultPage emailFriendFeature(String emailFriend, String personalMessage ){
        insertEmailFriend(emailFriend);
        insertPersonalMessage(personalMessage);
        clickOnSendEmailButton();
        return new EmailFriendResultPage(driver);
    }
}
