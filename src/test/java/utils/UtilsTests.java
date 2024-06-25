package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import static org.testng.Assert.assertEquals;
import static utils.MethodHandles.extent;
import static utils.MethodHandles.test;

public class UtilsTests {
    WebDriver driver;


    public UtilsTests(WebDriver driver) {
        this.driver = driver;
    }

    public void takeScreenShot(Method method) throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("report/" + method.getName() + ".png"));
    }

    public void createReport() {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("report/report.html");
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("My Report");
        extent.attachReporter(spark);
    }

    public void createTestCaseInReport(Method method){
        test = extent.createTest(method.getName());
        test.info(MarkupHelper.createLabel("------------ Steps To Reproduce ------------", ExtentColor.TEAL));
    }
    public static void endOfSteps(){
        test.info(MarkupHelper.createLabel("------------ Ends Of Steps ------------", ExtentColor.TEAL));
    }
    public void setStatus(Method method, ITestResult result) {

        if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test Pass");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            endOfSteps();
            test.info(MarkupHelper.createLabel("------------The actual result does not match the expected result------------", ExtentColor.GREY));
            test.fail("Test Fail");
        }
        test.addScreenCaptureFromPath(method.getName()+".png");
        test.log(Status.INFO, "<a href='" + method.getName() + ".avi'> Download Video</a>");
    }

    public void flushReport() {
        extent.flush();
    }

    public static void myAssertEquals(String actual, String expected) {
        endOfSteps();
        test.info(MarkupHelper.createLabel("------------ Expected Result ------------", ExtentColor.GREY));
        test.info(expected);
        test.info(MarkupHelper.createLabel("------------ Actual Result ------------", ExtentColor.GREY));
        test.info(actual);

        assertEquals((String)actual, (String)expected, (String)null);
    }

}