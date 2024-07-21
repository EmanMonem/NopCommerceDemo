package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class CardPage extends MethodHandles {
    public CardPage(WebDriver driver) {
        super(driver);
    }
    private final By quantityField = By.id("itemquantity11253");
    private final By continueShoppingButton = By.xpath("//button[contains(text(),'Continue shopping')]");
    private final By estimateShipButton = By.xpath("//button[contains(text(),'Estimate shipping')]");

    public void insertQuantityField(String quantity){
        clear(quantityField,5);
        sendKeys(quantityField,5,quantity);
    }
}
