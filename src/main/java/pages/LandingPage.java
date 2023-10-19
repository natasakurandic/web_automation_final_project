package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage extends BasicPage{

    public LandingPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement landingPageTitle() {
        return driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[1]/div[1]/h1"));
    }
    public String textFromLandingPageTitle(){
        return landingPageTitle().getText();
    }
}
