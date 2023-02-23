package com.projectname.api.client.data.model.user.create;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CreateUsersResponse implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("userName")
    @Expose
    private String userName;
    @SerializedName("password")
    @Expose
    private String password;

    public CreateUsersResponse(){

    }

    public CreateUsersResponse(Integer id, String userName, String password){
        super();
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public static CreateUsersResponse parseCreatedUser(CreateUsersRequest createUsersRequest){
        CreateUsersResponse createUsersResponse = new CreateUsersResponse();
        createUsersResponse.setId(createUsersRequest.getId());
        createUsersResponse.setUserName(createUsersRequest.getUserName());
        createUsersResponse.setPassword(createUsersRequest.getPassword());
        return createUsersResponse;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
