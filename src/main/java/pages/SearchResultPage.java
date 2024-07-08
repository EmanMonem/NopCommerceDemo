package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class SearchResultPage extends MethodHandles {
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }
    final static By productTitle = By.xpath("(//h2[@class='product-title'])");

    public boolean productTitleIsDisplayed(){
        return isDisplayed(productTitle , 5);
    }

}
