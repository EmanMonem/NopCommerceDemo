package MyCard;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MyProductDetailsPage;
import pages.ViewCardPage;

public class ViewCardTests extends BaseTests {
    @Test
    public void testUserCanViewProductInCart(){
        MyProductDetailsPage myProductDetailsPage = homePage.clickOnViewProductLink();
        myProductDetailsPage.insertQuantityField("4");
        myProductDetailsPage.clickOnAddToCardButton();
        ViewCardPage viewCardPage= myProductDetailsPage.clickOnViewCardLink();
        Assert.assertEquals("4",viewCardPage.getQuantityText());
    }
}
