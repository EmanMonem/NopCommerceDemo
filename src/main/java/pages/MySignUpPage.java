package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class MySignUpPage extends MethodHandles {
    public MySignUpPage(WebDriver driver) {
        super(driver);
    }

    private final By nameField = By.name("name");
    private final By emailField = By.name("email[2]");
    private final By signUpButton = By.xpath("//button[contains(text(),'Signup')]");

    private void insertNameField(String name){
        sendKeys(nameField,5,name);
    }
    private void insertEmailField(String email){
        sendKeys(emailField,5,email);
    }
    private void clickOnSignUpButton(){
        click(signUpButton,5);
    }
    public AccountInformationPage signUpFeature(String name,String email){
        insertNameField(name);
        insertEmailField(email);
        clickOnSignUpButton();
        return new AccountInformationPage(driver);
    }
}
