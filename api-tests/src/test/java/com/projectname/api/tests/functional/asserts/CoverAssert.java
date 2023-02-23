package com.projectname.api.tests.functional.asserts;

import com.projectname.api.client.data.model.books.create.CreateBookResponse;
import com.projectname.api.client.data.model.books.update.UpdateBookResponse;
import com.projectname.api.client.data.model.coverphotos.create.CreateCoverRequest;
import com.projectname.api.client.data.model.coverphotos.create.CreateCoverResponse;
import com.projectname.api.client.data.model.coverphotos.update.UpdateCoverResponse;
import org.testng.asserts.SoftAssert;

public class CoverAssert {

    SoftAssert softAssert;

    public CoverAssert() {
        this.softAssert = new SoftAssert();
    }

    public void assertCoverData(CreateCoverResponse actualCoverResponse, CreateCoverResponse expectedCoverResponse){
        softAssert.assertEquals(actualCoverResponse.getId(), expectedCoverResponse.getId());
        softAssert.assertEquals(actualCoverResponse.getIdBook(), expectedCoverResponse.getIdBook());
        softAssert.assertEquals(actualCoverResponse.getUrl(), expectedCoverResponse.getUrl());
        softAssert.assertAll();
    }

    public void assertUpdateCoverData(UpdateCoverResponse actualCoverResponse, UpdateCoverResponse expectedCoverResponse){
        softAssert.assertEquals(actualCoverResponse.getId(), expectedCoverResponse.getId());
        softAssert.assertEquals(actualCoverResponse.getIdBook(), expectedCoverResponse.getIdBook());
        softAssert.assertEquals(actualCoverResponse.getUrl(), expectedCoverResponse.getUrl());
        softAssert.assertAll();
    }

    public void assertAllCovers(CreateCoverResponse[] createCoverResponses){
        for(int i = 0; i < createCoverResponses.length; i++) {
            softAssert.assertFalse(createCoverResponses[i].getId().toString().isEmpty(), "Id is not empty");
            softAssert.assertFalse(createCoverResponses[i].getIdBook().toString().isEmpty(), "Book id is not empty");
            softAssert.assertFalse(createCoverResponses[i].getUrl().isEmpty(), "Url is not empty");
        }
        softAssert.assertAll();
    }
}
