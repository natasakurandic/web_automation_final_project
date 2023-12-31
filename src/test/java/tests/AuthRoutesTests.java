package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzerDaniel;

public class AuthRoutesTests extends BasicTest {

    @Test(priority = 1, retryAnalyzer = RetryAnalyzerDaniel.class)
    public void forbidsVisitsToHomeUrlIfNotAuthenticated() {
        driver.navigate().to(baseUrl + "home");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "login", "Should be redirected to login page.");
    }
    @Test(priority = 2, retryAnalyzer = RetryAnalyzerDaniel.class)
    public void forbidsVisitsToProfileUrlIfNotAuthenticated() {
        driver.navigate().to(baseUrl + "profile");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "login", "Should be redirected to login page.");
    }
    @Test(priority = 3, retryAnalyzer = RetryAnalyzerDaniel.class)
    public void forbidsVisitsToAdmin_CitiesUrlIfNotAuthenticated() {
        driver.navigate().to(baseUrl + "admin/cities");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "login", "Should be redirected to login page.");
    }
    @Test(priority = 4, retryAnalyzer = RetryAnalyzerDaniel.class)
    public void forbidsVisitsToAdmin_UsersUrlIfNotAuthenticated() {
        driver.navigate().to(baseUrl + "admin/users");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "login", "Should be redirected to login page.");
    }

}
