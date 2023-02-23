package com.projectname.api.client.data.model.authors.create;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CreateAuthorResponse implements Serializable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("idBook")
    @Expose
    private Integer idBook;
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("lastName")
    @Expose
    private String lastName;

    public CreateAuthorResponse(){

    }

    public CreateAuthorResponse(Integer id, Integer idBook, String firstName, String lastName){
        super();
        this.id=id;
        this.idBook=idBook;
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public static CreateAuthorResponse parseCreatedAuthor(CreateAuthorRequest createAuthorRequest){
        CreateAuthorResponse createAuthorResponse = new CreateAuthorResponse();
        createAuthorResponse.setId(createAuthorRequest.getId());
        createAuthorResponse.setIdBook(createAuthorRequest.getIdBook());
        createAuthorResponse.setFirstName(createAuthorRequest.getFirstName());
        createAuthorResponse.setLastName(createAuthorRequest.getLastName());
        return createAuthorResponse;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
