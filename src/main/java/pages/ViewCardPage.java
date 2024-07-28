package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class ViewCardPage extends MethodHandles {
    public ViewCardPage(WebDriver driver) {
        super(driver);
    }
    private final By quantityText = By.cssSelector(".cart_quantity > button");

    public String getQuantityText(){
        return getText(quantityText,5);
    }
}
