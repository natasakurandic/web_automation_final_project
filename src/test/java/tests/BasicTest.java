package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.io.IOException;
import java.time.Duration;

import static tests.Helper.*;

public abstract class BasicTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseUrl = "https://vue-demo.daniel-avellaneda.com/";
    protected LoginPage loginPage;
    protected NavPage navPage;
    protected MessagePopUp messagePopUp;
    protected SignupPage signupPage;
    protected CitiesPage citiesPage;
    @BeforeClass
    public void setup () {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage = new LoginPage(driver, wait);
        navPage = new NavPage(driver, wait);
        messagePopUp = new MessagePopUp(driver, wait);
        signupPage = new SignupPage(driver,wait);
        citiesPage = new CitiesPage(driver, wait);


    }
    @BeforeMethod
    public void beforeMethod () {
        driver.navigate().to(baseUrl);
    }
    @AfterMethod
    public void afterMethod (ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            takeAScreenshot(driver, "screenshots/" + testResult.getName() + ".jpg");
        }
    }
    @AfterClass
    public void afterClass () {
        driver.quit();
    }
}
