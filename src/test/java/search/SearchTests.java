package search;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchResultPage;

import java.io.FileNotFoundException;

import static org.testng.Assert.assertTrue;

public class SearchTests extends BaseTests {

//    @DataProvider
//    public Object[][] dataForSearch() throws FileNotFoundException {
//        return dataModel().Search;
//    }
//
//    @Test(dataProvider = "dataForSearch")
//    public void testSearch(String Search){
//        SearchResultPage searchResultPage = homePage.searchFeature(Search);
//        Assert.assertTrue(searchResultPage.productTitleIsDisplayed());
//    }

    @Test
    public void testSearchUsingAutoComplete(){
        ProductDetailsPage productDetailsPage = homePage.searchUsingAutoSuggest("mac");
        String actualResult = productDetailsPage.getProductName();
        String expectedResult = "Mac";
        System.out.println(actualResult);
        assertTrue(actualResult.contains(expectedResult));

    }
}