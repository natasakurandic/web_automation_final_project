package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasicPage;

public class NavPage extends BasicPage {
    public NavPage (WebDriver driver, WebDriverWait wait) {
        super (driver, wait);
    }
    public void clickLoginButton () {
        driver.findElement(By.cssSelector("#app > div > div > header > div > div.v-toolbar__items > a:nth-child(3)")).click();
    }
    public void languageButton () {
        driver.findElement(By.cssSelector("#app > div > div > header > div > div.v-toolbar__items > button")).click();
    }
    public void languageEn () {
        driver.findElement(By.cssSelector("#list-item-73")).click();
    }
    public void waitUntilCurrentUrlContainsHome() {
        wait
                .withMessage("Current Url should contain 'home'")
                .until(ExpectedConditions.urlContains("home"));
    }
    public WebElement logoutButton() {
        return driver.findElement(By.className("btnLogout"));
    }
    public void clickOnLogoutButton () {
        logoutButton().click();
    }
    public void waitForLogoutButton () {
        wait
                .withMessage("Logout button is not visible")
                .until(ExpectedConditions.visibilityOf(logoutButton()));
    }
}
