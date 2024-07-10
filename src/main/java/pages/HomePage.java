package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.MethodHandles;

import java.time.Duration;
import java.util.List;

public class HomePage extends MethodHandles {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By registerLink = By.xpath("(//a[contains(text(),'Register')])");
    private final By loginLink = By.xpath("(//a[contains(text(),'Log in')])");
    private final By myAccountLink = By.xpath("(//a[contains(text(),'My account')])");
    private final By searchField = By.id("small-searchterms");
    private final By searchButton = By.xpath("(//button[contains(text(),'Search')])");
    private final By searchBox = By.xpath("//ul[@id='ui-id-1']"); // Corrected locator
    private final By contactUsLink = By.xpath("//a[contains(text(),'Contact us')]");

    public RegisterPage clickOnRegisterLink(){
        click(registerLink, 5);
        return new RegisterPage(driver);
    }

    public LoginPage clickOnLoginPage(){
        click(loginLink, 5);
        return new LoginPage(driver);
    }

    public boolean myAccountLinkIsDisplayed(){
        return isDisplayed(myAccountLink, 5);
    }

    private void insertSearchField(String searchText){
        sendKeys(searchField, 10, searchText);
    }

    private void clickOnSearchButton(){
        click(searchButton, 10);
    }

    public SearchResultPage searchFeature(String searchText){
        insertSearchField(searchText);
        clickOnSearchButton();
        return new SearchResultPage(driver);
    }

    private void clickFromList(By locator, int index, int timeout) {
        List<WebElement> elements = driver.findElements(locator);
        if (elements.size() > index) {
            WebElement element = elements.get(index);
            element.click();  // You can add custom wait logic here if needed
        } else {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for elements list of size " + elements.size());
        }
    }

    public ProductDetailsPage searchUsingAutoSuggest(String search) {
        insertSearchField(search);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds timeout
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
        List<WebElement> searchBoxList = driver.findElements(searchBox);

        if (!searchBoxList.isEmpty()) {
            clickFromList(searchBox, 0, 5); // Click the first element in the list
        }
        return new ProductDetailsPage(driver);
    }

    public ContactUsPage clickOnContactUsLink(){
        scrollIntoElement(driver, contactUsLink);
        click(contactUsLink, 5);
        return new ContactUsPage(driver);
    }
}
