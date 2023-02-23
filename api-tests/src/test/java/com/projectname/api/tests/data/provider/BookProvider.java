package com.projectname.api.tests.data.provider;

import com.projectname.api.client.data.model.books.create.CreateBookRequest;
import com.projectname.api.client.data.model.books.update.UpdateBookRequest;
import com.projectname.api.client.utils.RandomStringGenerator;

public class BookProvider {

    public static CreateBookRequest prepareBookRequest(){
        CreateBookRequest createBookRequest = new CreateBookRequest();
        createBookRequest.setId(getRandom());
        createBookRequest.setTitle(RandomStringGenerator.createRandomStringWithLen(10));
        createBookRequest.setDescription(RandomStringGenerator.createRandomStringWithLen(10));
        createBookRequest.setPageCount(getRandom());
        createBookRequest.setExcerpt(RandomStringGenerator.createRandomStringWithLen(50));
        createBookRequest.setPublishDate("2023-02-20T08:21:42.3515717+00:00");
        return createBookRequest;
    }

    public static UpdateBookRequest updateBookRequest(){
        UpdateBookRequest updateBookRequest = new UpdateBookRequest();
        updateBookRequest.setId(getRandom());
        updateBookRequest.setTitle(RandomStringGenerator.createRandomStringWithLen(10));
        updateBookRequest.setDescription(RandomStringGenerator.createRandomStringWithLen(10));
        updateBookRequest.setPageCount(getRandom());
        updateBookRequest.setExcerpt(RandomStringGenerator.createRandomStringWithLen(50));
        updateBookRequest.setPublishDate("2023-02-20T09:30:42.3515717+00:00");
        return updateBookRequest;
    }

    public static CreateBookRequest prepareBook(){
        CreateBookRequest createBookRequest = new CreateBookRequest();
        createBookRequest.setId(5);
        createBookRequest.setTitle(RandomStringGenerator.createRandomStringWithLen(10));
        createBookRequest.setDescription(RandomStringGenerator.createRandomStringWithLen(10));
        createBookRequest.setPageCount(getRandom());
        createBookRequest.setExcerpt(RandomStringGenerator.createRandomStringWithLen(50));
        createBookRequest.setPublishDate("2023-02-20T08:21:42.3515717+00:00");
        return createBookRequest;
    }


    public static Integer getRandom() {
        return 205;
    }
}
