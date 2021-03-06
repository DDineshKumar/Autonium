package Frameworks;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;

/**
 * Created by dinesh on 10/07/14.
 */
public class BaseTestClass {


    public static WebDriver driver = new FirefoxDriver();

    public void startWebDriver(String url) {
        driver.get(url);
    }

    public void goBack() {
        driver.navigate().back();
    }

    public void quitBrowser() {
        driver.quit();
    }

    public void closeBroswer() {
        driver.close();
    }

    public void switchToCurrentWindow() {
        String winHandleBefore = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }

    public WebElement findTheElement(String header, String text) {
        WebElement foundElement = driver.findElement(By.xpath("//" + header + "[contains(.,\'" + text + "\')]"));
        return foundElement;
    }

    public boolean existsElement(String id) {
        try {
            driver.findElement(By.id(id));
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
        return true;
    }
}
