package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
}
