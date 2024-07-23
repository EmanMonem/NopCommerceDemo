package checkOut;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.io.FileNotFoundException;

public class RegisteredUserCheckOutTests extends BaseTests {

    @Test(priority = 1 , alwaysRun = true)
    public void testRegisterSuccessfully() throws FileNotFoundException {

        RegisterPage registerPage = homePage.clickOnRegisterLink();
        registerPage.registerWithAllMandatoryFields(
                dataModel().Register.firstName,
                dataModel().Register.lastName,
                dataModel().Register.email,
                dataModel().Register.password,
                dataModel().Register.confirmPassword);
        RegisterResultPage registerResultPage = registerPage.clickOnRegisterButton();
        String expectedResult = dataModel().expectedRegisterResultText;
        String actualResult = registerResultPage.getRegisterResultText();
        Assert.assertEquals(actualResult,expectedResult);
        // myAssertEquals(actualResult,expectedResult);
    }
    @Test(dependsOnMethods = {"testRegisterSuccessfully"})
    public void testRegisteredUserCanCheckOut(){
        ProductDetailsPage productDetailsPage = homePage.searchUsingAutoSuggest("mac");
        productDetailsPage.clickOnAddToCardButton();
        assert(productDetailsPage.barNotificationIsDisplayed());
        CardPage cardPage = productDetailsPage.clickOnShoppingCardLink();
        CheckOutPage checkOutPage = cardPage.clickOnCheckOutButton();
        CheckOutCompletePage checkOutCompletePage = checkOutPage.checkOutFeature("Egypt","d","d","123456","123456");
        Assert.assertTrue(checkOutCompletePage.successfulTextIsDisplayed());
        OrderDetailsPage orderDetailsPage = checkOutCompletePage.clickOnClickHereLink();
        orderDetailsPage.clickOnPrintInvoiceButton();

    }
}
