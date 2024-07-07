package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class RegisterPage extends MethodHandles {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    //MandatoryFields
    final static By firstNameField = By.id("FirstName");
    final static By lastNameField = By.id("LastName");
    final static By emailField = By.id("Email");
    final static By passwordField = By.id("Password");
    final static By confirmPasswordField = By.id("ConfirmPassword");

    //OptionalFields
    final static By genderMaleRadioButton = By.id("gender-male");
    final static By genderFemaleRadioButton  = By.id("gender-female");
    final static By dayField = By.xpath("//*[@name = 'DateOfBirthDay']");
    final static By monthField = By.xpath("//*[@name = 'DateOfBirthMonth']");
    final static By yearField = By.xpath("//*[@name = 'DateOfBirthYear']");
    final static By companyNameField = By.id("Company");
    final static By newsletterField = By.id("Newsletter");

    final static By registerButton = By.id("register-button");

    final static By firstNameError = By.id("FirstName-error");
    final static By lastNameError = By.id("LastName-error");
    final static By emailError = By.id("Email-error");
    final static By passwordError = By.id("ConfirmPassword-error");


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
