package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUp extends BasicPage {
    public MessagePopUp (WebDriver driver, WebDriverWait wait) {
        super (driver, wait);
    }
    public void waitUntilPopupErrorMessageIsVisible() {
        wait
                .withMessage("Popup error message is not visible")
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div")));
    }
    public String popupErrorText() {
        return driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li")).getText();
    }
    public void closeButton () {
        driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/button/span"));
    }
    public WebElement verifyAccountDialog() {
        return driver.findElement(By.className("dlgVerifyAccount"));
    }
    public void waitForVerifyMessageToBeVisible() {
        wait
                .withMessage("Verify popup is not presented")
                .until(ExpectedConditions.visibilityOf(verifyAccountDialog()));
    }
    public String verifyAccountMessage() {
        return verifyAccountDialog().getText();
    }
    public WebElement verifyDialogCloseButton() {
        return driver.findElement(By.className("btnClose"));
    }
    public void clickOnVerifyDialogCloseButton() {
        verifyDialogCloseButton().click();
    }

    public WebElement successMessageDialog() {
        return driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[3]/div/div/div/div"));
    }
    public void waitForSuccessPopup() {
    wait
            .withMessage("Success popup dialog is not visible")
            .until(ExpectedConditions.visibilityOfElementLocated(By.className("success")));
    }
}
