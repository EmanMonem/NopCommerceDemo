package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class MyContactUSPage extends MethodHandles {
    public MyContactUSPage(WebDriver driver) {
        super(driver);
    }

    private final By nameField = By.name("name");
    private final By emailField = By.name("email");
    private final By subjectField = By.name("subject");
    private final By messageField = By.name("message");
    private final By uploadFileField = By.name("upload_file");
    private final By submitButton = By.name("submit");
    private final By getInTouchText = By.xpath("//h2[contains(text(),'Get In Touch')]");
    private final By successfulMessageText = By.cssSelector(".status.alert.alert-success");
    private final By homeButton = By.cssSelector("#form-section > a");

    private void insertNameField(String name) {
        sendKeys(nameField, 5, name);
    }

    private void insertEmailField(String email) {
        sendKeys(emailField, 5, email);
    }

    private void insertSubjectField(String subject) {
        sendKeys(subjectField, 5, subject);
    }

    private void insertMessageField(String message) {
        sendKeys(messageField, 5, message);
    }

    private void insertUploadFileField(String path) {
        sendKeys(uploadFileField, 5, path);
    }

    private void clickOnSubmitButton() {
        click(submitButton, 5);
    }

    public void contactUsFeature(String name, String email, String subject, String message, String path) {
        insertNameField(name);
        insertEmailField(email);
        insertSubjectField(subject);
        insertMessageField(message);
        insertUploadFileField(path);
        clickOnSubmitButton();
        acceptAlert(5);
    }

    public boolean getInTouchIsDisplayed() {
        return isDisplayed(getInTouchText,5);
    }

    public boolean successfulMessageTextIsDisplayed() {
        return isDisplayed(successfulMessageText,5);
    }
    public void clickOnHomeButton(){
        click(homeButton,5);
    }

}
