package register;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.RegisterPage;

public class RegisterTests extends BaseTests {


    @Test
    public void testRegisterSuccessfully(){

        RegisterPage registerPage = homePage.clickOnRegisterLink();
        registerPage.registerWithAllMandatoryFields("dd","ff","dd@dd.com","111111","111111");

    }
}
