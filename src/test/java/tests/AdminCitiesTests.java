package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzerDaniel;

public class AdminCitiesTests extends BasicTest{
    @Test(priority = 1, retryAnalyzer = RetryAnalyzerDaniel.class)
        public void  visitsTheAdminCitiesPageAndListCities() {
        String email = "admin@admin.com";
        String password = "12345";

        navPage.clickLoginButton();
        loginPage.clearEndTypeEmailField(email);
        loginPage.clearEndTypePasswordField(password);
        loginPage.clickLoginButtonAfterInputsFields();
        navPage.clickOnAdminButton();
        navPage.clickOnCitiesButton();
        navPage.waitUntilCurrentUrlContainsAdminCities();
    }
    @Test(priority = 2, retryAnalyzer = RetryAnalyzerDaniel.class)
        public void checksInputTypesForCreateEditNewCity() {
        navPage.clickOnAdminButton();
        navPage.clickOnCitiesButton();
        citiesPage.clickOnNewItemButton();
        citiesPage.waitForCreateEditDialogVisibility();
        Assert.assertEquals(citiesPage.citiesNameInput().getAttribute("type"), "text",
                "The 'type' attribute for the cities name input field is not correct.");
    }
    @Test(priority = 3, retryAnalyzer = RetryAnalyzerDaniel.class)
    public void createNewCity() {
        String cityName = "Madrid";
        navPage.clickOnAdminButton();
        navPage.clickOnCitiesButton();
        citiesPage.clickOnNewItemButton();
        citiesPage.waitForCreateEditDialogVisibility();
        citiesPage.clearEndTypeCitiesNameField(cityName);
        citiesPage.clickOnDialogSaveButton();
        messagePopUp.waitForSuccessPopup();
        Assert.assertTrue(messagePopUp.successMessageDialog().getText().contains("Saved successfully"),
                "Success message should contain text: 'Saved successfully'");
    }
    @Test(priority = 4, retryAnalyzer = RetryAnalyzerDaniel.class)
    public void editCity() {
        String cityName = "Madrid";
        String newCityName = "Barcelona";
        navPage.clickOnAdminButton();
        navPage.clickOnCitiesButton();
        citiesPage.typeSearchCityInput(cityName);
        citiesPage.waitForNumberOfTableRows(1);
        citiesPage.clickOnEditButtonFromTableRow(1);
        citiesPage.typeEditCityInput(newCityName);
        citiesPage.clickOnDialogSaveButton();
        messagePopUp.waitForSuccessPopup();
        Assert.assertTrue(messagePopUp.successMessageDialog().getText().contains("Saved successfully"),
                "Success message should contain text: 'Saved successfully'");
    }
    @Test(priority = 5, retryAnalyzer = RetryAnalyzerDaniel.class)
    public void searchCity() {
        String newCityName = "Barcelona";
        navPage.clickOnAdminButton();
        navPage.clickOnCitiesButton();
        citiesPage.typeSearchCityInput(newCityName);
        citiesPage.waitForNumberOfTableRows(1);
        Assert.assertEquals(citiesPage.getTextFromField(1,2), newCityName,
                "City in the name field should be " + newCityName);
    }
    @Test(priority = 6, retryAnalyzer = RetryAnalyzerDaniel.class)
    public void deleteCity() {
        String newCityName = "Barcelona";
        navPage.clickOnAdminButton();
        navPage.clickOnCitiesButton();
        citiesPage.typeSearchCityInput(newCityName);
        citiesPage.waitForNumberOfTableRows(1);
        Assert.assertEquals(citiesPage.getTextFromField(1,2), newCityName,
                "City in the name field should be " + newCityName);
        citiesPage.clickOnDeleteButtonFromTable(1);
        citiesPage.deleteDialogVisible();
        citiesPage.clickOnDialogDeleteButton();
        messagePopUp.waitForSuccessPopup();
        Assert.assertTrue(messagePopUp.successMessageDialog().getText().contains("Deleted successfully"),
                "Success message should contain text: 'Saved successfully'");
    }
}
