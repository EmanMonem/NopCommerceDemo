package myAccount;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.io.FileNotFoundException;

public class MyAccountTests extends BaseTests {

    RegisterResultPage registerResultPage ;

    @Test(priority = 1 , alwaysRun = true)
    public void testRegisterSuccessfully() throws FileNotFoundException {

        RegisterPage registerPage = homePage.clickOnRegisterLink();
        registerPage.registerWithAllMandatoryFields(
                dataModel().Register.firstName,
                dataModel().Register.lastName,
                dataModel().Register.email,
                dataModel().Register.password,
                dataModel().Register.confirmPassword);
        registerResultPage = registerPage.clickOnRegisterButton();


        String expectedResult = dataModel().expectedRegisterResultText;
        String actualResult = registerResultPage.getRegisterResultText();
        Assert.assertEquals(actualResult,expectedResult);
        // myAssertEquals(actualResult,expectedResult);
    }

    @Test(dependsOnMethods = {"testRegisterSuccessfully"})
    public void testUserCanChangePassword() throws FileNotFoundException {
        MyAccountPage myAccountPage = registerResultPage.clickOnMyAccountLink();
        ChangePasswordPage changePasswordPage = myAccountPage.clickOnChangePasswordLink();
        changePasswordPage.changePasswordFeature(dataModel().Register.password,dataModel().Register.NewPassword,dataModel().Register.ConfirmNewPassword);
        Assert.assertTrue(changePasswordPage.barNotificationIsDisplayed());
    }

    @Test(dependsOnMethods = {"testUserCanChangePassword"})
    public void testUserCanLogOut(){
        registerResultPage.clickOnLogOutLink();
    }
    @Test(dependsOnMethods = {"testUserCanLogOut"})
    public void testUserCanLogInWithNewPassword() throws FileNotFoundException {
        LoginPage loginPage = homePage.clickOnLoginPage();
        loginPage.loginFeature(dataModel().Register.email,dataModel().Register.NewPassword);
        Assert.assertTrue(homePage.myAccountLinkIsDisplayed());
    }

}
