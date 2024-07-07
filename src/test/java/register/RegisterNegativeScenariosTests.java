package register;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegisterPage;
import pages.RegisterResultPage;

import java.io.FileNotFoundException;

public class RegisterNegativeScenariosTests extends BaseTests {

    @Test
    public void testEmptyFirstName() throws FileNotFoundException {
        RegisterPage registerPage = homePage.clickOnRegisterLink();
        registerPage.registerWithAllMandatoryFields(
                "",
                dataModel().Register.lastName,
                dataModel().Register.email,
                dataModel().Register.password,
                dataModel().Register.confirmPassword);

        RegisterResultPage registerResultPage = registerPage.clickOnRegisterButton();
        String expectedResult = dataModel().expectedFirstNameError;
        String actualResult = registerPage.getFirstNameErrorText();
        Assert.assertEquals(actualResult,expectedResult);
    }
}
