package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.HomePage;

import java.lang.reflect.Method;

public class BaseTests {

    WebDriver driver;
    ChromeOptions chromeOptions;
    EdgeOptions edgeOptions;
    FirefoxOptions firefoxOptions;
    protected HomePage homePage;


    @Parameters("browser")
    public void setUpBrowser(String browser) {
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
    public String setup(String browser)  {
        setUpBrowser(browser);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        return browser;
    }

    @BeforeMethod
    public void goHome(Method method) throws Exception {
        //utilsTests = new UtilsTests(driver);
       // ScreenRecorderUtil.startRecord(method.getName());
        driver.get("https://demo.nopcommerce.com/");
       // utilsTests.createTestCaseInReport(method);

    }
}
