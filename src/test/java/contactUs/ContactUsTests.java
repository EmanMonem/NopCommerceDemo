package contactUs;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.ContactUsResultPage;

import java.io.FileNotFoundException;

public class ContactUsTests extends BaseTests {


    @Test
    public void testContactUsSuccessfully() throws FileNotFoundException {
        ContactUsPage contactUsPage = homePage.clickOnContactUsLink();
        ContactUsResultPage contactUsResultPage = contactUsPage.contactUsFeature(dataModel().ContactUs.name ,dataModel().ContactUs.email,dataModel().ContactUs.enquiry);
        Assert.assertTrue(contactUsResultPage.contactUsTextIsDisplayed());


    }
}
