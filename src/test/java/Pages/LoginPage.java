package Pages;

import Frameworks.BaseTestClass;
import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Created by dinesh on 23/07/14.
 */
public class LoginPage {
    BaseTestClass baseTestClass = new BaseTestClass();

    public void verifyingTheLoginPage() {
        Assert.assertTrue(baseTestClass.findTheElement("h2", "Login Page").isDisplayed());
        Assert.assertTrue(baseTestClass.findTheElement("h4", "This is where you can log into the secure area. Enter tomsmith for the username and SuperSecretPassword! for the password. If the information is wrong you should see error messages.").isDisplayed());
        Assert.assertTrue(baseTestClass.driver.findElement(By.id("username")).isDisplayed());
        Assert.assertTrue(baseTestClass.driver.findElement(By.id("password")).isDisplayed());
    }

    public void invalidUsername() throws Exception {
        baseTestClass.driver.findElement(By.id("username")).sendKeys("fsdfsdfsd");
        baseTestClass.driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        baseTestClass.findTheElement("button", "Login").click();
        Assert.assertTrue(baseTestClass.driver.findElement(By.id("flash")).getText().contains("Your username is invalid!"));
        baseTestClass.driver.findElement(By.xpath("//*[@id='flash']/a")).click();
        Thread.sleep(1000);
        Assert.assertFalse(baseTestClass.existsElement("flash"));

    }

    public void invalidPassword() throws Exception {
        baseTestClass.driver.findElement(By.id("username")).sendKeys("tomsmith");
        baseTestClass.driver.findElement(By.id("password")).sendKeys("fsfdfsd");
        baseTestClass.findTheElement("button", "Login").click();
        Assert.assertTrue(baseTestClass.driver.findElement(By.id("flash")).getText().contains("Your password is invalid!"));
        baseTestClass.driver.findElement(By.xpath("//*[@id='flash']/a")).click();
        Thread.sleep(1000);
        Assert.assertFalse(baseTestClass.existsElement("flash"));
    }

    public void loggingInAndloggingOut() throws Exception {
        baseTestClass.driver.findElement(By.id("username")).sendKeys("tomsmith");
        baseTestClass.driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        baseTestClass.findTheElement("button", "Login").click();
        Assert.assertTrue(baseTestClass.driver.findElement(By.id("flash")).getText().contains("You logged into a secure area!"));
        baseTestClass.driver.findElement(By.xpath("//*[@id='flash']/a")).click();
        Thread.sleep(1000);
        Assert.assertFalse(baseTestClass.existsElement("flash"));
        baseTestClass.driver.findElement(By.xpath("//*[@id='content']/div/a")).click();
        Assert.assertEquals("http://the-internet.herokuapp.com/login", baseTestClass.driver.getCurrentUrl());
    }


}
