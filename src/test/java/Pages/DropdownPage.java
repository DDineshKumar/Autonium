package Pages;

import Frameworks.BaseTestClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import sun.awt.image.ImageWatched;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by dinesh on 15/07/14.
 */
public class DropdownPage {

    BaseTestClass baseTestClass = new BaseTestClass();
    String[] dropDownValues = {"Please select an option", "Option 1", "Option 2"};
    Select dropdown = new Select(baseTestClass.driver.findElement(By.id("dropdown")));

    public void selectingTheOption(String value) {
                dropdown.selectByValue(value);
                }

    public void verifyingTheOptionsOfDropDown() {
        boolean match;
        List<WebElement> orgValues = dropdown.getOptions();
        for (WebElement options1 : orgValues) {
            match = false;
            for (int i = 0; i < dropDownValues.length; i++) {
                if (options1.getText().equals(dropDownValues[i])) {
                    match = true;
                }
            }
            Assert.assertTrue(match, options1.getText());
        }

    }
}

