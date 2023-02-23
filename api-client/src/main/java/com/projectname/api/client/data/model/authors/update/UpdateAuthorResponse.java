package com.projectname.api.client.data.model.authors.update;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.projectname.api.client.data.model.activities.update.UpdateActivityResponse;

import java.io.Serializable;

public class UpdateAuthorResponse implements Serializable {
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

    public UpdateAuthorResponse(){

    }

    public UpdateAuthorResponse(Integer id, Integer idBook, String firstName, String lastName){
        super();
        this.id = id;
        this.idBook = idBook;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static UpdateAuthorResponse parseUpdateAuthor(UpdateAuthorRequest updateAuthorRequest){
        UpdateAuthorResponse updateAuthorResponse = new UpdateAuthorResponse();
        updateAuthorResponse.setId(updateAuthorRequest.getId());
        updateAuthorResponse.setIdBook(updateAuthorRequest.getIdBook());
        updateAuthorResponse.setFirstName(updateAuthorRequest.getFirstName());
        updateAuthorResponse.setLastName(updateAuthorRequest.getLastName());
        return updateAuthorResponse;
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
