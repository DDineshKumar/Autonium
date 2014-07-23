package Pages;

import Frameworks.BaseTestClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by dinesh on 15/07/14.
 */
public class CheckboxesPage {
    BaseTestClass baseTestClass = new BaseTestClass();
    public WebElement checkbox1 = baseTestClass.driver.findElement(By.cssSelector("form input:nth-of-type(1)"));
    public WebElement checkbox2 = baseTestClass.driver.findElement(By.cssSelector("form input:nth-of-type(2)"));

    public boolean getTheStatusofCheckboxes(WebElement checkbox) {
        return checkbox.isSelected();
    }

    public void clickingTheCheckbox(WebElement checkbox) {
        checkbox.click();
    }

    public boolean verifyingTheInitialStatusOfCheckBoxes() {
        if (getTheStatusofCheckboxes(checkbox1) == false && getTheStatusofCheckboxes(checkbox2) == true)
            return true;
        else
            return false;
    }

    public boolean verifyingTheStatusOfCheckBoxesAfterClicking() {
        if (getTheStatusofCheckboxes(checkbox1) == true && getTheStatusofCheckboxes(checkbox2) == false)
            return true;
        else
            return false;
    }
}
