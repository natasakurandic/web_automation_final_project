package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends BasicPage {
    public SignupPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement nameInput() {
        return driver.findElement(By.id("name"));
    }
    public WebElement emailInput() {
        return driver.findElement(By.id("email"));
    }
    public WebElement passwordInput() {
        return driver.findElement(By.id("password"));
    }
    public WebElement confirmPasswordInput() {
        return driver.findElement(By.id("confirmPassword"));
    }
    public void clearAndTypeNameField(String name) {
        nameInput().clear();
        nameInput().sendKeys(name);
    }
    public void clearAndTypeEmailField(String email) {
        emailInput().clear();
        emailInput().sendKeys(email);
    }
    public void clearAndTypePasswordField(String password) {
        passwordInput().clear();
        passwordInput().sendKeys(password);
    }
    public void clearAndTypeConfirmPasswordField(String confirmPassword) {
        confirmPasswordInput().clear();
        confirmPasswordInput().sendKeys(confirmPassword);
    }
    public WebElement signMeUpButton() {
        return driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button"));
    }
    public void clickOnSignMeUpButton() {
        signMeUpButton().click();
    }
    public void waitUntilPopupErrorMessageIsVisible() {
        wait
                .withMessage("Popup error message is not visible")
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div")));
    }
    public String popupErrorText() {
        return driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/ul/li")).getText();
    }
}
