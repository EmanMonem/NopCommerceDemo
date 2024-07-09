package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class RegisterPage extends MethodHandles {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    //MandatoryFields
    private final By firstNameField = By.id("FirstName");
    private final By lastNameField = By.id("LastName");
    private final By emailField = By.id("Email");
    private final By passwordField = By.id("Password");
    private final By confirmPasswordField = By.id("ConfirmPassword");

    //OptionalFields
    private final By genderMaleRadioButton = By.id("gender-male");
    private final By genderFemaleRadioButton  = By.id("gender-female");
    private final By dayField = By.xpath("//*[@name = 'DateOfBirthDay']");
    private final By monthField = By.xpath("//*[@name = 'DateOfBirthMonth']");
    private final By yearField = By.xpath("//*[@name = 'DateOfBirthYear']");
    private final By companyNameField = By.id("Company");
    private final By newsletterField = By.id("Newsletter");

    private final By registerButton = By.id("register-button");

    private final By firstNameError = By.id("FirstName-error");
    private final By lastNameError = By.id("LastName-error");
    private final By emailError = By.id("Email-error");
    private final By passwordError = By.id("ConfirmPassword-error");


    private void insertFirstName(String firstName){
        sendKeys(firstNameField, 5 ,firstName);
    }
    private void insertLastName(String lastName){
        sendKeys(lastNameField, 5 ,lastName);
    }
    private void insertEmail(String email){
        sendKeys(emailField, 5 ,email);
    }
    private void insertPassword(String password){
        sendKeys(passwordField, 5 ,password);
    }
    private void insertConfirmPassword(String confirmPassword){
        sendKeys(confirmPasswordField, 5 ,confirmPassword);
    }

    public RegisterResultPage clickOnRegisterButton(){
        click(registerButton,5);
        return new RegisterResultPage(driver);
    }
    public String getFirstNameErrorText(){
        return getText(firstNameError,5);
    }

    public void registerWithAllMandatoryFields(String firstName ,String lastName ,String email ,String password ,String confirmPassword ){
        insertFirstName(firstName);
        insertLastName(lastName);
        insertEmail(email);
        insertPassword(password);
        insertConfirmPassword(confirmPassword);

    }



}
