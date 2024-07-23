package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.MethodHandles;

import java.time.Duration;

public class CardPage extends MethodHandles {
    public CardPage(WebDriver driver) {
        super(driver);
    }
    private final By quantityField = By.className("qty-input");
    private final By removeFromCard = By.name("updatecart");
    private final By continueShoppingButton = By.xpath("//button[contains(text(),'Continue shopping')]");
    private final By estimateShipButton = By.xpath("//a[contains(text(),'Estimate shipping')]");
    private final By shipToCountryField = By.id("CountryId");
    private final By shipToZipCodeField = By.id("ZipPostalCode");
    private final By shipToApplyButton = By.cssSelector(".apply-shipping-button-container > button");
    private final By productSubTotalText = By.cssSelector(".cart > tbody > tr > .subtotal > .product-subtotal");
    private final By orderSubTotalText = By.cssSelector(".cart-total > tbody> .order-subtotal >.cart-total-right");
    private final By pageBody = By.tagName("body");
    private final By groundOption = By.xpath("//div[contains(text(),'Ground')]");
    private final By estimateShippingPopup = By.id("estimate-shipping-popup");
    private final By orderGroundOption = By.cssSelector(".cart-total > tbody > .shipping-cost >.cart-total-left > span");
    private final By orderTotals = By.cssSelector(".cart-total");
    private final By termsOfService = By.id("termsofservice");
    private final By checkOutButton = By.id("checkout");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(100));
    private void clickOnTermsOfService(){
        click(termsOfService,5);
    }
    public CheckOutPage clickOnCheckOutButton(){
        clickOnTermsOfService();
        click(checkOutButton,5);
        return new CheckOutPage(driver);
    }
    private void clickOnPageBody(){
        click(pageBody,5);
    }
    private void clickOnEstimateShippingPopup(){
        click(estimateShippingPopup,5);
    }
    public void clickOnOrderTotals(){
        click(orderTotals,5);
    }

    public String getGroundOptionText(){
        return getText(groundOption , 5);
    }
    public String getOrderGroundOption(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(orderTotals));
        scrollIntoElement(driver ,orderTotals );
        return getText(orderGroundOption , 5);
    }
    public void insertQuantityField(String quantity )
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(quantityField)).click().sendKeys(Keys.DELETE).sendKeys(quantity).build().perform();
        clickOnPageBody();
    }
    public void clickOnRemoveFromCard(){
        click(removeFromCard , 5);
    }
    public String getProductSubTotalText(){
        return getText(productSubTotalText , 10);
    }
    public String getOrderSubTotalText(){
        return getText(orderSubTotalText , 10);
    }
    private void selectShipToCountry(String countryText){
        selectByVisibleText(shipToCountryField,5,countryText);
    }
    private void insertShipToZipCode(String zipCode){
        sendKeys(shipToZipCodeField,5,zipCode);
    }
    private void clickOnShipToApplyButton(){
        click(shipToApplyButton,5);
    }

    public String estimateShipFeature(String countryText , String zipCode)  {
        click(estimateShipButton,5);
        selectShipToCountry(countryText);
        insertShipToZipCode(zipCode);
        clickOnEstimateShippingPopup();
        wait.until(ExpectedConditions.visibilityOfElementLocated(groundOption));
        String groundText = getGroundOptionText();
        clickOnShipToApplyButton();
        // clickOnOrderTotals();
        return groundText;
    }

}
