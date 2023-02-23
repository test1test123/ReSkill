package com.projectname.api.client.data.model.coverphotos.update;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UpdateCoverResponse implements Serializable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("idBook")
    @Expose
    private Integer idBook;
    @SerializedName("url")
    @Expose
    private String url;

    public UpdateCoverResponse(){

    }

    public UpdateCoverResponse(Integer id, Integer idBook, String url){
        super();
        this.id = id;
        this.idBook = idBook;
        this.url = url;
    }

    public static UpdateCoverResponse parseUpdateCover(UpdateCoverRequest updateCoverRequest){
        UpdateCoverResponse updateCoverResponse = new UpdateCoverResponse();
        updateCoverResponse.setId(updateCoverRequest.getId());
        updateCoverResponse.setIdBook(updateCoverRequest.getIdBook());
        updateCoverResponse.setUrl(updateCoverRequest.getUrl());
        return updateCoverResponse;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdBook() {
        return idBook;
    }

    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
