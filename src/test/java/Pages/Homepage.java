package Pages;

import Frameworks.BaseTestClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by dinesh on 10/07/14.
 */
public class Homepage {
    BaseTestClass baseTestClass = new BaseTestClass();
    String[] linksInHomePage = {"A/B Testing", "Basic Auth", "Checkboxes", "Drag and Drop", "Dropdown", "Dynamic Loading", "File Download", "File Upload", "Forgot Password", "Form Authentication", "Frames", "Geolocation", "Hovers", "JQuery UI Menus"};


    public void launchPage() {
        String url = "http://the-internet.herokuapp.com/";
        baseTestClass.startWebDriver(url);
    }

    public WebElement findElementWithText(String linkWithText) {
        return baseTestClass.driver.findElement(By.xpath("//a[contains(.,\'" + linkWithText + "\')]"));
    }

    public void clickOnElement(String linkWithText) {
        //WebElement waitForElement = (new WebDriverWait(baseTestClass.driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(.,\'" + linkWithText + "\')]")));
        findElementWithText(linkWithText).click();
    }

    public String[] getLinksHomePage() {
        return linksInHomePage;
    }

}
