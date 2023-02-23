package com.projectname.api.tests.data.provider;

import com.projectname.api.client.data.model.authors.create.CreateAuthorRequest;
import com.projectname.api.client.utils.RandomStringGenerator;
import com.projectname.api.tests.constants.DataProviderNames;
import org.testng.annotations.DataProvider;

public class AuthorProvider {

    public static CreateAuthorRequest prepareAuthorRequest() {
        CreateAuthorRequest createAuthorRequest = new CreateAuthorRequest();
        createAuthorRequest.setId(getRandomId());
        createAuthorRequest.setIdBook(getRandomId());
        createAuthorRequest.setFirstName(RandomStringGenerator.createRandomStringWithLen(5));
        createAuthorRequest.setLastName(RandomStringGenerator.createRandomStringWithLen(5));
        return createAuthorRequest;
    }

    public static Integer getRandomId() {
        return 5;
    }


    @DataProvider(name= DataProviderNames.VERIFY_CREATE_AUTHOR)
    public static Object[][] verifyCreateAuthor() {
        return new Object[][]{
                {"WithRandomNameAndLastName", prepareAuthorRequest(), getRandomId()},
                {"WithSetNameAndLastName", new CreateAuthorRequest(150, 150, "John", "Doe"),
                        getRandomId()}
        };
    }
}
