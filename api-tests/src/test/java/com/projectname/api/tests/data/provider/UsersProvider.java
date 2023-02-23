package com.projectname.api.tests.data.provider;

import com.projectname.api.client.data.model.user.create.CreateUsersRequest;
import com.projectname.api.client.data.model.user.update.UpdateUsersRequest;
import com.projectname.api.client.utils.RandomStringGenerator;

public class UsersProvider {

    public static CreateUsersRequest prepareUsersRequest(){
        CreateUsersRequest createUsersRequest = new CreateUsersRequest();
        createUsersRequest.setId(getRandom());
        createUsersRequest.setUserName(RandomStringGenerator.createRandomStringWithLen(6));
        createUsersRequest.setPassword(RandomStringGenerator.createRandomStringWithLen(10));
        return createUsersRequest;
    }

    public static UpdateUsersRequest prepareUpdateUser(){
        UpdateUsersRequest updateUsersRequest = new UpdateUsersRequest();
        updateUsersRequest.setId(getRandom());
        updateUsersRequest.setUserName(RandomStringGenerator.createRandomStringWithLen(10));
        updateUsersRequest.setPassword(RandomStringGenerator.createRandomStringWithLen(10));
        return updateUsersRequest;
    }

    public static Integer getRandom() {
        return 10;
    }
}
