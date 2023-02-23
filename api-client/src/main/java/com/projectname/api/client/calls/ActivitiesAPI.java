package com.projectname.api.client.calls;

import com.projectname.api.client.constants.ApiEndpoints;
import com.projectname.api.client.data.model.activities.create.CreateActivitiesRequest;
import com.projectname.api.client.data.model.activities.create.CreateActivitiesResponse;
import com.projectname.api.client.data.model.activities.update.UpdateActivityRequest;
import com.projectname.api.client.data.model.activities.update.UpdateActivityResponse;
import com.projectname.api.client.utils.GsonFunctions;
import com.projectname.api.client.utils.RestAssuredFunctions;

public class ActivitiesAPI {

    public static CreateActivitiesResponse createActivity(CreateActivitiesRequest createActivitiesRequest){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post(createActivitiesRequest, ApiEndpoints.ACTIVITIES), CreateActivitiesResponse.class);
    }

    public static CreateActivitiesResponse getActivity(Integer activityId){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.activities(String.valueOf(activityId))), CreateActivitiesResponse.class);
    }

    public static CreateActivitiesResponse[] getAllActivities(){
       return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.ACTIVITIES), CreateActivitiesResponse[].class);
    }

    public static CreateActivitiesResponse deleteActivity(Integer activityId){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.delete(ApiEndpoints.activities(String.valueOf(activityId))), CreateActivitiesResponse.class);
    }

    public static UpdateActivityResponse updateActivity(UpdateActivityRequest updateActivityRequest, Integer id){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.put(updateActivityRequest, ApiEndpoints.activities(String.valueOf(id))), UpdateActivityResponse.class);
    }
}
