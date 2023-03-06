package com.projectname.api.tests.functional.suites;

import com.projectname.api.client.calls.CrocodilesAPI;
import com.projectname.api.client.data.model.crocodile.*;
import com.projectname.api.tests.constants.DataProviderNames;
import com.projectname.api.tests.constants.ErrorMessages;
import com.projectname.api.tests.data.provider.CrocodileProvider;
import com.projectname.api.tests.environment.ConfigSetup;
import com.projectname.api.tests.functional.asserts.CommonErrorAssert;
import com.projectname.api.tests.init.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CrocodileSecurityTests extends TestBase {
    String accessTokenMainUser;
    String accessTokenSecondUser;

    @BeforeClass
    public void prepareDataForTest() {
        accessTokenMainUser = CrocodilesAPI.loginUser(new LoginRequest(ConfigSetup.getMainUser(), ConfigSetup.getPass())).getAccess();

    }

    @Test
    public void verifyCannotGetCrocodileFromAnotherUser() {
        CrocodileResponse crocodileResponse = CrocodilesAPI.createCrocodile(accessTokenMainUser, CrocodileProvider.prepareCrocodileRequest());

        CrocodileErrorResponse actualError = CrocodilesAPI.getSingleCrocWithError(accessTokenSecondUser, crocodileResponse.getId());

        CommonErrorAssert commonErrorAssert = new CommonErrorAssert();
        commonErrorAssert.assertCrocodileErrorResponse(actualError, new CrocodileErrorResponse(ErrorMessages.NOT_FOUND));
    }

    @Test(dataProvider = DataProviderNames.VERIFY_CANNOT_CREATE_CROCODILE_WITHOUT_REQUIRED_FIELD, dataProviderClass = CrocodileProvider.class)
    public void verifyCannotCreateCrocodileWithoutRequiredFields(String suffix, CrocodileRequest crocodileRequest, RequiredFieldErrorResponse expectedError) {
        RequiredFieldErrorResponse actualError = CrocodilesAPI.createCrocodileWithRequiredFieldError(accessTokenMainUser, crocodileRequest);

        CommonErrorAssert commonErrorAssert = new CommonErrorAssert();
        commonErrorAssert.assertRequiredFieldErrors(actualError, expectedError);
    }


    @Test(dataProvider =DataProviderNames.VERIFY_CANNOT_CREATE_CROCODILE_WITH_EMPTY_FIELDS, dataProviderClass = CrocodileProvider.class)
    public void verifyCannotCreateCrocodileWithEmptyFields(String suffix, CrocodileRequest crocodileRequest, RequiredFieldErrorResponse expectedError){
        RequiredFieldErrorResponse actualErrorResponse = CrocodilesAPI.createCrocodileWithRequiredFieldError(accessTokenMainUser, crocodileRequest);

        CommonErrorAssert commonErrorAssert = new CommonErrorAssert();
        commonErrorAssert.assertRequiredFieldErrors(actualErrorResponse, expectedError);
    }

   }
