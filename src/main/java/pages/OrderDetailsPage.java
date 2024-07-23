package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class OrderDetailsPage extends MethodHandles {
    public OrderDetailsPage(WebDriver driver) {
        super(driver);

    }
    private final By printButton = By.xpath("//a[contains(text(),'Print')]");
    private final By printInvoiceButton = By.xpath("//a[contains(text(),'PDF Invoice')]");

    public void clickOnPrintButton(){
        click(printButton,5);
    }
    public void clickOnPrintInvoiceButton(){
        click(printInvoiceButton,5);
    }
}
