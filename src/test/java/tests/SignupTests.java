package tests;

import org.testng.annotations.Test;
import retry.RetryAnalyzerDaniel;

public class SignupTests  extends BasicTest{

    @Test(priority = 1, retryAnalyzer = RetryAnalyzerDaniel.class)
        public void visitsTheSignupPage() {
        navPage.clickOnSignupButton();
        navPage.waitUntilCurrentUrlContainsSignup();
    }

}
