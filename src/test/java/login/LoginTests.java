package login;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.FileNotFoundException;

public class LoginTests extends BaseTests {

    @Test
    public void testSuccessfulLogin() throws FileNotFoundException {
        LoginPage loginPage = homePage.clickOnLoginPage();
        loginPage.loginFeature(dataModel().Register.email,dataModel().Register.password);
        Assert.assertTrue(homePage.myAccountLinkIsDisplayed());

    }
}
