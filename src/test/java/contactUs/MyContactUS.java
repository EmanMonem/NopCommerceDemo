package contactUs;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MyContactUSPage;

public class MyContactUS extends BaseTests {
    @Test
    public void testContactUsSuccessfully(){
        MyContactUSPage myContactUSPage = homePage.clickOnContactUsLink1();
        Assert.assertTrue(myContactUSPage.getInTouchIsDisplayed());
        myContactUSPage.contactUsFeature("eman","d@hh.com","sfd","sf","C:\\Users\\eman.mohamed\\Desktop\\icon.png");
        Assert.assertTrue(myContactUSPage.successfulMessageTextIsDisplayed());
        myContactUSPage.clickOnHomeButton();



    }
}
