package com.projectname.e2e.tests.pages;

import com.projectname.e2e.tests.pages.common.PageBase;
import com.projectname.e2e.tests.selectors.CustomBy;
import com.projectname.e2e.tests.utils.CheckIfElement;
import com.projectname.e2e.tests.webdriver.CustomWebDriver;
import org.openqa.selenium.WebElement;

public class PhpLoginPage extends PageBase {

    public PhpLoginPage(CustomWebDriver driver, String url, String email, String password) {
        super(driver, url, email, password);
    }

    @Override
    public PageBase show() {
        if(!isDisplayed()) {
            NavigationBarPage navigationBarPage = new NavigationBarPage(driver, url, email, password);
            if(navigationBarPage.isDisplayed()) {
                navigationBarPage.openDemoPage();
            }
        }
        return this;
    }

    @Override
    public boolean isDisplayed() {
        return CheckIfElement.isDisplayed(CustomBy.xpath("//*[@id=\"main-body\"]/div/div[1]/div/form/div/div[1]/div[1]/h6"), driver);
    }

    public LoginDetailsPage login(String email, String password){
       getEmailField().click();
       getEmailField().clear();
       getEmailField().sendKeys(email);
       getPassword().click();
       getPassword().clear();
       getPassword().sendKeys(password);
       getLoginButton().click();
       driver.waitForElementToBePresent(CustomBy.xpath("//*[@id=\"main-body\"]/div/div[1]/div[1]/div[1]/div"));
       return new LoginDetailsPage(driver, "", email, password);
    }

    private WebElement getEmailField(){
        try{
            return driver.findElement(CustomBy.xpath("/html/body/section/div/div[1]/div/form/div/div[1]/div[2]/div/input"));
        } catch (Exception e) {
            throw new AssertionError("Could not find Email filed", e);
        }
    }

    private WebElement getPassword(){
        try{
            return driver.findElement(CustomBy.id("inputPassword"));
        } catch (Exception e) {
            throw new AssertionError("Could not find password filed", e);
        }
    }


    private WebElement getLoginButton(){
        try{
            return driver.findElement(CustomBy.id("login"));
        } catch (Exception e) {
            throw new AssertionError("Could not find login filed", e);
        }
    }




}
