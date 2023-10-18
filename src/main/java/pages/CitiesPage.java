package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage extends BasicPage{
    public CitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
       public WebElement newItemButton() {
        return driver.findElement(By.className("btnNewItem"));
    }
    public void clickOnNewItemButton() {
        newItemButton().click();
    }
    public void waitForCreateEditDialogVisibility() {
        wait
                .withMessage("Create/edit dialog is not visible")
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("dlgNewEditItem")));
    }
    public WebElement citiesNameInput() {
        return driver.findElement(By.id("name"));
    }
}
