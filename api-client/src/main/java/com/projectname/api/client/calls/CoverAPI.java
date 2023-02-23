package com.projectname.api.client.calls;

import com.projectname.api.client.constants.ApiEndpoints;
import com.projectname.api.client.data.model.coverphotos.create.CreateCoverRequest;
import com.projectname.api.client.data.model.coverphotos.create.CreateCoverResponse;
import com.projectname.api.client.data.model.coverphotos.update.UpdateCoverRequest;
import com.projectname.api.client.data.model.coverphotos.update.UpdateCoverResponse;
import com.projectname.api.client.utils.GsonFunctions;
import com.projectname.api.client.utils.RestAssuredFunctions;

public class CoverAPI {

    public static CreateCoverResponse createCover(CreateCoverRequest createCoverRequest){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post(createCoverRequest, ApiEndpoints.COVER), CreateCoverResponse.class);
    }

    public static CreateCoverResponse getCover(Integer id){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.coverById(String.valueOf(id))), CreateCoverResponse.class);
    }

    public static CreateCoverResponse deleteCover(Integer id){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.delete(ApiEndpoints.coverById(String.valueOf(id))), CreateCoverResponse.class);
    }

    public static CreateCoverResponse[] getAllCovers(){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.COVER), CreateCoverResponse[].class);
    }

    public static UpdateCoverResponse updateCover(UpdateCoverRequest updateCoverRequest, Integer id){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.put(updateCoverRequest, ApiEndpoints.coverById(String.valueOf(id))), UpdateCoverResponse.class);
    }
}
