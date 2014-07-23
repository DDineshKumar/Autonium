package Tests;

import Frameworks.BaseTestClass;
import Pages.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

/**
 * Created by dinesh on 10/07/14.
 */
public class HerokuTest {

    BaseTestClass baseTestClass = new BaseTestClass();
    Homepage homePage = new Homepage();
    String[] linkArray = homePage.getLinksHomePage();

    @BeforeClass
    public void openBrowser() {
        homePage.launchPage();
    }

    @Test
    public void verifyingTheHomePage() {
        for (String link : linkArray) {
            assert homePage.findElementWithText(link).isDisplayed();
        }
    }

    @Test
    public void verifyTheABTestingPage() {
        AbTestingPage abTestingPage = new AbTestingPage();
        homePage.clickOnElement("A/B Testing");
        assert abTestingPage.verifyingTheContent(abTestingPage.returnHeading());
        assert abTestingPage.verifyingTheContent(abTestingPage.returnContent());
    }

    @Test
    public void verifyTheBasicAuthPage() {
        BasicAuthPage basicAuthPage = new BasicAuthPage();
        basicAuthPage.basicAuthPageUrl();
        assert basicAuthPage.verifyingTheContentOfBasicAuthPage(basicAuthPage.basicAuthPageHeader);
        assert basicAuthPage.verifyingTheContentOfBasicAuthPage(basicAuthPage.basicAuthPageContent);
        baseTestClass.goBack();
        baseTestClass.goBack();
    }

    @Test
    public void verifyTheCheckboxesPage(){
        homePage.clickOnElement("Checkboxes");
        CheckboxesPage checkboxesPage = new CheckboxesPage();
        assert checkboxesPage.verifyingTheInitialStatusOfCheckBoxes();
        checkboxesPage.clickingTheCheckbox(checkboxesPage.checkbox1);
        checkboxesPage.clickingTheCheckbox(checkboxesPage.checkbox2);
        assert checkboxesPage.verifyingTheStatusOfCheckBoxesAfterClicking();
        baseTestClass.goBack();
    }

    @Test
    public void verifyTheDropdownPage() {
        homePage.clickOnElement("Dropdown");
        DropdownPage dropdownPage = new DropdownPage();
        dropdownPage.verifyingTheOptionsOfDropDown();
        dropdownPage.selectingTheOption("1");
        dropdownPage.selectingTheOption("2");
        baseTestClass.goBack();
    }

    @Test
    public void verifyTheDynamicLoadingPage(){
        DynamicLoading dynamicLoading = new DynamicLoading();
        dynamicLoading.verifyingTheDynamicLoadingPage();
    }

    @AfterClass
    public void closeDriver() {
        baseTestClass.quitBrowser();
    }
}
