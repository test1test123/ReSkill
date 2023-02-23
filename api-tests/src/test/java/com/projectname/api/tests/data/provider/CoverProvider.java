package com.projectname.api.tests.data.provider;

import com.projectname.api.client.data.model.coverphotos.create.CreateCoverRequest;
import com.projectname.api.client.data.model.coverphotos.update.UpdateCoverRequest;
import com.projectname.api.client.utils.RandomStringGenerator;

public class CoverProvider {

    public static CreateCoverRequest prepareCoverRequest(){
        CreateCoverRequest createCoverRequest = new CreateCoverRequest();
        createCoverRequest.setId(getRandom());
        createCoverRequest.setIdBook(getRandom());
        createCoverRequest.setUrl(RandomStringGenerator.createRandomStringWithLen(5));
        return createCoverRequest;
    }

    public static UpdateCoverRequest prepareUpdateRequest(){
        UpdateCoverRequest updateCoverRequest = new UpdateCoverRequest();
        updateCoverRequest.setId(getRandom());
        updateCoverRequest.setIdBook(getRandom());
        updateCoverRequest.setUrl(RandomStringGenerator.createRandomStringWithLen(5));
        return updateCoverRequest;
    }

    public static Integer getRandom() {
        return 5;
    }
}
