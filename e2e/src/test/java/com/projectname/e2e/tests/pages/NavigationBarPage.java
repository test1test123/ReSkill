package com.projectname.e2e.tests.pages;

import com.projectname.e2e.tests.pages.common.PageBase;
import com.projectname.e2e.tests.selectors.CustomBy;
import com.projectname.e2e.tests.utils.CheckIfElement;
import com.projectname.e2e.tests.webdriver.CustomWebDriver;
import org.openqa.selenium.WebElement;

public class NavigationBarPage extends PageBase {
    public NavigationBarPage(CustomWebDriver driver, String url, String email, String password) {
        super(driver, url, email, password);
    }

    @Override
    public PageBase show() {
        return null;
    }

    @Override
    public boolean isDisplayed() {
        return CheckIfElement.isDisplayed(CustomBy.xpath("/html/body/div[2]/div/div[1]/a/div"), driver);
    }

    private WebElement getDemoBtn(){
        try {
            return driver.findElement(CustomBy.xpath("/html/body/div[2]/div/div[3]/ul/li[1]"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find demo button", e);
        }
    }

    public DemoPage openDemoPage(){
        getDemoBtn().click();
        return new DemoPage(driver, url, email, password);
    }

    private WebElement getPricingBtn(){
        try{
            return driver.findElement(CustomBy.xpath("/html/body/div[2]/div/div[3]/ul/li[2]/a"));
        } catch (Exception e) {
            throw new AssertionError("Could not find Pricing button", e);
        }
    }

    public PricingPage openPricingPage(){
        getPricingBtn().click();
        return new PricingPage(driver, url, email, password);
    }

    private WebElement getFeaturesBtn(){
        try{
            return driver.findElement(CustomBy.xpath("/html/body/div[2]/div/div[3]/ul/li[3]/a"));
        } catch (Exception e) {
            throw new AssertionError("Could not find Features button", e);
        }
    }

    public FeaturesPage openFeaturesPage(){
        getFeaturesBtn().click();
        return new FeaturesPage(driver,url, email, password);
    }

    private WebElement getIntegrationsBtn(){
        try{
            return driver.findElement(CustomBy.xpath("/html/body/div[2]/div/div[3]/ul/li[4]/a"));
        } catch(Exception e) {
            throw new AssertionError("Could not find Integrations button", e);
        }
    }

    public IntegrationsPage openIntegrationsPage(){
        getIntegrationsBtn().click();
        return new IntegrationsPage(driver,url, email, password);
    }

    private WebElement getCompanyButton(){
        try {
            return driver.findElement(CustomBy.xpath("/html/body/div[2]/div/div[3]/ul/li[5]/a"));
        } catch (Exception e){
            throw new AssertionError("Could not find Company button", e);
        }
    }

    public CompanyPage openCompanyPage() {
        getCompanyButton().click();
        return new CompanyPage(driver,url, email, password);
    }

    private WebElement getLoginButton(){
        try {
            return driver.findElement(CustomBy.xpath("//*[@id=\"loginSignup\"]/li[1]/a"));
        } catch (Exception e){
            throw new AssertionError("Could not find Login button", e);
        }
    }

    public PhpLoginPage openLoginPage(){
        getLoginButton().click();
        return new PhpLoginPage(driver, url, email,password);
    }
}
