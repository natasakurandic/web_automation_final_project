package pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage {

    public LoginPage (WebDriver driver, WebDriverWait wait) {
        super (driver, wait);
    }
    public WebElement getEmailInput () {
        return driver.findElement(By.id("email"));
    }
    public WebElement getPasswordInput () {
        return driver.findElement(By.id("password"));
    }
    public void clearEndTypeEmailField(String email) {
        getEmailInput()
                .clear();
        getEmailInput().sendKeys(email);
    }
    public void clearEndTypePasswordField(String password) {
        getPasswordInput()
                .clear();
        getPasswordInput().sendKeys(password);
    }
    public void clickLoginButtonAfterInputsFields () {
        driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button")).click();
    }




}
