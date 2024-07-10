package emailFriend;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.io.FileNotFoundException;

import static org.testng.Assert.assertTrue;

public class EmailFriendTests extends BaseTests {

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
    public void testUserCanEmailFriend() throws FileNotFoundException {
        ProductDetailsPage productDetailsPage = homePage.searchUsingAutoSuggest("mac");
        EmailFriendPage emailFriendPage= productDetailsPage.clickOnEmailFriendButton();
        EmailFriendResultPage emailFriendResultPage=emailFriendPage.emailFriendFeature(dataModel().EmailFriend.emailFriend,dataModel().EmailFriend.personalMessage);
        Assert.assertTrue(emailFriendResultPage.emailFriendTextIsDisplayed());
    }
}
