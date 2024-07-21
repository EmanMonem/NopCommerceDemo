package compareList;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CompareProductsPage;
import pages.ProductDetailsPage;

public class CompareListTests extends BaseTests {


    @Test
    public void testUserCanAddProductToCompareList(){
        ProductDetailsPage productDetailsPage = homePage.searchUsingAutoSuggest("mac");
        productDetailsPage.clickOnAddToCompareListButton();
        assert(productDetailsPage.barNotificationIsDisplayed());
        homePage.searchUsingAutoSuggest("asus");
        productDetailsPage.clickOnAddToCompareListButton();
        assert(productDetailsPage.barNotificationIsDisplayed());
        CompareProductsPage compareProductsPage = productDetailsPage.clickOnProductComparisonLink();
        //compareProductsPage.CompareProducts();
        Assert.assertTrue(compareProductsPage.getFirstProductText().contains("Mac"));
        Assert.assertTrue(compareProductsPage.getSecondProductText().contains("Asus"));
        compareProductsPage.clickOnClearListButton();
        Assert.assertTrue(compareProductsPage.clearListMessageIsDisplayed());


    }
}
