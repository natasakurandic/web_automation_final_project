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
        String cityName = "Nis";
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
}
