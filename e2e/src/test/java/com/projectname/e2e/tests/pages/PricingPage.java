package com.projectname.e2e.tests.pages;

import com.projectname.e2e.tests.pages.common.PageBase;
import com.projectname.e2e.tests.selectors.CustomBy;
import com.projectname.e2e.tests.utils.CheckIfElement;
import com.projectname.e2e.tests.webdriver.CustomWebDriver;

public class PricingPage extends PageBase {
    public PricingPage(CustomWebDriver driver, String url, String email, String password) {
        super(driver, url, email, password);
    }

    @Override
    public PageBase show() {
        return null;
    }

    @Override
    public boolean isDisplayed() {
        return CheckIfElement.isDisplayed(CustomBy.xpath("//*[@id=\"content\"]/div[2]/div/div"), driver);
    }
}
