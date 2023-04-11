package com.projectname.e2e.tests.pages.demo;

import com.projectname.e2e.tests.pages.common.PageBase;
import com.projectname.e2e.tests.selectors.CustomBy;
import com.projectname.e2e.tests.utils.CheckIfElement;
import com.projectname.e2e.tests.webdriver.CustomWebDriver;
import org.openqa.selenium.WebElement;

public class NavBarPage extends PageBase {
    public NavBarPage(CustomWebDriver driver, String url, String email, String password) {
        super(driver, url, email, password);
    }

    @Override
    public PageBase show() {
        return null;
    }

    @Override
    public boolean isDisplayed() {
        return CheckIfElement.isDisplayed(CustomBy.xpath("//*[@id=\"navbar\"]/div[1]/a/img"), driver);
    }

    private WebElement getSolutionsButton(){
        try {
            return driver.findElement(CustomBy.xpath("//*[@id=\"navbar\"]/div[2]/div[1]/a"));
        } catch (Exception e){
            throw new AssertionError("Could not find solutions button", e);
        }
    }

    public SolutionsPage openSolutionsPage(){
        getSolutionsButton().click();
        return new SolutionsPage(driver, url, email,password);
    }

    private WebElement getContactUsButton(){
        try {
            return driver.findElement(CustomBy.xpath("//*[@id=\"navbar\"]/div[2]/div[5]/a"));
        } catch (Exception e){
            throw new AssertionError("Could not find contact us button", e);
        }
    }

    public ContactUsPage openContactUsPage(){
        getContactUsButton().click();
        return new ContactUsPage(driver, url, email,password);
    }
}
