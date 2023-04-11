package com.projectname.e2e.tests.suites.abstracta;
import com.projectname.e2e.tests.pages.demo.ContactUsDetailsPage;
import com.projectname.e2e.tests.pages.demo.ContactUsPage;
import com.projectname.e2e.tests.pages.demo.NavBarPage;
import com.projectname.e2e.tests.suites.common.TestBase;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.projectname.api.client.utils.Allure.logStep;

public class ContactUsTest extends TestBase {

    @Test
    @Description("Verify sending message is successful.")
    public void verifySendingMessage(){
        logStep("INFO: Fetch Contact us screen");
        NavBarPage navBarPage = new NavBarPage(getDriver(), "", "","");
        navBarPage.openContactUsPage();
        logStep("PASS: Contact us page is opened.");

        ContactUsPage contactUsPage = new ContactUsPage(getDriver(), "", "","");
        contactUsPage.show();
        ContactUsDetailsPage contactUsDetailsPage = contactUsPage.contactUs("test", "test", "test.test1@q.com", "12345678", "Comment needs to have at least 15 characters.");

        logStep("INFO:Verify message is successfully sent");
        Assert.assertTrue(contactUsDetailsPage.isDisplayed(), "Thank you for contacting us page is not displayed.");
        logStep("PASS: Message is successfully sent.");
    }
}
