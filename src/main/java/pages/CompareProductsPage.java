package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.MethodHandles;

import java.util.List;

public class CompareProductsPage extends MethodHandles {
    public CompareProductsPage(WebDriver driver) {
        super(driver);
    }

    private final By clearListButton = By.xpath("//a[contains(text(),'Clear list')]");
    private final By compareProductsTable = By.cssSelector(".compare-products-table");
    private final By firstProduct = By.partialLinkText("Apple MacBook Pro 13");
    private final By secondProduct = By.partialLinkText("Asus N551JK-XO076H L");
    private final By clearListMessage = By.xpath("//div[contains(text(),'You have no items to compare.')]");

    private final By tableTr = By.tagName("tr");
    List<WebElement> allRows = driver.findElements(tableTr);
    private final By tableTd = By.tagName("td");
    List<WebElement> allCols = driver.findElements(tableTd);

    public void clickOnClearListButton(){
        click(clearListButton,5);
    }

    public boolean clearListMessageIsDisplayed(){
        return isDisplayed(clearListMessage,5);
    }
    public String getFirstProductText(){
        return getText(firstProduct,5);
    }
    public String getSecondProductText(){
        return getText(secondProduct,5);
    }

    public void CompareProducts()
    {
        // Get all Rows
        System.out.println(allRows.size());
        // Get data from each Row
        for(WebElement row : allRows)
        {
            System.out.println(row.getText() + "\t");
            for(WebElement col : allCols)
            {
                System.out.println(col.getText()+"\t");
            }
        }
    }


}
