package com.projectname.api.tests.functional.asserts;

import com.projectname.api.client.data.model.activities.create.CreateActivitiesResponse;
import com.projectname.api.client.data.model.activities.update.UpdateActivityResponse;
import org.testng.asserts.SoftAssert;

public class ActivityAssert {
    private SoftAssert softAssert;

    public ActivityAssert()  {
        this.softAssert = new SoftAssert();
    }

    public void assertListOfActivities(CreateActivitiesResponse[] createActivitiesResponse){
        for(int i = 0; i < createActivitiesResponse.length; i++) {
            softAssert.assertFalse(createActivitiesResponse[i].getTitle().isEmpty() , "Title is not empty");
        }
        softAssert.assertAll();
    }

    public void assertActivityData(CreateActivitiesResponse actualActivityResponse, CreateActivitiesResponse expectedActivityResponse){
        softAssert.assertEquals(actualActivityResponse.getId(), expectedActivityResponse.getId());
        softAssert.assertEquals(actualActivityResponse.getTitle(), expectedActivityResponse.getTitle());
        softAssert.assertEquals(actualActivityResponse.getDueDate(), expectedActivityResponse.getDueDate());
        softAssert.assertEquals(actualActivityResponse.getCompleted(), expectedActivityResponse.getCompleted());
        softAssert.assertAll();
    }

    public void assertUpdateActivity(UpdateActivityResponse actualActivityResponse, UpdateActivityResponse expectedActivityResponse){
        softAssert.assertEquals(actualActivityResponse.getId(), expectedActivityResponse.getId());
        softAssert.assertEquals(actualActivityResponse.getTitle(), expectedActivityResponse.getTitle());
        softAssert.assertEquals(actualActivityResponse.getDueDate(), expectedActivityResponse.getDueDate());
        softAssert.assertEquals(actualActivityResponse.getCompleted(), expectedActivityResponse.getCompleted());
        softAssert.assertAll();
    }

}
