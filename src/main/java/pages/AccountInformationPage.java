package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class AccountInformationPage extends MethodHandles {
    public AccountInformationPage(WebDriver driver) {
        super(driver);
    }
    private final By passwordField = By.id("password");
    private final By firstNameField = By.id("first_name");
    private final By lastNameField = By.id("last_name");
    private final By addressField = By.id("address1");
    private final By stateField = By.id("state");
    private final By cityField = By.id("city");
    private final By zipcodeField = By.id("zipcode");
    private final By mobileNumberField = By.id("mobile_number");
    private final By createAccountButton = By.xpath("//button[contains(text(),'Create Account')]");

    private void insertPasswordField(String password){
        sendKeys(passwordField,5,password);
    }
    private void insertFirstNameField(String firstName){
        sendKeys(firstNameField,5,firstName);
    }
    private void insertLastNameField(String lastName){
        sendKeys(lastNameField,5,lastName);
    }
    private void insertAddressField(String address){
        sendKeys(addressField,5,address);
    }
    private void insertStateField(String state){
        sendKeys(stateField,5,state);
    }
    private void insertCityField(String city){
        sendKeys(cityField,5,city);
    }
    private void insertZipcodeField(String zipcode){
        sendKeys(zipcodeField,5,zipcode);
    }
    private void insertMobileNumberField(String mobileNumber){
        sendKeys(mobileNumberField,5,mobileNumber);
    }
    private void clickOnCreateAccountButton(){
        click(createAccountButton,5);
    }
    public void accountInformationFeature(String password ,String firstName, String lastName ,String address ,String state ,String city,String zipcode , String mobileNumber ){
        insertPasswordField(password);
        insertFirstNameField(firstName);
        insertLastNameField(lastName);
        insertAddressField(address);
        insertStateField(state);
        insertCityField(city);
        insertZipcodeField(zipcode);
        insertMobileNumberField(mobileNumber);
        clickOnCreateAccountButton();
    }
}
