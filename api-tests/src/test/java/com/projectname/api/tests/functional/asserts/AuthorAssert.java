package com.projectname.api.tests.functional.asserts;

import com.projectname.api.client.data.model.authors.create.CreateAuthorResponse;
import com.projectname.api.client.data.model.authors.update.UpdateAuthorResponse;
import org.testng.asserts.SoftAssert;

public class AuthorAssert {
    private SoftAssert softAssert;

    public AuthorAssert()  {
        this.softAssert = new SoftAssert();
    }

    public void assertListOfAuthors(CreateAuthorResponse[] createAuthorResponse){
        for(int i = 0; i < createAuthorResponse.length; i++) {
            softAssert.assertFalse(createAuthorResponse[i].getFirstName().isEmpty(), "First name is not empty");
            softAssert.assertFalse(createAuthorResponse[i].getLastName().isEmpty(), "Last name is not empty");
        }
        softAssert.assertAll();
    }

    public void assertAuthorData(CreateAuthorResponse actualAuthorResponse, CreateAuthorResponse expectedAuthorResponse){
        softAssert.assertEquals(actualAuthorResponse.getId(), expectedAuthorResponse.getId());
        softAssert.assertEquals(actualAuthorResponse.getIdBook(), expectedAuthorResponse.getIdBook());
        softAssert.assertEquals(actualAuthorResponse.getFirstName(), expectedAuthorResponse.getFirstName());
        softAssert.assertEquals(actualAuthorResponse.getLastName(), expectedAuthorResponse.getLastName());
        softAssert.assertAll();
    }

    public void assertBookData(CreateAuthorResponse[] createAuthorResponse, Integer id){
        for(int i=0; i<createAuthorResponse.length; i++){
            softAssert.assertFalse(createAuthorResponse[i].getFirstName().isEmpty(), "First name is not empty");
            softAssert.assertFalse(createAuthorResponse[i].getLastName().isEmpty(), "Last name is not empty");
            softAssert.assertEquals(createAuthorResponse[i].getIdBook(), id);
        }
    }

    public void assertUpdateAuthorData(UpdateAuthorResponse actualUpdateResponse, UpdateAuthorResponse expectedUpdateResponse){
        softAssert.assertEquals(actualUpdateResponse.getId(), expectedUpdateResponse.getId());
        softAssert.assertEquals(actualUpdateResponse.getIdBook(), expectedUpdateResponse.getIdBook());
        softAssert.assertEquals(actualUpdateResponse.getFirstName(), expectedUpdateResponse.getFirstName());
        softAssert.assertEquals(actualUpdateResponse.getLastName(), expectedUpdateResponse.getLastName());
        softAssert.assertAll();
    }
}
