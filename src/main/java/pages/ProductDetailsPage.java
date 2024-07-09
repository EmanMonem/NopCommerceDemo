package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class ProductDetailsPage extends MethodHandles {
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    private final By productName = By.xpath("(//h2[@class='product-title'])");

    public String getProductName(){
        return getText(productName , 5);
    }
}
