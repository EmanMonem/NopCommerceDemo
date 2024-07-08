package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class HomePage extends MethodHandles {

    public HomePage(WebDriver driver) {
        super(driver);

    }
    final static By registerLink = By.xpath("(//a[contains(text(),'Register')])");
    final static By loginLink = By.xpath("(//a[contains(text(),'Log in')])");
    final static By myAccountLink = By.xpath("(//a[contains(text(),'My account')])");
    final static By searchField = By.id("small-searchterms");
    final static By searchButton = By.xpath("(//button[contains(text(),'Search')])");

    public RegisterPage clickOnRegisterLink(){
        click(registerLink,5);
        return new RegisterPage(driver);
    }
    public LoginPage clickOnLoginPage(){
        click(loginLink,5);
        return new LoginPage(driver);
    }
    public boolean myAccountLinkIsDisplayed(){
        return isDisplayed(myAccountLink,5);
    }

    private void insertSearchField(String searchText){
        sendKeys(searchField , 5 ,searchText);
    }
    private void clickOnSearchButton(){
        click(searchButton,5);
    }

    public SearchResultPage searchFeature(String searchText){
        insertSearchField(searchText);
        clickOnSearchButton();
        return new SearchResultPage(driver);
    }


}
