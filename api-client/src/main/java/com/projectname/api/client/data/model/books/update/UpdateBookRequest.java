package com.projectname.api.client.data.model.books.update;

import com.projectname.api.client.data.model.books.create.CreateBookRequest;

import java.io.Serializable;

public class UpdateBookRequest extends CreateBookRequest implements Serializable {
    public UpdateBookRequest(){super();}

    public UpdateBookRequest(Integer id, String title, String description, Integer pageCount, String excerpt, String publishDate){
        super(id, title, description, pageCount, excerpt, publishDate);
    }
}
