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
    public void clearEndTypeCitiesNameField(String citiesName) {
        citiesNameInput().clear();
        citiesNameInput().sendKeys(citiesName);
    }
    public WebElement dialogSaveButton() {
        return driver.findElement(By.className("btnSave"));
    }
    public void clickOnDialogSaveButton() {
        dialogSaveButton().click();
    }
    public WebElement searchCityInput() {
        return driver.findElement(By.id("search"));
    }
    public void typeSearchCityInput(String citiesName) {
        searchCityInput().sendKeys(citiesName);
    }
    public void waitForNumberOfTableRows(int numberOfRows){
        wait
                .withMessage("Number of rows should be " + numberOfRows)
                .until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("tbody>tr"), numberOfRows));
    }
    public WebElement getEditButtonTableRow(int row){
        return driver.findElements(By.id("edit")).get(row-1);
    }
    public void clickOnEditButtonFromTableRow(int row){
        getEditButtonTableRow(row).click();
    }
//    public WebElement editCityName() {
//        return driver.findElement(By.id("name"));
//    }
    public void typeEditCityInput(String newCityName) {
        citiesNameInput().sendKeys(newCityName);
    }
}
