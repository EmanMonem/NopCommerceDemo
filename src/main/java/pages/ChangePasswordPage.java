package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class ChangePasswordPage extends MethodHandles {
    public ChangePasswordPage(WebDriver driver) {
        super(driver);
    }

    private final By oldPasswordField = By.id("OldPassword");
    private final By newPasswordField = By.id("NewPassword");
    private final By confirmPasswordField = By.id("ConfirmNewPassword");
    private final By changePasswordButton = By.xpath("//button[contains(text(),'Change password')]");
    //final static By logOutLink = By.xpath("//a[contains(text(),'Log out')]") ;

    private void insertOldPassword(String oldPassword){
        sendKeys(oldPasswordField,5,oldPassword);
    }
    private void insertNewPassword(String newPassword){
        sendKeys(newPasswordField,5,newPassword);
    }
    private void insertConfirmPassword(String confirmPassword){
        sendKeys(confirmPasswordField,5,confirmPassword);
    }

    private void clickOnChangePasswordButton(){
        click(changePasswordButton,5);
    }

    public void changePasswordFeature(String oldPassword , String newPassword , String confirmPassword){
        insertOldPassword(oldPassword);
        insertNewPassword(newPassword);
        insertConfirmPassword(confirmPassword);
        clickOnChangePasswordButton();
    }
//    public void clickOnLogOutLink(){
//        click(logOutLink,5);
//    }


}
