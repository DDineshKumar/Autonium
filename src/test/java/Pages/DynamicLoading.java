package Pages;

import Frameworks.BaseTestClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Created by dinesh on 21/07/14.
 */
public class DynamicLoading {

    BaseTestClass baseTestClass = new BaseTestClass();

    public WebElement findTheElement(String header, String text) {
        WebElement foundElement = baseTestClass.driver.findElement(By.xpath("//" + header + "[contains(.,\'" + text + "\')]"));
        return foundElement;
    }

    public void verifyingTheDynamicLoadingPage() {
        String p1 = "It's common to see an action get triggered that returns a result dynamically. It does not rely on the page to reload or finish loading. The page automatically gets updated (e.g. hiding elements, showing elements, updating copy, etc) through the use of JavaScript.";
        Assert.assertTrue(findTheElement("h3", "Dynamically Loaded Page Elements").isDisplayed());
        Assert.assertTrue(findTheElement("p", "There are two examples. One in which an element already exists on the page but it is not displayed. And anonther where the element is not on the page and gets added in.").isDisplayed());
        Assert.assertEquals(p1, findTheElement("p", "common to see an action get triggered that returns a result dynamically. It does not rely on the page").getText());
        Assert.assertTrue(findTheElement("a", "Example 1: Element on page that is hidden").isDisplayed());
        Assert.assertTrue(findTheElement("a", "Example 2: Element rendered after the fact").isDisplayed());
    }

    public void verifyingTheHiddenElement() {
        findTheElement("a", "Example 1: Element on page that is hidden").click();
        Assert.assertTrue(findTheElement("h3", "Dynamically Loaded Page Elements").isDisplayed());
        Assert.assertTrue(findTheElement("h4", "Example 1: Element on page that is hidden").isDisplayed());
        Assert.assertTrue(findTheElement("button", "Start").isDisplayed());
        Assert.assertFalse(findTheElement("h4", "Hello World!").isDisplayed());
        findTheElement("button", "Start").click();
        WebDriverWait wait = new WebDriverWait(baseTestClass.driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(., 'Hello World!')]")));
        Assert.assertTrue(findTheElement("h4", "Hello World!").isDisplayed());
    }
}
