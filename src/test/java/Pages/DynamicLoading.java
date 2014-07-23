package Pages;

import Frameworks.BaseTestClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by dinesh on 21/07/14.
 */
public class DynamicLoading {

    BaseTestClass baseTestClass = new BaseTestClass();

    public WebElement findTheElement(String header, String text){
        WebElement foundElement = baseTestClass.driver.findElement(By.xpath("//"+header+"[contains(.,\'"+text+"\')]"));
        return foundElement;
    }

    public void verifyingTheDynamicLoadingPage(){
        assert findTheElement("h3", "Dynamically Loaded Page Elements").isDisplayed();
        assert findTheElement("p", "It's common to see an action get triggered that returns a result dynamically. It does not rely on the page to reload or finish loading. The page automatically gets updated (e.g. hiding elements, showing elements, updating copy, etc) through the use of JavaScript.").isDisplayed();
        assert findTheElement("p", "There are two examples. One in which an element already exists on the page but it is not displayed. And anonther where the element is not on the page and gets added in.").isDisplayed();
        assert findTheElement("a", "Example 1: Element on page that is hidden").isDisplayed();
        assert findTheElement("a", "Example 2: Element rendered after the fact").isDisplayed();
    }

    public void verifyingTheHiddenElement(){
        findTheElement("a", "Example 1: Element on page that is hidden").click();
        assert findTheElement("h3", "Dynamically Loaded Page Elements").isDisplayed();
        assert findTheElement("h4", "Example 1: Element on page that is hidden").isDisplayed();
        assert findTheElement("button", "Start").isDisplayed();
    }
}
