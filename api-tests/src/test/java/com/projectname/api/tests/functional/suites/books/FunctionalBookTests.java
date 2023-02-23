package com.projectname.api.tests.functional.suites.books;

import com.projectname.api.client.calls.BookAPI;
import com.projectname.api.client.data.model.books.create.CreateBookRequest;
import com.projectname.api.client.data.model.books.create.CreateBookResponse;
import com.projectname.api.client.data.model.books.update.UpdateBookRequest;
import com.projectname.api.client.data.model.books.update.UpdateBookResponse;
import com.projectname.api.tests.data.provider.BookProvider;
import com.projectname.api.tests.functional.asserts.BookAssert;
import com.projectname.api.tests.init.TestBase;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static com.projectname.api.client.utils.Allure.logStep;

public class FunctionalBookTests extends TestBase {

    BookAssert bookAssert = new BookAssert();


    @Test()
    @Description("Verify create book")
    public void verifyBookCreated(){
        logStep("INFO: Prepare book request");
        CreateBookRequest createBookRequest = BookProvider.prepareBookRequest();
        CreateBookResponse actualBookResponse = BookAPI.createBook(createBookRequest);
        logStep("PASS:Request is processed");

        logStep("INFO:Prepare expected");
        CreateBookResponse expectedBookResponse = CreateBookResponse.parseCreatedBook(createBookRequest);
        logStep("PASS:Request is processed");

        logStep("INFO: Verify actual and expected data");
        bookAssert.assertBookData(actualBookResponse, expectedBookResponse);
        logStep("PASS:Request is processed");
    }

    @Test()
    @Description("Verify get book")
    public void verifyGettingBookById(){
        logStep("INFO: Create book request");
        CreateBookRequest createBookRequest = BookProvider.prepareBook();
        CreateBookResponse createBookResponse = BookAPI.createBook(createBookRequest);
        Integer bookId = createBookResponse.getId();
        CreateBookResponse actualBookResponse = BookAPI.getBook(bookId);

        logStep("INFO: Prepare expected data");
        CreateBookResponse expectedBookResponse = CreateBookResponse.parseCreatedBook(createBookRequest);
        logStep("PASS: Request is processed");

        logStep("INFO:Verify actual and expected");
        bookAssert.assertBookData(actualBookResponse, expectedBookResponse);
        logStep("PASS: Request is processed");
    }

    @Test()
    @Description("Verify book is deleted")
    public void verifyBookDeleted(){
        logStep("INFO: Create book request");
        CreateBookRequest createBookRequest = BookProvider.prepareBook();
        CreateBookResponse createBookResponse = BookAPI.createBook(createBookRequest);
        Integer bookId = createBookResponse.getId();
        CreateBookResponse actualResponse = BookAPI.deleteBook(bookId);

        logStep("INFO:Verify book is deleted");
        CreateBookResponse[] getAllBooks = BookAPI.getAllBooks();
        for(int i=0; i<getAllBooks.length; i++){
            if(getAllBooks[i].getId()==bookId){
                System.out.println("Book with id " + bookId + " is not deleted");
            }
        }
    }

    @Test()
    @Description("Verify book is updated")
    public void verifyBookUpdated(){
        logStep("INFO: Create book request");
        CreateBookRequest createBookRequest = BookProvider.prepareBook();
        CreateBookResponse createBookResponse = BookAPI.createBook(createBookRequest);
        Integer bookId = createBookResponse.getId();
        logStep("PASS: Request is processed");

        logStep("INFO:Prepare update request");
        UpdateBookRequest updateBookRequest = BookProvider.updateBookRequest();
        UpdateBookResponse actualUpdateBookResponse = BookAPI.updateBook(updateBookRequest,bookId);
        logStep("PASS:Request is processed");

        logStep("INFO:Prepare expected");
        UpdateBookResponse expectedBookResponse = UpdateBookResponse.parseUpdatedBook(updateBookRequest);
        logStep("PASS: request is processed");

        logStep("INFO:Verify actual and expected data");
        bookAssert.assertUpdateBookData(actualUpdateBookResponse,expectedBookResponse);
        logStep("PASS: Request is processed");
    }

    @Test()
    @Description("Verify getting all books")
    public void getAllBooks(){
        CreateBookResponse[] getAll = BookAPI.getAllBooks();
        bookAssert.assertAllBooks(getAll);
    }
}
