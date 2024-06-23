package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class RegisterPage extends MethodHandles {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    //MandatoryFields
    final static By genderMaleRadioButton = By.id("gender-male");
    final static By genderFemaleRadioButton  = By.id("gender-female");
    final static By firstNameField = By.id("FirstName");
    final static By lastNameField = By.id("LastName");
    final static By emailField = By.id("Email");
    final static By passwordField = By.id("Password");
    final static By confirmPasswordField = By.id("ConfirmPassword");

    //OptionalFields
    final static By dayField = By.xpath("//*(@name = 'DateOfBirthDay')");
    final static By monthField = By.xpath("//*(@name = 'DateOfBirthMonth')");
    final static By yearField = By.xpath("//*(@name = 'DateOfBirthYear')");
    final static By companyNameField = By.id("Company");
    final static By newsletterField = By.id("Newsletter");


}
