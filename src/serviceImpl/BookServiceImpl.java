package serviceImpl;

import dataBase.DataBase;
import models.Book;
import models.Library;
import service.BookService;

import java.util.ArrayList;

public class BookServiceImpl implements BookService {
    public Library serchLibrary(Long id){
        for (Library library: DataBase.libraries){
            if(library.getId().equals(id)){
                return library;
            }
        }return  null;
    }

    @Override
    public Book saveBook(Long libraryId, Book book) {
        Library foundLibrary = null;
        for (Library library : DataBase.libraries) {
            if (library.getId().equals(libraryId)) {
                foundLibrary = library;
                break;
            }
        }

        if (foundLibrary != null) {
            foundLibrary.getBooks().add(book);
            return book;
        } else {
            return null;
        }
    }


    @Override
    public ArrayList<Book> getAllBooks(Long libraryId) {
        Library library = serchLibrary(libraryId);
        return library.getBooks();
    }

    @Override
    public Book getBookById(Long libraryId, Long bookId) {
        Library library = serchLibrary(libraryId);
        for (Book book:library.getBooks()){
            if (book.getId()==bookId){
                return book;
            }
        }return null;

    }

    @Override
    public String deleteBook(Long libraryId, Long bookId) {
        Library library = serchLibrary(libraryId);
        for (Book book:library.getBooks()){
            if (book.getId()==bookId){
                library.getBooks().remove(book);
                return "Successfully deleted";
            }
        }
        return "Try again";
    }

    @Override
    public String clearBooksByLibraryId(Long libraryId) {
        Library library = serchLibrary(libraryId);
        library.getBooks().clear();
        return null;
    }
}
