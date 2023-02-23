package com.projectname.api.tests.functional.asserts;

import com.projectname.api.client.data.model.user.create.CreateUsersResponse;
import com.projectname.api.client.data.model.user.update.UpdateUsersResponse;
import org.testng.asserts.SoftAssert;

public class UsersAssert {
    SoftAssert softAssert;
    public UsersAssert(){this.softAssert = new SoftAssert();}

    public void assertUsersData (CreateUsersResponse actualUsersResponse, CreateUsersResponse expectedUsersResponse){
        softAssert.assertEquals(actualUsersResponse.getId(), expectedUsersResponse.getId());
        softAssert.assertEquals(actualUsersResponse.getUserName(), expectedUsersResponse.getUserName());
        softAssert.assertEquals(actualUsersResponse.getPassword(), expectedUsersResponse.getPassword());
        softAssert.assertAll();;
    }

    public void assertUpdateUser (UpdateUsersResponse actualUpdateUserResponse, UpdateUsersResponse expectedUpdateUsersResponse){
        softAssert.assertEquals(actualUpdateUserResponse.getId(), expectedUpdateUsersResponse.getId());
        softAssert.assertEquals(actualUpdateUserResponse.getUserName(), expectedUpdateUsersResponse.getUserName());
        softAssert.assertEquals(actualUpdateUserResponse.getPassword(), actualUpdateUserResponse.getPassword());
        softAssert.assertAll();
    }

    public void assertAllUsers (CreateUsersResponse[] createUsersResponses){
        for(int i = 0; i < createUsersResponses.length; i++) {
            softAssert.assertFalse(createUsersResponses[i].getId().toString().isEmpty(), "Id is not empty");
            softAssert.assertFalse(createUsersResponses[i].getUserName().isEmpty(), "UserName is not empty");
            softAssert.assertFalse(createUsersResponses[i].getPassword().isEmpty(), "Password is not empty");
        }
        softAssert.assertAll();
    }
}
