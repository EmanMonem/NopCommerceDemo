package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.MethodHandles;

import java.time.Duration;

public class CheckOutCompletePage extends MethodHandles {
    public CheckOutCompletePage(WebDriver driver) {
        super(driver);
    }
    private final By successfulText = By.cssSelector(".section.order-completed > .title");
    private final By clickHereLink = By.xpath("//a[contains(text(),'Click here for order details.')]");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(100));
    public boolean successfulTextIsDisplayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(successfulText));
        return isDisplayed(successfulText,5);
    }
    public OrderDetailsPage clickOnClickHereLink(){
        click(clickHereLink,5);
        return new OrderDetailsPage(driver);
    }
}
