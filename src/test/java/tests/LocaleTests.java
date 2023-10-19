package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzerDaniel;

public class LocaleTests extends BasicTest{


    @Test(priority = 1, retryAnalyzer = RetryAnalyzerDaniel.class)
    public void setLocaleToES() {
        navPage.languageButton();
        navPage.waitForDropDownMenuVisibility();
        navPage.languageEs();
        Assert.assertEquals(landingPage.textFromLandingPageTitle(), "Página de aterrizaje");
    }
}
