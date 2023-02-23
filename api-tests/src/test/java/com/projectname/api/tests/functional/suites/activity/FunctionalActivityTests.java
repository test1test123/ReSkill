package com.projectname.api.tests.functional.suites.activity;

import com.projectname.api.client.calls.ActivitiesAPI;
import com.projectname.api.client.data.model.activities.create.CreateActivitiesRequest;
import com.projectname.api.client.data.model.activities.create.CreateActivitiesResponse;
import com.projectname.api.client.data.model.activities.update.UpdateActivityRequest;
import com.projectname.api.client.data.model.activities.update.UpdateActivityResponse;
import com.projectname.api.tests.data.provider.ActivityProvider;
import com.projectname.api.tests.functional.asserts.ActivityAssert;
import com.projectname.api.tests.init.TestBase;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.projectname.api.client.utils.Allure.logStep;

public class FunctionalActivityTests extends TestBase {

    ActivityAssert activityAssert = new ActivityAssert();
    CreateActivitiesRequest createActivitiesRequest;
    CreateActivitiesResponse createActivitiesResponse;
    Integer activityId;

    @BeforeMethod
    public void prepareData(){
        createActivitiesRequest = ActivityProvider.prepareActivityRequest();
        createActivitiesResponse = ActivitiesAPI.createActivity(createActivitiesRequest);
        activityId = createActivitiesResponse.getId();
    }



    @Test(groups = {"regression", "smoke"})
    @Description("Verify getting all activities")
    public void verifyGetActivities(){
        CreateActivitiesResponse[] createActivitiesResponse = ActivitiesAPI.getAllActivities();
        activityAssert.assertListOfActivities(createActivitiesResponse);
    }
    @Test(groups = {"regression", "smoke"})
    @Description("Verify get activity")
    public void verifyGetActivity(){
        CreateActivitiesResponse createActivityResponse = ActivitiesAPI.createActivity(createActivitiesRequest);
        Integer id = createActivityResponse.getId();

        CreateActivitiesResponse actualActivityResponse = ActivitiesAPI.getActivity(id);

        logStep("INFO: Prepare expected response");
        CreateActivitiesResponse expectedActivityResponse = CreateActivitiesResponse.parseCreatedActivity(createActivitiesRequest);
        logStep("PASS: Expected response prepared");

        activityAssert.assertActivityData(actualActivityResponse, expectedActivityResponse);
    }

    @Test(groups = {"regression", "smoke"})
    @Description("Verify delete activity")
    public void verifyActivityIsDeleted(){
        CreateActivitiesResponse actualActivityResponse = ActivitiesAPI.deleteActivity(activityId);
        CreateActivitiesResponse[] getAll = ActivitiesAPI.getAllActivities();
        for(int i=0; i<getAll.length; i++){
            if(getAll[i].getId()==activityId){
                System.out.println("Activity with " + activityId + " is not deleted");
            }
        }

    }

    @Test(groups = {"regression", "smoke"})
    @Description("Verify update activity")
    public void verifyActivityIsUpdated(){
        logStep("INFO: Update activity");
        UpdateActivityRequest updateActivityRequest = new UpdateActivityRequest(10, "title 10", "2023-02-07T10:24:53.094Z", false);
        UpdateActivityResponse actualUpdateResponse = ActivitiesAPI.updateActivity(updateActivityRequest, activityId);
        logStep("PASS: Activity updated");

        logStep("INFO: Prepare expected");
        UpdateActivityResponse expectedActivityResponse = UpdateActivityResponse.parseUpdateActivity(updateActivityRequest);
        logStep("PASS: Request is processed");

        logStep("INFO: Verify activity is updated");
        activityAssert.assertUpdateActivity(actualUpdateResponse, expectedActivityResponse);

    }

    @Test(groups = {"regression", "smoke"})
    @Description("Verify create activity")
    public void verifyActivityCreated(){
        CreateActivitiesResponse actualActivityResponse = ActivitiesAPI.createActivity(createActivitiesRequest);

        logStep("INFO: Prepare expected");
        CreateActivitiesResponse expectedActivityResponse = CreateActivitiesResponse.parseCreatedActivity(createActivitiesRequest);
        logStep("PASS: Request is processed");

        logStep("INFO: Verify activity created");
        activityAssert.assertActivityData(actualActivityResponse, expectedActivityResponse);
        logStep("PASS: Activity is created");

    }
}
