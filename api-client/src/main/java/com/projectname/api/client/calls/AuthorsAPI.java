package com.projectname.api.client.calls;
import com.projectname.api.client.constants.ApiEndpoints;
import com.projectname.api.client.data.model.authors.create.CreateAuthorRequest;
import com.projectname.api.client.data.model.authors.create.CreateAuthorResponse;
import com.projectname.api.client.data.model.authors.update.UpdateAuthorRequest;
import com.projectname.api.client.data.model.authors.update.UpdateAuthorResponse;
import com.projectname.api.client.utils.GsonFunctions;
import com.projectname.api.client.utils.RestAssuredFunctions;

public class AuthorsAPI {

    public static CreateAuthorResponse createAuthors (CreateAuthorRequest createAuthorRequest){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post(createAuthorRequest, ApiEndpoints.AUTHORS), CreateAuthorResponse.class);
    }

    public static CreateAuthorResponse getAuthors(Integer id){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.authors(String.valueOf(id))), CreateAuthorResponse.class);
    }

    public static CreateAuthorResponse[] getAllAuthors() {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.AUTHORS), CreateAuthorResponse[].class);
    }

    public static CreateAuthorResponse[] getBook(Integer id){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.books(String.valueOf(id))), CreateAuthorResponse[].class);
    }

    public static UpdateAuthorResponse updateAuthor(UpdateAuthorRequest updateAuthorRequest, Integer id){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.put(updateAuthorRequest, ApiEndpoints.authors(String.valueOf(id))), UpdateAuthorResponse.class);
    }

    public static CreateAuthorResponse deleteAuthor(Integer id){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.delete(ApiEndpoints.authors(String.valueOf(id))), CreateAuthorResponse.class);
    }
}
