package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class CheckOutPage extends MethodHandles {
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }
    private final By countryField = By.id("BillingNewAddress_CountryId");
    private final By cityField = By.id("BillingNewAddress_City");
    private final By addressField = By.id("BillingNewAddress_Address1");
    private final By zipCodeField = By.id("BillingNewAddress_ZipPostalCode");
    private final By phoneNumberField = By.id("BillingNewAddress_PhoneNumber");
    private final By continueBillButton =By.xpath("//*[@id='billing-buttons-container']/button[2]");
    private final By continueShippingButton = By.cssSelector("#shipping-method-buttons-container > button");
    private final By continuePaymentButton = By.cssSelector("#payment-method-buttons-container > button");
    private final By continuePaymentInfoButton = By.cssSelector("#payment-info-buttons-container > button");
    private final By confirmButton = By.cssSelector("#confirm-order-buttons-container > button");

    private void selectCountryField(String countryText){
        selectByVisibleText(countryField,5,countryText);
    }
    private void insertCityField(String city){
        sendKeys(cityField,5,city);
    }
    private void insertAddressField(String address){
        sendKeys(addressField,5,address);
    }
    private void insertZipCodeField(String zipCode){
        sendKeys(zipCodeField,5,zipCode);
    }
    private void insertPhoneNumberField(String phoneNumber){
        sendKeys(phoneNumberField,5,phoneNumber);
    }
    private void clickOnContinueBillButton(){
        click(continueBillButton,5);
    }
    private void clickOnContinueShippingButton(){
        click(continueShippingButton,5);
    }
    private void clickOnContinuePaymentButton(){
        click(continuePaymentButton,5);
    }
    private void clickOnContinuePaymentInfoButton(){
        click(continuePaymentInfoButton,5);
    }
    private void clickOnConfirmButton(){
        click(confirmButton,5);
    }
    public CheckOutCompletePage checkOutFeature(String countryText ,String city ,String address , String zipCode ,String phoneNumber){
        selectCountryField(countryText);
        insertCityField(city);
        insertAddressField(address);
        insertZipCodeField(zipCode);
        insertPhoneNumberField(phoneNumber);
        clickOnContinueBillButton();
        clickOnContinueShippingButton();
        clickOnContinuePaymentButton();
        clickOnContinuePaymentInfoButton();
        clickOnConfirmButton();
        return new CheckOutCompletePage(driver);
    }
}
