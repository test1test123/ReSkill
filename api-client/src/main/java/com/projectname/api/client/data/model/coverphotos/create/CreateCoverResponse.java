package com.projectname.api.client.data.model.coverphotos.create;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CreateCoverResponse implements Serializable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("idBook")
    @Expose
    private Integer idBook;
    @SerializedName("url")
    @Expose
    private String url;

    public CreateCoverResponse(){

    }

    public CreateCoverResponse(Integer id, Integer idBook, String url){
        super();
        this.id = id;
        this.idBook = idBook;
        this.url = url;
    }

    public static CreateCoverResponse parseCreatedCover(CreateCoverRequest createCoverRequest){
        CreateCoverResponse createCoverResponse = new CreateCoverResponse();
        createCoverResponse.setId(createCoverRequest.getId());
        createCoverResponse.setIdBook(createCoverRequest.getIdBook());
        createCoverResponse.setUrl(createCoverRequest.getUrl());
        return createCoverResponse;
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
