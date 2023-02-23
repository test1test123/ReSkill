package com.projectname.api.tests.functional.suites.users;

import com.projectname.api.client.calls.BookAPI;
import com.projectname.api.client.calls.UsersAPI;
import com.projectname.api.client.data.model.books.create.CreateBookRequest;
import com.projectname.api.client.data.model.books.create.CreateBookResponse;
import com.projectname.api.client.data.model.user.create.CreateUsersRequest;
import com.projectname.api.client.data.model.user.create.CreateUsersResponse;
import com.projectname.api.client.data.model.user.update.UpdateUsersRequest;
import com.projectname.api.client.data.model.user.update.UpdateUsersResponse;
import com.projectname.api.tests.data.provider.UsersProvider;
import com.projectname.api.tests.functional.asserts.UsersAssert;
import com.projectname.api.tests.init.TestBase;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static com.projectname.api.client.utils.Allure.logStep;

public class FunctionalUsersTests extends TestBase {

    UsersAssert usersAssert = new UsersAssert();

    @Test()
    @Description("Verify create user")
    public void verifyUserCreated(){
        logStep("INFO: Prepare user request");
        CreateUsersRequest createUsersRequest = UsersProvider.prepareUsersRequest();
        CreateUsersResponse actualUsersResponse = UsersAPI.createUser(createUsersRequest);
        logStep("PASS: Request is processed");

        logStep("INFO: Prepare expected result");
        CreateUsersResponse expectedUserResponse = CreateUsersResponse.parseCreatedUser(createUsersRequest);
        logStep("PASS: Request is processed");

        logStep("INFO:Verify actual and expected");
        usersAssert.assertUsersData(actualUsersResponse, expectedUserResponse);
        logStep("PASS: Request is processed");
    }

    @Test()
    @Description("Verify get user")
    public void verifyGetUser(){
        logStep("INFO: Prepare user request");
        CreateUsersRequest createUsersRequest = UsersProvider.prepareUsersRequest();
        CreateUsersResponse createUsersResponse = UsersAPI.createUser(createUsersRequest);
        logStep("PASS: Request is processed");

        logStep("INFO:Get user by Id");
        Integer userId = createUsersResponse.getId();
        CreateUsersResponse actualUserResponse = UsersAPI.getUser(userId);
        logStep("PASS: Request is processed");

        logStep("INFO: Prepare expected result");
        CreateUsersResponse expectedUserResponse = CreateUsersResponse.parseCreatedUser(createUsersRequest);
        logStep("PASS: Request is processed");

        logStep("INFO:Verify actual and expected");
        usersAssert.assertUsersData(actualUserResponse, expectedUserResponse);
        logStep("PASS: Request is processed");
    }

    @Test()
    @Description("Verify getting all users")
    public void verifyGettingAllUsers(){
        CreateUsersResponse[] getAllUsers = UsersAPI.getAllUsers();
        usersAssert.assertAllUsers(getAllUsers);
    }

    @Test()
    @Description("Verify deleting user")
    public void verifyDeleteUser(){
        logStep("INFO: Prepare user request");
        CreateUsersRequest createUsersRequest = UsersProvider.prepareUsersRequest();
        CreateUsersResponse createUsersResponse = UsersAPI.createUser(createUsersRequest);
        logStep("PASS: Request is processed");

        logStep("INFO:Delete user by Id");
        Integer userId = createUsersResponse.getId();
        CreateUsersResponse actualUserResponse = UsersAPI.deleteUser(userId);
        logStep("PASS: Request is processed");

        logStep("INFO:Verify user is deleted");
        CreateUsersResponse[] getAllUsers = UsersAPI.getAllUsers();
        for(int i=0; i<getAllUsers.length; i++){
            if(getAllUsers[i].getId()==userId){
                System.out.println("User with id " + userId + " is not deleted");
            }
        }
    }

    @Test()
    @Description("Verify updating user")
    public void verifyUpdateUser(){
        logStep("INFO: Prepare user request");
        CreateUsersRequest createUsersRequest = UsersProvider.prepareUsersRequest();
        CreateUsersResponse createUsersResponse = UsersAPI.createUser(createUsersRequest);
        Integer userId = createUsersResponse.getId();
        logStep("PASS: Request is processed");

        logStep("INFO: Prepare update request");
        UpdateUsersRequest updateUsersRequest = UsersProvider.prepareUpdateUser();
        UpdateUsersResponse actualUpdateResponse = UsersAPI.updateUser(updateUsersRequest,userId);
        logStep("PASS:request is processed");

        logStep("INFO: Prepare expected response");
        UpdateUsersResponse expectedUserResponse = UpdateUsersResponse.parseUpdatedUser(updateUsersRequest);
        logStep("PASS:Request is processed");

        logStep("INFO:Verify actual and expected");
        usersAssert.assertUpdateUser(actualUpdateResponse, expectedUserResponse);
        logStep("PASS: Request is processed");
    }


}
