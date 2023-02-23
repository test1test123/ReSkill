package com.projectname.api.client.constants;

//List of endpoint as constants
public class ApiEndpoints {

    public static final String USERS = "api/users";
    public static final String users(String userId) {
        return USERS + "/" + userId;
    }

    public static final String ACTIVITIES = "/api/v1/Activities";
    public static final String activities(String activityId) {return ACTIVITIES + "/" + activityId;}

    public static final String AUTHORS = "/api/v1/Authors";
    public static final String authors(String id){return AUTHORS + "/" + id;}

    public static final String books(String id){return AUTHORS + "/authors/books/" + id;}

    public static final String BOOKS = "/api/v1/Books";
    public static final String bookById(String id) {return BOOKS + "/" + id;}

    public static final String USER = "/api/v1/Users";
    public static final String userById(String userId) {return USER + "/" + userId;}
    public static final String COVER = "/api/v1/CoverPhotos";
    public static final String coverById(String id) {return COVER + "/" + id;}

}
