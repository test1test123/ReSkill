package com.projectname.e2e.tests.pages.demo;

import com.projectname.e2e.tests.pages.common.PageBase;
import com.projectname.e2e.tests.selectors.CustomBy;
import com.projectname.e2e.tests.utils.CheckIfElement;
import com.projectname.e2e.tests.webdriver.CustomWebDriver;

public class ContactUsDetailsPage extends PageBase {
    public ContactUsDetailsPage(CustomWebDriver driver, String url, String email, String password) {
        super(driver, url, email, password);
    }

    @Override
    public PageBase show() {
        if(!isDisplayed()) {
            NavBarPage navBarPage = new NavBarPage(driver, url, email, password);
            if(navBarPage.isDisplayed()) {
                navBarPage.openSolutionsPage();
            }
        }
        return this;
    }

    @Override
    public boolean isDisplayed() {
        return CheckIfElement.isDisplayed(CustomBy.xpath("//*[@id=\"main\"]/div[2]/a"), driver);
    }
}
