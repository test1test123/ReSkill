package com.projectname.e2e.tests.pages.demo;

import com.projectname.e2e.tests.pages.common.PageBase;
import com.projectname.e2e.tests.selectors.CustomBy;
import com.projectname.e2e.tests.utils.CheckIfElement;
import com.projectname.e2e.tests.webdriver.CustomWebDriver;
import org.openqa.selenium.WebElement;

public class ContactUsPage extends PageBase {
    public ContactUsPage(CustomWebDriver driver, String url, String email, String password) {
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
        return CheckIfElement.isDisplayed(CustomBy.xpath("//*[@id=\"contact-us\"]/div/div/div[2]/div/div/div[2]/h2"),driver);
    }

    public ContactUsDetailsPage contactUs(String fullName, String organisation, String email, String phone, String comment){
        getNameField().click();
        getNameField().clear();
        getNameField().sendKeys(fullName);
        getOrganisationField().click();
        getOrganisationField().clear();
        getOrganisationField().sendKeys(organisation);
        getEmailFiled().click();
        getEmailFiled().clear();
        getEmailFiled().sendKeys(email);
        getPhoneField().click();
        getPhoneField().clear();
        getPhoneField().sendKeys(phone);
        getComment().click();
        getComment().clear();
        getComment().sendKeys(comment);
        getCheckbox().click();
        getSendMessageButton().click();
        driver.waitForElementToBePresent(CustomBy.xpath("//*[@id=\"main\"]/div[2]/a"));
        return new ContactUsDetailsPage(driver, "", email, password);
    }



    private WebElement getNameField(){
        try{
            return driver.findElement(CustomBy.id("fullname"));
        } catch (Exception e) {
            throw new AssertionError("Could not find Name filed", e);
        }
    }

    private WebElement getOrganisationField(){
        try{
            return driver.findElement(CustomBy.id("organization"));
        } catch (Exception e) {
            throw new AssertionError("Could not find Organisation filed", e);
        }
    }

    private WebElement getEmailFiled(){
        try{
            return driver.findElement(CustomBy.id("email"));
        } catch (Exception e) {
            throw new AssertionError("Could not find Email filed", e);
        }
    }

    private WebElement getPhoneField(){
        try{
            return driver.findElement(CustomBy.id("phone"));
        } catch (Exception e) {
            throw new AssertionError("Could not find Phone filed", e);
        }
    }

    private WebElement getComment(){
        try{
            return driver.findElement(CustomBy.id("message"));
        } catch (Exception e) {
            throw new AssertionError("Could not find Comment filed", e);
        }
    }

    private WebElement getCheckbox(){
        try{
            return driver.findElement(CustomBy.id("label_field_34"));
        } catch (Exception e) {
            throw new AssertionError("Could not find CheckBox filed", e);
        }
    }

    private WebElement getSendMessageButton(){
        try{
            return driver.findElement(CustomBy.xpath("//*[@id=\"14\"]/div[1]/div[9]/div[2]/button/div[1]"));
        } catch (Exception e) {
            throw new AssertionError("Could not find Send message button", e);
        }
    }
}
