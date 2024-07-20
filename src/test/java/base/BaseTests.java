package base;

import data.DataModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import reader.ReadDataFromJson;
import utils.ScreenRecorderUtil;
import utils.UtilsTests;

import java.io.FileNotFoundException;
import java.lang.reflect.Method;

public class BaseTests {

    protected WebDriver driver;
    ChromeOptions chromeOptions;
    EdgeOptions edgeOptions;
    FirefoxOptions firefoxOptions;
    protected DataModel dataModel;
    protected HomePage homePage;
    UtilsTests utilsTests;

    @Parameters("browser")
    public void setUpBrowser(@Optional("chrome") String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("headlessChrome")) {
            chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            driver = new ChromeDriver(chromeOptions);
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("headlessEdge")) {
            edgeOptions = new EdgeOptions();
            edgeOptions.addArguments("--headless");
            driver = new EdgeDriver(edgeOptions);
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("headlessFireFox")) {
            firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("--headless");
            driver = new FirefoxDriver(firefoxOptions);
        }
    }

    @Parameters("browser")
    @BeforeClass
    public String setup(@Optional("chrome") String browser)  {
        setUpBrowser(browser);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        return browser;
    }

    @BeforeMethod
    public void goHome(Method method) throws Exception {
        utilsTests = new UtilsTests(driver);
        ScreenRecorderUtil.startRecord(method.getName());
        driver.get(dataModel().URL);
        utilsTests.createTestCaseInReport(method);

    }

    @AfterMethod
    public void afterMethod(Method method, ITestResult result) throws Exception {
        utilsTests = new UtilsTests(driver);
        utilsTests.takeScreenShot(method);
        ScreenRecorderUtil.stopRecord();
        utilsTests.setStatus(method, result);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @BeforeSuite
    public void beforeSuite() {
        utilsTests = new UtilsTests(driver);
        utilsTests.createReport();
    }

    @AfterSuite
    public void afterSuite() {
        utilsTests = new UtilsTests(driver);
        utilsTests.flushReport();
    }

    protected DataModel dataModel() throws FileNotFoundException {
        return dataModel = new ReadDataFromJson().readJsonFile();
    }


}
