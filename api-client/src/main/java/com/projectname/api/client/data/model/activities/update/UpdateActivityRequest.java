package com.projectname.api.client.data.model.activities.update;

import com.projectname.api.client.data.model.activities.create.CreateActivitiesRequest;

import java.io.Serializable;

public class UpdateActivityRequest extends CreateActivitiesRequest implements Serializable {
    public UpdateActivityRequest() {
        super();
    }

    public UpdateActivityRequest(Integer id, String title, String dueDate, Boolean completed) {
        super(id, title, dueDate, completed);
    }
}
