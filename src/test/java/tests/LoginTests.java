package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzerDaniel;

public class LoginTests extends BasicTest{

    @Test(priority = 1, retryAnalyzer = RetryAnalyzerDaniel.class)
    public void visitsTheLoginPage() {
        navPage.languageButton();
        navPage.languageEn();
        navPage.clickLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "login", "Should be redirected to login page.");
    }
    @Test(priority = 2, retryAnalyzer = RetryAnalyzerDaniel.class)
    public void checksInputTypes() {
        navPage.clickLoginButton();

        Assert.assertEquals(loginPage.getEmailInput().getAttribute("type"), "email", "The 'type' attribute for the email input field is not correct.");
        Assert.assertEquals(loginPage.getPasswordInput().getAttribute("type"), "password", "The 'type' attribute for the password input field is not correct.");
    }
    @Test(priority = 3, retryAnalyzer = RetryAnalyzerDaniel.class)
    public void displaysErrorsWhenUserDoesNotExist() {
        String email = "non-existing-user@gmal.com";
        String password = "password123";
        navPage.clickLoginButton();
        loginPage.clearEndTypeEmailField(email);
        loginPage.clearEndTypePasswordField(password);
        loginPage.clickLoginButtonAfterInputsFields();
        messagePopUp.waitUntilPopupErrorMessageIsVisible();
        String errorText = messagePopUp.popupErrorText();
        Assert.assertTrue(errorText.contains("User does not exists"), "The error text is not valid");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "login", "Should be redirected to login page.");
    }
    @Test(priority = 4, retryAnalyzer = RetryAnalyzerDaniel.class)
    public void displaysErrorsWhenPasswordIsWrong() {
        String email = "admin@admin.com";
        String password = "password123";
        navPage.clickLoginButton();
        loginPage.clearEndTypeEmailField(email);
        loginPage.clearEndTypePasswordField(password);
        loginPage.clickLoginButtonAfterInputsFields();
        messagePopUp.waitUntilPopupErrorMessageIsVisible();
        String errorText = messagePopUp.popupErrorText();
        Assert.assertTrue(errorText.contains("Wrong password"), "The error text is not valid");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "login", "Should be redirected to login page.");
    }
    @Test(priority = 5, retryAnalyzer = RetryAnalyzerDaniel.class)
    public void login() {
        String email = "admin@admin.com";
        String password = "12345";
        navPage.clickLoginButton();
        loginPage.clearEndTypeEmailField(email);
        loginPage.clearEndTypePasswordField(password);
        loginPage.clickLoginButtonAfterInputsFields();
        navPage.waitUntilCurrentUrlContainsHome();
    }
    @Test(priority = 6, retryAnalyzer = RetryAnalyzerDaniel.class)
    public void logout() {
        navPage.waitForLogoutButton();
        navPage.clickOnLogoutButton();
    }
}
