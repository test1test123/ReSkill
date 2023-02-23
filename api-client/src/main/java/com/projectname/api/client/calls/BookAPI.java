package com.projectname.api.client.calls;

import com.projectname.api.client.constants.ApiEndpoints;
import com.projectname.api.client.data.model.books.create.CreateBookRequest;
import com.projectname.api.client.data.model.books.create.CreateBookResponse;
import com.projectname.api.client.data.model.books.update.UpdateBookRequest;
import com.projectname.api.client.data.model.books.update.UpdateBookResponse;
import com.projectname.api.client.utils.GsonFunctions;
import com.projectname.api.client.utils.RestAssuredFunctions;

public class BookAPI {

    public static CreateBookResponse createBook(CreateBookRequest createBookRequest){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post(createBookRequest, ApiEndpoints.BOOKS), CreateBookResponse.class);
    }

    public static CreateBookResponse getBook(Integer bookId){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.bookById(String.valueOf(bookId))), CreateBookResponse.class);
    }
    public static CreateBookResponse[] getAllBooks(){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.BOOKS), CreateBookResponse[].class);
    }

    public static CreateBookResponse deleteBook(Integer bookId){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.delete(ApiEndpoints.bookById(String.valueOf(bookId))), CreateBookResponse.class);
    }

    public static UpdateBookResponse updateBook(UpdateBookRequest updateBookRequest, Integer id){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.put(updateBookRequest, ApiEndpoints.bookById(String.valueOf(id))), UpdateBookResponse.class);
    }
}
