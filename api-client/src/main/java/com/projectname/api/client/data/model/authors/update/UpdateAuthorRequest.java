package com.projectname.api.client.data.model.authors.update;

import com.projectname.api.client.data.model.authors.create.CreateAuthorRequest;

import java.io.Serializable;

public class UpdateAuthorRequest extends CreateAuthorRequest implements Serializable {
    public UpdateAuthorRequest() {super();}

    public UpdateAuthorRequest(Integer id, Integer bookId, String firstName, String lastName){
        super(id, bookId, firstName, lastName);
    }
}
