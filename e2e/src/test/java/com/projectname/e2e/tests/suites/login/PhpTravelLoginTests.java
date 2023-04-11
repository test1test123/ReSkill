package com.projectname.e2e.tests.suites.login;

import com.projectname.e2e.tests.environment.ConfigSetup;
import com.projectname.e2e.tests.pages.*;
import com.projectname.e2e.tests.suites.common.TestBase;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.projectname.api.client.utils.Allure.logStep;

public class PhpTravelLoginTests extends TestBase {

    @Test
    @Description("Verify user is sucessfully logged in.")
    public void verifyUserIsLoggedIn(){
        logStep("INFO: Fetch login screen");
        NavigationBarPage navigationBarPage = new NavigationBarPage(getDriver(), "", "","");
        navigationBarPage.openLoginPage();

        PhpLoginPage loginPage = new PhpLoginPage(getDriver(), "", ConfigSetup.getAdminUser(), ConfigSetup.getAdminPsw());
        loginPage.show();
        logStep("PASS: Login screen is fetched");

        LoginDetailsPage loginDetailsPage = loginPage.login(ConfigSetup.getAdminUser(), ConfigSetup.getAdminPsw());

        logStep("INFO: Verify Login page is shown");
        Assert.assertTrue(loginDetailsPage.isDisplayed(), "Login details page is not fetched");
        logStep("PASS: Login details page is fetched -  Login is verified");

    }
}
