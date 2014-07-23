package Pages;

import Frameworks.BaseTestClass;
import org.openqa.selenium.WebDriver;

/**
 * Created by dinesh on 14/07/14.
 */
public class BasicAuthPage {

    BaseTestClass baseTestClass = new BaseTestClass();
    public String basicAuthPageHeader = "Basic Auth";
    public String basicAuthPageContent = "     Congratulations! You must have the proper credentials.   ";

    public void basicAuthPageUrl() {
        String url = "http://admin:admin@the-internet.herokuapp.com/basic_auth";
        baseTestClass.startWebDriver(url);
    }

    public boolean verifyingTheContentOfBasicAuthPage(String verifyingContent) {
        return baseTestClass.driver.getPageSource().contains(verifyingContent);
    }
}
