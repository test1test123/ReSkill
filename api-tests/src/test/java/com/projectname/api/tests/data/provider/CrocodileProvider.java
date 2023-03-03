package com.projectname.api.tests.data.provider;

import com.projectname.api.client.data.model.crocodile.CrocodileRequest;
import com.projectname.api.client.data.model.crocodile.RequiredFieldErrorResponse;
import com.projectname.api.client.utils.Dates;
import com.projectname.api.client.utils.RandomStringGenerator;
import com.projectname.api.tests.constants.DataProviderNames;
import com.projectname.api.tests.constants.ErrorMessages;
import org.testng.annotations.DataProvider;

import java.util.Arrays;

public class CrocodileProvider {

    @DataProvider(name = DataProviderNames.VERIFY_CANNOT_CREATE_USER_WITHOUT_REQUIRED_FIELD)
    public static Object[][] verifyCannotCreateUserWithoutRequiredField() {
        return new Object[][] {
                {"whenNameIsNull", new CrocodileRequest(null, RandomStringGenerator.getRandomSex(), Dates.getRandomDate()), RequiredFieldErrorResponse.prepareErrorForName(Arrays.asList(ErrorMessages.FIELD_IS_REQUIRED))},
                {"whenSexIsNull", new CrocodileRequest(RandomStringGenerator.createRandomStringWithLen(6), null, Dates.getRandomDate()), RequiredFieldErrorResponse.prepareErrorForSex(Arrays.asList(ErrorMessages.FIELD_IS_REQUIRED))},
                {"whenDateIsNull", new CrocodileRequest(RandomStringGenerator.createRandomStringWithLen(6), RandomStringGenerator.getRandomSex(), null), RequiredFieldErrorResponse.prepareErrorForDate(Arrays.asList(ErrorMessages.FIELD_IS_REQUIRED))}
        };
    }

    @DataProvider(name=DataProviderNames.VERIFY_CANNOT_CREATE_CROCODILE_WITH_EMPTY_FIELDS)
    public static Object[][] verifyCannotCreateCrocodileWithEmptyFields(){
        return new Object[][]{
                {"whenNameIsEmptyString", CrocodileProvider.prepareCrocodileRequestWithoutName(), RequiredFieldErrorResponse.prepareErrorForName(Arrays.asList(ErrorMessages.FILED_MAY_NOT_BE_BLANK))},
                {"whenSexIsEmptyString", CrocodileProvider.prepareCrocodileRequestWithoutSex(), RequiredFieldErrorResponse.prepareErrorForSex(Arrays.asList(ErrorMessages.NOT_A_VALID_CHOICE))},
                {"whenDateOfBirthIsEmptyString", CrocodileProvider.prepareCrocodileRequestWithoutBirthDate(), RequiredFieldErrorResponse.prepareErrorForDate(Arrays.asList(ErrorMessages.WRONG_DATE_FORMAT))}

        };
    }


    public static CrocodileRequest prepareCrocodileRequest() {
        CrocodileRequest createCrocodile = new CrocodileRequest(RandomStringGenerator.createRandomStringWithLen(6), RandomStringGenerator.getRandomSex(), Dates.getRandomDate());
        return createCrocodile;
    }

    public static CrocodileRequest prepareCrocodileRequestWithoutName(){
        CrocodileRequest createRequest = new CrocodileRequest("",RandomStringGenerator.getRandomSex(), Dates.getRandomDate());
        return createRequest;
    }

    public static CrocodileRequest prepareCrocodileRequestWithoutSex(){
        CrocodileRequest createRequest = new CrocodileRequest("Test","", Dates.getRandomDate());
        return createRequest;
    }

    public static CrocodileRequest prepareCrocodileRequestWithoutBirthDate(){
        CrocodileRequest createRequest = new CrocodileRequest("Test",RandomStringGenerator.getRandomSex(), "");
        return createRequest;
    }

    public static RequiredFieldErrorResponse prepareErrorMessageForSex() {
        RequiredFieldErrorResponse errorResponse = new RequiredFieldErrorResponse();
        errorResponse.setSex(Arrays.asList(ErrorMessages.FIELD_IS_REQUIRED));
        return errorResponse;
    }



}
