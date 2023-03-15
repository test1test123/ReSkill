package com.projectname.e2e.tests.suites;

import com.projectname.e2e.tests.pages.*;
import com.projectname.e2e.tests.suites.common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTests extends TestBase {

    @Test
    public void verifyDemoPageIsDisplayed(){
        NavigationBarPage navigationBarPage = new NavigationBarPage(getDriver(), "", "","");
        DemoPage demoPage = navigationBarPage.openDemoPage();

        Assert.assertTrue(demoPage.isDisplayed());
    }

    @Test
    public void verifyPricingPageIsDisplayed(){
        NavigationBarPage navigationBarPage = new NavigationBarPage(getDriver(), "", "","");
        PricingPage pricingPage = navigationBarPage.openPricingPage();

        Assert.assertTrue(pricingPage.isDisplayed());
    }

    @Test
    public void verifyFeaturesPageIsDisplayed(){
        NavigationBarPage navigationBarPage = new NavigationBarPage(getDriver(), "", "","");
        FeaturesPage featuresPage = navigationBarPage.openFeaturesPage();

        Assert.assertTrue(featuresPage.isDisplayed());
    }

    @Test
    public void verifyIntegrationsPageIsDisplayed() {
        NavigationBarPage navigationBarPage = new NavigationBarPage(getDriver(), "", "","");
        IntegrationsPage integrationsPage = navigationBarPage.openIntegrationsPage();

        Assert.assertTrue(integrationsPage.isDisplayed());
    }

    @Test
    public void verifyCompanyPageIsDisplayed(){
        NavigationBarPage navigationBarPage = new NavigationBarPage(getDriver(), "", "","");
        CompanyPage comapnyPage = navigationBarPage.openCompanyPage();

        Assert.assertTrue(comapnyPage.isDisplayed());
    }

}
