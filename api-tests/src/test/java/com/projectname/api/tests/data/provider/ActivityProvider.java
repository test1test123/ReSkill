package com.projectname.api.tests.data.provider;

import com.projectname.api.client.data.model.activities.create.CreateActivitiesRequest;
import com.projectname.api.client.utils.RandomStringGenerator;

public class ActivityProvider {

    public static CreateActivitiesRequest prepareActivityRequest(){
        CreateActivitiesRequest createActivitiesRequest = new CreateActivitiesRequest();
        createActivitiesRequest.setId(getRandomId());
        createActivitiesRequest.setTitle(RandomStringGenerator.createRandomStringWithLen(5));
        createActivitiesRequest.setDueDate("2023-02-07T10:24:53.094Z");
        createActivitiesRequest.setCompleted(true);
        return createActivitiesRequest;
    }

    public static Integer getRandomId(){return 5;}
}
