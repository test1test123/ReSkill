package com.projectname.api.client.data.model.activities.update;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UpdateActivityResponse implements Serializable {
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

    public UpdateActivityResponse(){

    }

    public UpdateActivityResponse(Integer id, String title, String dueDate, Boolean completed){
        super();
        this.id=id;
        this.title=title;
        this.dueDate=dueDate;
        this.completed=completed;
    }

    public static UpdateActivityResponse parseUpdateActivity(UpdateActivityRequest updateActivityRequest){
        UpdateActivityResponse updateActivityResponse = new UpdateActivityResponse();
        updateActivityResponse.setId(updateActivityRequest.getId());
        updateActivityResponse.setTitle(updateActivityRequest.getTitle());
        updateActivityResponse.setDueDate(updateActivityRequest.getDueDate());
        updateActivityRequest.setCompleted(updateActivityRequest.getCompleted());
        return updateActivityResponse;
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
