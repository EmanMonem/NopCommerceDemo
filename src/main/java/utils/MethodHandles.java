package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MethodHandles {
    protected WebDriver driver;
    WebDriverWait wait;
    Select select;

    Actions actions;
    static ExtentReports extent;
    static ExtentTest test;

    public MethodHandles(WebDriver driver){
        this.driver =driver;
    }

    private   final By barNotification = By.id("bar-notification");
    public boolean barNotificationIsDisplayed(){
        return isDisplayed(barNotification,5);
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
    private void alertWait(int time){
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.alertIsPresent());
    }
    private void frameWait(By locator, int time){
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
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

    protected void clear(By locator,int time){
        for (int i = 0;i<5;i++){
            try {
                explicitWait(locator,time);
                addBorderToElement(driver,webElement(locator));
                setSteps();
                webElement(locator).clear();
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

    protected boolean isDisplayed(By locator,int time){
        boolean flag = false;
        for (int i =0;i<5;i++){
            try {
                explicitWait(locator,time);
                addBorderToElement(driver,webElement(locator));
                setSteps();
                flag= webElement(locator).isDisplayed();
                break;
            }catch (StaleElementReferenceException e){

            }
        }
        return flag;
    }
    protected boolean isSelected(By locator,int time){
        boolean flag = false;
        for (int i =0;i<5;i++){
            try {
                explicitWait(locator,time);
                addBorderToElement(driver,webElement(locator));
                setSteps();
                flag= webElement(locator).isSelected();
                break;
            }catch (StaleElementReferenceException e){

            }
        }
        return flag;
    }


    protected void clickWithActions(By locator,int time){
        for (int i=0;i<5;i++){
            try {
                explicitWait(locator,time);
                addBorderToElement(driver,webElement(locator));
                setSteps();
                actions = new Actions(driver);
                actions.click(webElement(locator)).build().perform();
                break;
            }catch (StaleElementReferenceException e){

            }
        }

    }
    protected void dragAndDrop(By src,By target,int time){
        for (int i=0;i<5;i++){
            try {
                explicitWait(src,time);
                addBorderToElement(driver,webElement(src));
                explicitWait(target,time);
                addBorderToElement(driver,webElement(target));
                setSteps();
                actions = new Actions(driver);
                actions.dragAndDrop(webElement(src),webElement(target)).build().perform();
                break;
            }catch (StaleElementReferenceException e){

            }
        }
    }
    protected void doubleClick(By locator,int time){
        for (int i=0;i<5;i++){
            try {
                explicitWait(locator,time);
                addBorderToElement(driver,webElement(locator));
                setSteps();
                actions = new Actions(driver);
                actions.doubleClick(webElement(locator)).build().perform();
                break;
            }catch (StaleElementReferenceException e){

            }
        }
    }
    protected void contextClick(By locator,int time){
        for (int i=0;i<5;i++){
            try {
                explicitWait(locator,time);
                addBorderToElement(driver,webElement(locator));
                setSteps();
                actions = new Actions(driver);
                actions.contextClick(webElement(locator)).build().perform();
                break;
            }catch (StaleElementReferenceException e){

            }
        }
    }
    protected void hoverOverElement(By locator,int time){
        for (int i=0;i<5;i++){
            try {
                explicitWait(locator,time);
                actions = new Actions(driver);
                actions.moveToElement(webElement(locator)).build().perform();
                break;
            }catch (StaleElementReferenceException e){

            }
        }

    }

    protected void selectByVisibleText(By locator, int time, String visibleText){
        for (int i=0;i<5;i++){
            try {
                explicitWait(locator,time);
                addBorderToElement(driver,webElement(locator));
                setSteps();
                select = new Select(webElement(locator));
                select.selectByVisibleText(visibleText);
                break;
            }catch (StaleElementReferenceException e){

            }
        }
    }
    protected void selectByValue(By locator, int time, String value){
        for (int i=0;i<5;i++){
            try {
                explicitWait(locator,time);
                addBorderToElement(driver,webElement(locator));
                setSteps();
                select = new Select(webElement(locator));
                select.selectByValue(value);
                break;
            }catch (StaleElementReferenceException e){

            }
        }
    }
    protected void selectByIndex(By locator, int time, int index){
        for (int i=0;i<5;i++){
            try {
                explicitWait(locator,time);
                addBorderToElement(driver,webElement(locator));
                setSteps();
                select = new Select(webElement(locator));
                select.selectByIndex(index);
                break;
            }catch (StaleElementReferenceException e){

            }
        }
    }
    protected void acceptAlert(int time){
        alertWait(time);
        driver.switchTo().alert().accept();
    }
    protected void dismissAlert(int time){
        alertWait(time);
        driver.switchTo().alert().dismiss();
    }
    protected void sendKeysAlert(int time, String text){
        alertWait(time);
        driver.switchTo().alert().sendKeys(text);
    }
    protected String getTextAlert(int time){
        alertWait(time);
        return driver.switchTo().alert().getText();
    }
    protected void switchToFrameWithNameOrID(String nameOrID){
        driver.switchTo().frame(nameOrID);
    }
    protected void switchToFrameWithWebElement(By locator, int time){
        for (int i=0;i<5;i++){
            try {

                driver.switchTo().frame(webElement(locator));
                frameWait(locator,time);
                break;
            }catch (StaleElementReferenceException e){

            }
        }

    }
    protected void switchToParent(){
        driver.switchTo().parentFrame();
    }

    public void scrollIntoElement(WebDriver driver, By locator ) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",webElement(locator));
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