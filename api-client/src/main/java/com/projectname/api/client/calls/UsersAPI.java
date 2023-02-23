package com.projectname.api.client.calls;

import com.projectname.api.client.constants.ApiEndpoints;
import com.projectname.api.client.data.model.books.create.CreateBookResponse;
import com.projectname.api.client.data.model.user.create.CreateUsersRequest;
import com.projectname.api.client.data.model.user.create.CreateUsersResponse;
import com.projectname.api.client.data.model.user.update.UpdateUsersRequest;
import com.projectname.api.client.data.model.user.update.UpdateUsersResponse;
import com.projectname.api.client.utils.GsonFunctions;
import com.projectname.api.client.utils.RestAssuredFunctions;

public class UsersAPI {

    public static CreateUsersResponse createUser(CreateUsersRequest createUsersRequest){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post(createUsersRequest, ApiEndpoints.USER), CreateUsersResponse.class);
    }

    public static CreateUsersResponse getUser(Integer id){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.userById(String.valueOf(id))), CreateUsersResponse.class);
    }

    public static CreateUsersResponse[] getAllUsers(){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.USER), CreateUsersResponse[].class);
    }

    public static CreateUsersResponse deleteUser(Integer id){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.delete(ApiEndpoints.userById(String.valueOf(id))), CreateUsersResponse.class);
    }

    public static UpdateUsersResponse updateUser(UpdateUsersRequest updateUsersRequest, Integer id){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.put(updateUsersRequest, ApiEndpoints.userById(String.valueOf(id))), UpdateUsersResponse.class);
    }
}
