package com.projectname.api.client.data.model.coverphotos.update;

import com.projectname.api.client.data.model.coverphotos.create.CreateCoverRequest;

import java.io.Serializable;

public class UpdateCoverRequest extends CreateCoverRequest implements Serializable {
    public UpdateCoverRequest(){super();}

    public UpdateCoverRequest(Integer id, Integer idBook, String url){
        super(id, idBook,url);
    }
}
