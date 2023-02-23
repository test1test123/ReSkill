package com.projectname.api.tests.functional.suites.covers;

import com.projectname.api.client.calls.BookAPI;
import com.projectname.api.client.calls.CoverAPI;
import com.projectname.api.client.data.model.books.create.CreateBookResponse;
import com.projectname.api.client.data.model.coverphotos.create.CreateCoverRequest;
import com.projectname.api.client.data.model.coverphotos.create.CreateCoverResponse;
import com.projectname.api.client.data.model.coverphotos.update.UpdateCoverRequest;
import com.projectname.api.client.data.model.coverphotos.update.UpdateCoverResponse;
import com.projectname.api.tests.data.provider.CoverProvider;
import com.projectname.api.tests.functional.asserts.CoverAssert;
import com.projectname.api.tests.init.TestBase;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static com.projectname.api.client.utils.Allure.logStep;

public class FunctionalCoverTests extends TestBase {
    CoverAssert coverAssert = new CoverAssert();

    @Test()
    @Description("Verify get all covers")
    public void verifyGetAllCovers(){
        CreateCoverResponse[] getAll = CoverAPI.getAllCovers();
        coverAssert.assertAllCovers(getAll);
    }

    @Test()
    @Description("Verify create cover")
    public void verifyCoverCreated(){
        logStep("INFO: Create cover");
        CreateCoverRequest createCoverRequest = CoverProvider.prepareCoverRequest();
        CreateCoverResponse actualCoverResponse = CoverAPI.createCover(createCoverRequest);
        logStep("PASS: Cover created");

        logStep("INFO: Prepare expected");
        CreateCoverResponse expectedCoverResponse = CreateCoverResponse.parseCreatedCover(createCoverRequest);
        logStep("PASS: Expected response created");

        logStep("INFO: Verify actual and expected");
        coverAssert.assertCoverData(actualCoverResponse, expectedCoverResponse);
        logStep("PASS: Request is processed");
    }

    @Test()
    @Description("Verify get cover")
    public void verifyGetCover(){
        logStep("INFO: Create cover");
        CreateCoverRequest createCoverRequest = CoverProvider.prepareCoverRequest();
        CreateCoverResponse createCoverResponse = CoverAPI.createCover(createCoverRequest);
        Integer coverId = createCoverResponse.getId();
        logStep("PASS: Cover created");

        logStep("INFO:Actual cover response");
        CreateCoverResponse actualCoverResponse = CoverAPI.getCover(coverId);
        logStep("PASS: Request is processed");

        logStep("INFO: Prepare expected");
        CreateCoverResponse expectedCoverResponse = CreateCoverResponse.parseCreatedCover(createCoverRequest);
        logStep("PASS: Expected response created");

        logStep("INFO: Verify actual and expected");
        coverAssert.assertCoverData(actualCoverResponse, expectedCoverResponse);
        logStep("PASS: Request is processed");
    }

    @Test()
    @Description("Verify delete cover")
    public void verifyCoverDeleted(){
        logStep("INFO: Create cover");
        CreateCoverRequest createCoverRequest = CoverProvider.prepareCoverRequest();
        CreateCoverResponse createCoverResponse = CoverAPI.createCover(createCoverRequest);
        Integer coverId = createCoverResponse.getId();
        logStep("PASS: Cover created");

        logStep("INFO:Actual cover response");
        CreateCoverResponse actualCoverResponse = CoverAPI.deleteCover(coverId);

        logStep("INFO:Verify book is deleted");
        CreateCoverResponse[] getAllCovers = CoverAPI.getAllCovers();
        for(int i=0; i<getAllCovers.length; i++){
            if(getAllCovers[i].getId()==coverId){
                System.out.println("Cover with id " + coverId + " is not deleted");
            }
        }
    }
    @Test()
    @Description("Verify update cover")
    public void verifyCoverUpdated(){
        logStep("INFO: Create cover");
        CreateCoverRequest createCoverRequest = CoverProvider.prepareCoverRequest();
        CreateCoverResponse createCoverResponse = CoverAPI.createCover(createCoverRequest);
        Integer coverId = createCoverResponse.getId();
        logStep("PASS: Cover created");

        logStep("INFO: Update request");
        UpdateCoverRequest updateCoverRequest = CoverProvider.prepareUpdateRequest();
        UpdateCoverResponse actualCoverResponse = CoverAPI.updateCover(updateCoverRequest, coverId);
        logStep("PASS: Request is processed");

        logStep("INFO: Prepare expected response");
        UpdateCoverResponse expectedCoverResponse = UpdateCoverResponse.parseUpdateCover(updateCoverRequest);
        logStep("PASS: Expected response created");

        logStep("INFO: Verify actual and expected");
        coverAssert.assertUpdateCoverData(actualCoverResponse, expectedCoverResponse);
        logStep("PASS: Request is processed");
    }

}
