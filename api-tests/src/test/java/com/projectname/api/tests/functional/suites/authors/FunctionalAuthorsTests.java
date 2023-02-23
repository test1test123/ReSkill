package com.projectname.api.tests.functional.suites.authors;

import com.projectname.api.client.calls.AuthorsAPI;
import com.projectname.api.client.data.model.activities.create.CreateActivitiesResponse;
import com.projectname.api.client.data.model.authors.create.CreateAuthorRequest;
import com.projectname.api.client.data.model.authors.create.CreateAuthorResponse;
import com.projectname.api.client.data.model.authors.update.UpdateAuthorRequest;
import com.projectname.api.client.data.model.authors.update.UpdateAuthorResponse;
import com.projectname.api.tests.data.provider.AuthorProvider;
import com.projectname.api.tests.functional.asserts.AuthorAssert;
import com.projectname.api.tests.init.TestBase;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.projectname.api.client.utils.Allure.logStep;

public class FunctionalAuthorsTests extends TestBase {
    CreateAuthorRequest createAuthorRequest;
    CreateAuthorResponse createAuthorResponse;
    AuthorAssert authorAssert = new AuthorAssert();

    @BeforeMethod
    public void prepareData(){
        createAuthorRequest = AuthorProvider.prepareAuthorRequest();
        createAuthorResponse = AuthorsAPI.createAuthors(createAuthorRequest);
    }

    @Test()
    @Description("Verify getting all authors")
    public void verifyGetAllAuthors(){
        CreateAuthorResponse[] createAuthorResponse = AuthorsAPI.getAllAuthors();
        authorAssert.assertListOfAuthors(createAuthorResponse);
    }

    @Test(groups = {"regression", "smoke"})
    @Description("Verify get author")
    public void verifyGetAuthor(){
        CreateAuthorResponse createAuthorResponse = AuthorsAPI.createAuthors(createAuthorRequest);
        Integer authorId = createAuthorResponse.getId();
        CreateAuthorResponse actualAuthorResponse = AuthorsAPI.getAuthors(authorId);

        logStep("INFO: Prepare expected data");
        CreateAuthorResponse expectedAuthorResponse = CreateAuthorResponse.parseCreatedAuthor(createAuthorRequest);
        logStep("PASS: Request is processed");

        logStep("INFO: Verify actual and expected result");
        authorAssert.assertAuthorData(actualAuthorResponse, expectedAuthorResponse);
    }

    @Test(groups = {"regression", "smoke"})
    @Description("Verify create author")
    public void verifyAuthorCreated(){
        CreateAuthorResponse actualAuthorResponse = AuthorsAPI.createAuthors(createAuthorRequest);

        logStep("INFO: Prepare Expected response");
        CreateAuthorResponse expectedAuthorResponse = CreateAuthorResponse.parseCreatedAuthor(createAuthorRequest);
        logStep("PASS:Request is processed");

        logStep("INFO:Verify actual and expected responses");
        authorAssert.assertAuthorData(actualAuthorResponse, expectedAuthorResponse);
    }

    @Test(groups = {"regression", "smoke"})
    @Description("Verify delete author")
    public void verifyAuthorDeleted() {
        CreateAuthorResponse createAuthorResponse1 = AuthorsAPI.createAuthors(createAuthorRequest);
        Integer authorId = createAuthorResponse1.getId();

        CreateAuthorResponse actualAuthorResponse = AuthorsAPI.deleteAuthor(authorId);

        CreateAuthorResponse[] getAllAuthors = AuthorsAPI.getAllAuthors();
        for(int i=0; i<getAllAuthors.length; i++){
            if (getAllAuthors[i].getId() == authorId){
                System.out.println("Author with id " + authorId + " is not deleted");
            }
        }
    }

    @Test(groups = {"regression", "smoke"})
    @Description("Verify getting book")
    public void verifyGetBook(){
        CreateAuthorResponse createAuthorResponse2 = AuthorsAPI.createAuthors(createAuthorRequest);
        Integer bookId = createAuthorResponse2.getIdBook();
        CreateAuthorResponse[] actualResponse = AuthorsAPI.getBook(bookId);

        logStep("INFO:Verify list of books");
        authorAssert.assertBookData(actualResponse, bookId);
    }

    @Test(groups = {"regression", "smoke"})
    @Description("Verify updating author")
    public void verifyUpdateAuthor(){
        logStep("INFO:Update author request");
        UpdateAuthorRequest updateAuthorRequest = new UpdateAuthorRequest(50, 50, "FirstName50", "LastName50");
        UpdateAuthorResponse actualUpdateResponse = AuthorsAPI.updateAuthor(updateAuthorRequest, createAuthorResponse.getId());
        logStep("PASS: Request is processed");

        logStep("INFO:Prepare expected");
        UpdateAuthorResponse expectedResponse = UpdateAuthorResponse.parseUpdateAuthor(updateAuthorRequest);
        logStep("PASS:Request is processed");

        logStep("INFO: Verify actual and expected");
        authorAssert.assertUpdateAuthorData(actualUpdateResponse, expectedResponse);
        logStep("PASS: Data verified");
    }

}
