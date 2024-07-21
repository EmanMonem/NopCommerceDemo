package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class ProductDetailsPage extends MethodHandles {
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    private final By productName = By.cssSelector(".product-name > h1");
    private final By emailFriendButton = By.xpath("//button[contains(text(),'Email a friend')]");
    private final By addReviewLink = By.xpath("//a[contains(text(),'Add your review')]");
    private final By reviewTitleField = By.id("AddProductReview_Title");
    private final By reviewTextField = By.id("AddProductReview_ReviewText");
    private final By rateField = By.id("addproductrating_2");
    private final By submitReviewButton = By.id("add-review");
    private final By addToCompareListButton = By.xpath("//button[contains(text(),'Add to compare list')]");
    private final By productComparisonLink = By.xpath("//a[contains(text(),'product comparison')]");
    private final By addToCardButton = By.xpath("//input[contains(@id, 'add-to-cart-button')])");
    private final By shoppingCardLink = By.xpath("//a[contains(text(),'shopping cart')]");

    public String getProductName(){
        return getText(productName , 5);
    }

    public EmailFriendPage clickOnEmailFriendButton(){
        click(emailFriendButton,5);
        return new EmailFriendPage(driver);
    }

    private void clickOnAddReviewLink(){
        click(addReviewLink,5);
    }
    private void insertReviewTitle(String reviewTitle){
        sendKeys(reviewTitleField , 5, reviewTitle);
    }
    private void insertReviewText(String reviewText){
        sendKeys(reviewTextField, 5, reviewText);
    }
    private void clickOnRate(){
        click(rateField,5);
    }
    private void clickOnSubmitReviewButton(){
        click(submitReviewButton,5);
    }
    public void addReviewFeature(String reviewTitle ,String reviewText ){
        clickOnAddReviewLink();
        insertReviewTitle(reviewTitle);
        insertReviewText(reviewText);
        clickOnRate();
        clickOnSubmitReviewButton();
    }
    public void clickOnAddToCompareListButton(){
        click(addToCompareListButton , 5);
    }
    public CompareProductsPage  clickOnProductComparisonLink(){
        click(productComparisonLink , 5);
        return new CompareProductsPage(driver);
    }
    public void clickOnAddToCardButton(){
        click(addToCardButton , 5);
    }
    public CardPage clickOnShoppingCardLink(){
        click(shoppingCardLink,5);
        return new CardPage(driver);
    }

}
