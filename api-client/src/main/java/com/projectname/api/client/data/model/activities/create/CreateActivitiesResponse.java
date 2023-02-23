package com.projectname.api.client.data.model.activities.create;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CreateActivitiesResponse implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("dueDate")
    @Expose
    private String dueDate;
    @SerializedName("completed")
    @Expose
    private Boolean completed;

    public CreateActivitiesResponse(){

    }

    public CreateActivitiesResponse(Integer id, String title, String dueDate, Boolean completed){
        super();
        this.id=id;
        this.title=title;
        this.dueDate=dueDate;
        this.completed=completed;
    }

    public static CreateActivitiesResponse parseCreatedActivity(CreateActivitiesRequest createActivitiesRequest){
        CreateActivitiesResponse createActivitiesResponse = new CreateActivitiesResponse();
        createActivitiesResponse.setId(createActivitiesRequest.getId());
        createActivitiesResponse.setTitle(createActivitiesRequest.getTitle());
        createActivitiesResponse.setDueDate(createActivitiesRequest.getDueDate());
        createActivitiesResponse.setCompleted(createActivitiesRequest.getCompleted());
        return createActivitiesResponse;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
