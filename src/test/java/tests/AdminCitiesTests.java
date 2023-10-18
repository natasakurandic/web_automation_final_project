package tests;

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
}
