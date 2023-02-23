package com.projectname.api.client.data.model.user.update;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UpdateUsersResponse implements Serializable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("userName")
    @Expose
    private String userName;
    @SerializedName("password")
    @Expose
    private String password;

    public UpdateUsersResponse() {

    }

    public UpdateUsersResponse(Integer id, String userName, String password){
        super();
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public static UpdateUsersResponse parseUpdatedUser(UpdateUsersRequest updateUsersRequest){
        UpdateUsersResponse updateUsersResponse = new UpdateUsersResponse();
        updateUsersResponse.setId(updateUsersRequest.getId());
        updateUsersResponse.setUserName(updateUsersRequest.getUserName());
        updateUsersResponse.setPassword(updateUsersRequest.getPassword());
        return updateUsersResponse;
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
