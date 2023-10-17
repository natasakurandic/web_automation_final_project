package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzerDaniel;

public class SignupTests  extends BasicTest{

    @Test(priority = 1, retryAnalyzer = RetryAnalyzerDaniel.class)
        public void visitsTheSignupPage() {
        navPage.clickOnSignupButton();
        navPage.waitUntilCurrentUrlContainsSignup();
    }
    @Test(priority = 2, retryAnalyzer = RetryAnalyzerDaniel.class)
    public void checksInputTypes() {
        navPage.clickOnSignupButton();
        Assert.assertEquals(signupPage.nameInput().getAttribute("type"), "text",
                "The 'type' attribute for the name input field is not correct.");
        Assert.assertEquals(signupPage.emailInput().getAttribute("type"), "email",
                "The 'type' attribute for the email input field is not correct.");
        Assert.assertEquals(signupPage.passwordInput().getAttribute("type"), "password",
                "The 'type' attribute for the password input field is not correct.");
        Assert.assertEquals(signupPage.confirmPasswordInput().getAttribute("type"), "password",
                "The 'type' attribute for the confirmPassword input field is not correct.");
    }
    @Test(priority = 3, retryAnalyzer = RetryAnalyzerDaniel.class)
    public void displaysErrorsWhenUserAlreadyExists() {
        String name = "Another User";
        String email = "admin@admin.com";
        String password = "12345";
        String confirmPassword = "12345";

        navPage.clickOnSignupButton();
        navPage.waitUntilCurrentUrlContainsSignup();
        signupPage.clearAndTypeNameField(name);
        signupPage.clearAndTypeEmailField(email);
        signupPage.clearAndTypePasswordField(password);
        signupPage.clearAndTypeConfirmPasswordField(confirmPassword);
        signupPage.clickOnSignMeUpButton();
        signupPage.waitUntilPopupErrorMessageIsVisible();

        String errorText = signupPage.popupErrorText();
        Assert.assertTrue(errorText.contains("E-mail already exists"), "The error text is not valid");
        navPage.waitUntilCurrentUrlContainsSignup();
    }
}
