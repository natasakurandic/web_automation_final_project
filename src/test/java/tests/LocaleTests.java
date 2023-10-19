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
    @Test(priority = 2, retryAnalyzer = RetryAnalyzerDaniel.class)
    public void setLocaleToEN() {
        navPage.languageButton();
        navPage.waitForDropDownMenuVisibility();
        navPage.languageEn();
        Assert.assertEquals(landingPage.textFromLandingPageTitle(), "Landing");
    }
    @Test(priority = 3, retryAnalyzer = RetryAnalyzerDaniel.class)
    public void setLocaleToCN() {
        navPage.languageButton();
        navPage.waitForDropDownMenuVisibility();
        navPage.languageCn();
        Assert.assertEquals(landingPage.textFromLandingPageTitle(), "首页");
    }
    @Test(priority = 4, retryAnalyzer = RetryAnalyzerDaniel.class)
    public void setLocaleToFR() {
        navPage.languageButton();
        navPage.waitForDropDownMenuVisibility();
        navPage.languageFr();
        Assert.assertEquals(landingPage.textFromLandingPageTitle(), "Page d'atterrissage");
    }
}
