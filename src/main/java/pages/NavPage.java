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
    public void languageEs () {
        driver.findElement(By.className("btnES")).click();
    }
    public void waitForDropDownMenuVisibility() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[2]")));
    }
    public void languageEn () {
        driver.findElement(By.className("btnEN")).click();
    }
    public void languageCn () {
        driver.findElement(By.className("btnCN")).click();
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
    public WebElement signupButton () {
        return driver.findElement(By.xpath("//*[@id='app']/div[1]/div/header/div/div[3]/a[4]"));
    }
    public void clickOnSignupButton () {
        signupButton().click();
    }
    public void waitUntilCurrentUrlContainsSignup() {
        wait
                .withMessage("Current Url should contain 'signup'")
                .until(ExpectedConditions.urlContains("signup"));
    }
    public WebElement adminButton() {
        return driver.findElement(By.xpath("//*[@id='app']/div[1]/div/header/div/div[3]/button[1]"));
    }
    public void clickOnAdminButton() {
        adminButton().click();
    }
    public WebElement citiesButton() {
        return driver.findElement(By.className("btnAdminCities"));
    }
    public void clickOnCitiesButton() {
        citiesButton().click();
    }
    public void waitUntilCurrentUrlContainsAdminCities() {
        wait
                .withMessage("Current Url should contain 'admin/cities'")
                .until(ExpectedConditions.urlContains("admin/cities"));
    }
}
