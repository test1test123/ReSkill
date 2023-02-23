package com.projectname.api.tests.functional.asserts;

import com.projectname.api.client.data.model.authors.create.CreateAuthorResponse;
import com.projectname.api.client.data.model.books.create.CreateBookResponse;
import com.projectname.api.client.data.model.books.update.UpdateBookResponse;
import org.testng.asserts.SoftAssert;

public class BookAssert {

    SoftAssert softAssert;

    public BookAssert() {
        this.softAssert = new SoftAssert();
    }

    public void assertBookData(CreateBookResponse actualBookResponse, CreateBookResponse expectedBookResponse){
        softAssert.assertEquals(actualBookResponse.getId(), expectedBookResponse.getId());
        softAssert.assertEquals(actualBookResponse.getTitle(), expectedBookResponse.getTitle());
        softAssert.assertEquals(actualBookResponse.getDescription(), expectedBookResponse.getDescription());
        softAssert.assertEquals(actualBookResponse.getPageCount(), expectedBookResponse.getPageCount());
        softAssert.assertEquals(actualBookResponse.getExcerpt(), expectedBookResponse.getExcerpt());
        softAssert.assertEquals(actualBookResponse.getPublishDate(), expectedBookResponse.getPublishDate());
        softAssert.assertAll();
    }

    public void assertUpdateBookData(UpdateBookResponse actualBookResponse, UpdateBookResponse expectedBookResponse){
        softAssert.assertEquals(actualBookResponse.getId(), expectedBookResponse.getId());
        softAssert.assertEquals(actualBookResponse.getTitle(), expectedBookResponse.getTitle());
        softAssert.assertEquals(actualBookResponse.getDescription(), expectedBookResponse.getDescription());
        softAssert.assertEquals(actualBookResponse.getPageCount(), expectedBookResponse.getPageCount());
        softAssert.assertEquals(actualBookResponse.getExcerpt(), expectedBookResponse.getExcerpt());
        softAssert.assertEquals(actualBookResponse.getPublishDate(), expectedBookResponse.getPublishDate());
        softAssert.assertAll();
    }

    public void assertAllBooks(CreateBookResponse[] createBookResponses){
        for(int i = 0; i < createBookResponses.length; i++) {
            softAssert.assertFalse(createBookResponses[i].getTitle().isEmpty(), "Title is not empty");
            softAssert.assertFalse(createBookResponses[i].getDescription().isEmpty(), "Description is not empty");
            softAssert.assertFalse(createBookResponses[i].getExcerpt().isEmpty(), "Excerpt is not empty");
            softAssert.assertFalse(createBookResponses[i].getPublishDate().isEmpty(), "Publish date is not empty");
            softAssert.assertFalse(createBookResponses[i].getId().toString().isEmpty(), "Id is not empty");
            softAssert.assertFalse(createBookResponses[i].getPageCount().toString().isEmpty(), "Page count is not empty");
        }
        softAssert.assertAll();
    }
}
