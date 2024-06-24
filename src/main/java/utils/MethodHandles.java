package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MethodHandles {

    protected WebDriver driver;
    WebDriverWait wait;

    static ExtentReports extent;
    static ExtentTest test;
    public MethodHandles(WebDriver driver ){
        this.driver = driver;
    }

    private WebElement webElement(By locator){
        return driver.findElement(locator);
    }

    private void explicitWait(By locator, int time){
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOf(webElement(locator)),
                ExpectedConditions.visibilityOfElementLocated(locator),
                ExpectedConditions.elementToBeClickable(locator),
                ExpectedConditions.presenceOfElementLocated(locator)));
    }

    protected void click(By locator,int time){
        for (int i = 0;i<5;i++){
            try {
                explicitWait(locator,time);
                addBorderToElement(driver,webElement(locator));
                setSteps();
                webElement(locator).click();
                break;
            }catch (StaleElementReferenceException e){

            }
        }
    }

    protected String getText(By locator,int time){
        String text = null;
        for (int i =0;i<5;i++){
            try {
                explicitWait(locator,time);
                addBorderToElement(driver,webElement(locator));
                setSteps();
                text= webElement(locator).getText();
                break;
            }catch (StaleElementReferenceException e){

            }
        }
        return text;
    }

    protected void sendKeys(By locator,int time,String text){
        for (int i =0;i<5;i++){
            try {
                explicitWait(locator,time);
                addBorderToElement(driver,webElement(locator));
                setSteps();
                webElement(locator).sendKeys(text);
                break;
            }catch (StaleElementReferenceException e){

            }
        }
    }



    private static String getMethodName() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        if (stackTraceElements.length >= 2) {
            if (stackTraceElements.length >= 4)
                return stackTraceElements[4].getMethodName();
            return stackTraceElements[2].getMethodName();
        } else {
            return "Unknown";
        }
    }

    public void setSteps(){
        test.info(getMethodName());
    }
    private static void addBorderToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border = '5px solid red'", element);
    }
}
