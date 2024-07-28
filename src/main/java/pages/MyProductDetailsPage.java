package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class MyProductDetailsPage extends MethodHandles {
    public MyProductDetailsPage(WebDriver driver) {
        super(driver);
    }
    private final By quantityField = By.id("quantity");
    private final By addToCardButton = By.cssSelector(".btn.btn-default.cart");
    private final By viewCardLink = By.xpath("//u[contains(text(),'View Cart')]");


    public void insertQuantityField(String quantity){
        clear(quantityField,5);
        sendKeys(quantityField,5,quantity);
    }

    public void clickOnAddToCardButton(){
        click(addToCardButton , 5);
    }
    public ViewCardPage clickOnViewCardLink(){
        click(viewCardLink,5);
        return new ViewCardPage(driver);
    }

}
