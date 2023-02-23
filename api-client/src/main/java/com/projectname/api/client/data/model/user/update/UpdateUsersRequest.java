package com.projectname.api.client.data.model.user.update;

import com.projectname.api.client.data.model.user.create.CreateUsersRequest;

import java.io.Serializable;

public class UpdateUsersRequest extends CreateUsersRequest implements Serializable {

    public UpdateUsersRequest(){super();}

    public UpdateUsersRequest(Integer id, String userName, String password){
        super(id, userName, password);
    }
}
