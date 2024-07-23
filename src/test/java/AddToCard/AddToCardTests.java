package AddToCard;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CardPage;
import pages.ProductDetailsPage;

public class AddToCardTests extends BaseTests {
    @Test
    public void testUserCanAddProductToCard() throws InterruptedException {
        ProductDetailsPage productDetailsPage = homePage.searchUsingAutoSuggest("mac");
        productDetailsPage.clickOnAddToCardButton();
        assert(productDetailsPage.barNotificationIsDisplayed());
        homePage.searchUsingAutoSuggest("asus");
        productDetailsPage.clickOnAddToCardButton();
        assert(productDetailsPage.barNotificationIsDisplayed());
        CardPage cardPage = productDetailsPage.clickOnShoppingCardLink();
        cardPage.clickOnRemoveFromCard();
        cardPage.insertQuantityField("4");
        Assert.assertEquals(cardPage.getProductSubTotalText() ,cardPage.getOrderSubTotalText() );
        String groundText = cardPage.estimateShipFeature("Egypt","1");
        cardPage.getOrderGroundOption();
        Assert.assertTrue(cardPage.getOrderGroundOption().contains(groundText));


    }
}
