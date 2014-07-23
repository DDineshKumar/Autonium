package Tests;

import Frameworks.BaseTestClass;
import Pages.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by dinesh on 10/07/14.
 */
public class HerokuTest {

    BaseTestClass baseTestClass = new BaseTestClass();
    Homepage homePage = new Homepage();
    String[] linkArray = homePage.getLinksHomePage();

    @BeforeMethod
    public void openBrowser() {
        homePage.launchPage();
    }

    @Test
    public void verifyingTheHomePage() {
        for (String link : linkArray) {
            Assert.assertTrue(homePage.findElementWithText(link).isDisplayed());
        }
    }

    @Test
    public void verifyTheABTestingPage() {
        AbTestingPage abTestingPage = new AbTestingPage();
        homePage.clickOnElement("A/B Testing");
        baseTestClass.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(abTestingPage.verifyingTheContent(abTestingPage.returnHeading()));
        Assert.assertTrue(abTestingPage.verifyingTheContent(abTestingPage.returnContent()));
    }

    @Test
    public void verifyTheBasicAuthPage() {
        BasicAuthPage basicAuthPage = new BasicAuthPage();
        basicAuthPage.basicAuthPageUrl();
        Assert.assertTrue(basicAuthPage.verifyingTheContentOfBasicAuthPage(basicAuthPage.basicAuthPageHeader));
        Assert.assertTrue(basicAuthPage.verifyingTheContentOfBasicAuthPage(basicAuthPage.basicAuthPageContent));
    }

    @Test
    public void verifyTheCheckboxesPage() {
        homePage.clickOnElement("Checkboxes");
        CheckboxesPage checkboxesPage = new CheckboxesPage();
        Assert.assertTrue(checkboxesPage.verifyingTheInitialStatusOfCheckBoxes());
        checkboxesPage.clickingTheCheckbox(checkboxesPage.checkbox1);
        checkboxesPage.clickingTheCheckbox(checkboxesPage.checkbox2);
        Assert.assertTrue(checkboxesPage.verifyingTheStatusOfCheckBoxesAfterClicking());
    }


    @Test
    public void verifyTheDropdownPage() {
        homePage.clickOnElement("Dropdown");
        DropdownPage dropdownPage = new DropdownPage();
        dropdownPage.verifyingTheOptionsOfDropDown();
        dropdownPage.selectingTheOption("1");
        dropdownPage.selectingTheOption("2");
    }

    @Test
    public void verifyTheDynamicLoadingPage() {
        DynamicLoading dynamicLoading = new DynamicLoading();
        homePage.clickOnElement("Dynamic Loading");
        dynamicLoading.verifyingTheDynamicLoadingPage();
        dynamicLoading.verifyingTheHiddenElement();
        baseTestClass.goBack();
        dynamicLoading.verifyingTheRenderedElement();
    }

    @AfterClass
    public void closeDriver() {
        baseTestClass.quitBrowser();
    }
}
