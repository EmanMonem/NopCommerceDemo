package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class ContactUsPage extends MethodHandles {
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }
    private final By nameField = By.id("FullName");
    private final By emailField = By.id("Email");
    private final By enquiryField = By.id("Enquiry");
    private final By submitButton = By.xpath("//button[contains(text(),'Submit')]");

    private void insertName(String name){
        sendKeys(nameField , 5 , name);
    }
    private void insertEmail(String email){
        sendKeys(emailField , 5 , email);
    }
    private void insertEnquiry(String enquiry){
        sendKeys(enquiryField , 5 , enquiry);
    }
    private void clickOnSubmitButton( ){
        click(submitButton , 5);
    }
    public ContactUsResultPage contactUsFeature(String name ,String email ,String enquiry){
        insertName(name);
        insertEmail(email);
        insertEnquiry(enquiry);
        clickOnSubmitButton();
        return new ContactUsResultPage(driver);

    }
}
