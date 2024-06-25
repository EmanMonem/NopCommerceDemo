package register;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.RegisterPage;
import pages.RegisterResultPage;

import java.io.FileNotFoundException;

import static utils.UtilsTests.myAssertEquals;

public class RegisterTests extends BaseTests {



//    @Test
//    public void testRegisterSuccessfully() throws FileNotFoundException {
//
//        RegisterPage registerPage = homePage.clickOnRegisterLink();
//        registerPage.registerWithAllMandatoryFields(
//                dataModel().Register.firstName,
//                dataModel().Register.lastName,
//                dataModel().Register.email,
//                dataModel().Register.password,
//                dataModel().Register.confirmPassword);
//        RegisterResultPage registerResultPage = registerPage.clickOnRegisterButton();
//
//        String expectedResult = dataModel().expectedRegisterResultText;
//        String actualResult = registerResultPage.getRegisterResultText();
//        Assert.assertEquals(actualResult,expectedResult);
//       // myAssertEquals(actualResult,expectedResult);
//    }

    @DataProvider
    public Object[][] dataForRegister() throws FileNotFoundException {
        return dataModel().RegisterWithDifferentUsers;
    }

    @Test(dataProvider = "dataForRegister")
    public void testRegisterWithDifferentUsers(String firstname , String lastName , String email , String password , String confirmPassword) throws FileNotFoundException {
        RegisterPage registerPage = homePage.clickOnRegisterLink();
        registerPage.registerWithAllMandatoryFields(firstname,lastName,email,password,confirmPassword);
        RegisterResultPage registerResultPage = registerPage.clickOnRegisterButton();
        String expectedResult = dataModel().expectedRegisterResultText;
        String actualResult = registerResultPage.getRegisterResultText();
        Assert.assertEquals(actualResult,expectedResult);

        //registerResultPage.clickOnLogOutLink();

    }
}
