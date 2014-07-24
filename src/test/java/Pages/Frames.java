package Pages;

import Frameworks.BaseTestClass;
import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Created by dinesh on 24/07/14.
 */
public class Frames {
    BaseTestClass baseTestClass = new BaseTestClass();

    public void verifyingTheFramesPage(){
        Assert.assertTrue(baseTestClass.findTheElement("h3", "Frames").isDisplayed());
        Assert.assertTrue(baseTestClass.findTheElement("a", "Nested Frames").isDisplayed());
        Assert.assertTrue(baseTestClass.findTheElement("a", "iFrame").isDisplayed());
    }

    public void verifyingTheNestedFramesPage(){
        baseTestClass.findTheElement("a", "Nested Frames").click();
        Assert.assertEquals("BOTTOM", baseTestClass.driver.switchTo().frame("frame-bottom").findElement(By.cssSelector("body")).getText());
        Assert.assertEquals("LEFT", baseTestClass.driver.switchTo().frame("frame-top").switchTo().frame("frame-left").findElement(By.cssSelector("body")).getText());
        Assert.assertEquals("MIDDLE", baseTestClass.driver.switchTo().frame("frame-middle").findElement(By.cssSelector("body")).getText());
        Assert.assertEquals("RIGHT", baseTestClass.driver.switchTo().frame("frame-right").findElement(By.cssSelector("body")).getText());
        baseTestClass.goBack();
    }


}
