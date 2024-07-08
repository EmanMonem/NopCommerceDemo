package search;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.SearchResultPage;

import java.io.FileNotFoundException;

public class SearchTests extends BaseTests {

    @DataProvider
    public Object[][] dataForSearch() throws FileNotFoundException {
       return dataModel().Search;
    }

    @Test(dataProvider = "dataForSearch")
    public void testSearch(String Search){
        SearchResultPage searchResultPage = homePage.searchFeature(Search);
        Assert.assertTrue(searchResultPage.productTitleIsDisplayed());
    }
}
