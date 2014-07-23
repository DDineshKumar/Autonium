package Pages;

import Frameworks.BaseTestClass;

/**
 * Created by dinesh on 14/07/14.
 */
public class AbTestingPage {

    BaseTestClass baseTestClass = new BaseTestClass();
    String heading = "A/B Test Variation 1";
    String content = "\n" +
            "    Also known as split testing. This is a way in which businesses are able to simultaneously test and learn different versions of a page to see which text and/or functionality works best towards a desired outcome (e.g. a user action such as a click-through).";

    public String returnHeading() {
        return heading;
    }

    public String returnContent() {
        return content;
    }

    public boolean verifyingTheContent(String verifyingContent) {
        return baseTestClass.driver.getPageSource().contains(verifyingContent);
    }
}
