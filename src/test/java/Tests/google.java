package Tests;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 * Created by dinesh on 20/06/14.
 */
public class google {
    WebDriver driver = new FirefoxDriver();

    @Before
    public void startBrowser() {
        driver.get("https://google.com");
    }

    @Test
    public void serachOnGoogle() throws Exception {
        driver.findElement(By.id("gbqfq")).sendKeys("Dinesh");
    }

    @After
    public void closeBrowser() {
        driver.close();
    }
}
