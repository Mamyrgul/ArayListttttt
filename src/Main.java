import dataBase.DataBase;
import enums.Gender;
import enums.Genre;
import models.Book;
import models.Library;
import models.Reader;
import service.BookService;
import service.LibraryService;
import service.ReaderService;
import serviceImpl.BookServiceImpl;
import serviceImpl.LibraryServiceImpl;
import serviceImpl.ReaderServiceImpl;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
 /* Models
    Library(id, name, address, List<Book>books, List<Reader>readers)
     Book(id, name, author, Genre genre)
    Reader(id, fullName, email, phoneNumber, Gender gender)
    Database(List<Library>libraries, List<Book>books,List<Reader>readers)

     2. Service
            LibraryService
    List<Library>saveLibrary(List<Library> libraries);
    List<Library>getAllLibraries();
    Library getLibraryById(Long id);
    Library updateLibrary(Long id, Library library);
    String deleteLibrary(Long id);

    BookService
    Book saveBook(Long libraryId,Book book);
    List<Book>getAllBooks(Long libraryId);
    Book getBookById(Long libraryId, Long bookId);
    String deleteBook(Long libraryId,Long bookId);
    void clearBooksByLibraryId(Long libraryId);

    ReaderService
    void saveReader(Reader reader);
    List<Reader> getAllReaders();
    Reader getReaderById(Long id);
    Reader updateReader(Long id, Reader reader);
    void assignReaderToLibrary(Long readerId,Long libraryId);

    Бардык методдор Main класска чакырылып, switch case аркылуу ирээттуу турдо консольго чыксын*/

        BookService bookService = new BookServiceImpl();
        LibraryService libraryService = new LibraryServiceImpl();
        ReaderService readerService = new ReaderServiceImpl();

        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("\nMenu:");
            System.out.println("1. Create library");
            System.out.println("2. Create book");
            System.out.println("3. Create reader");
            System.out.println("4. Get all libraries");
            System.out.println("5. Get library by ID");
            System.out.println("6. Get all books by library ID");
            System.out.println("7. Get book by ID");
            System.out.println("8. Delete book");
            System.out.println("9. Clear books in library");
            System.out.println("10. Get all readers");
            System.out.println("11. Assign reader to library");
            System.out.println("12. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("ID: ");
                    Long id = scanner.nextLong();
                    scanner.nextLine();

                    System.out.println("Name library: ");
                    String name = scanner.nextLine();

                    System.out.println("Address library: ");
                    String address= scanner.nextLine();
                    Library library = new Library(id,name,address,new ArrayList<>(),new ArrayList<>());
                    DataBase.libraries.add(library);
                    System.out.println("Successfully added"+library);
                }break;
                case 2:{
                    System.out.println("Library id: ");
                    Long idLy= scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("ID: ");
                    Long id= scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Name: ");
                    String name = scanner.nextLine();
                    System.out.println("Author name: ");
                    String authorName= scanner.nextLine();
                    System.out.println(" Genre {\n" +
                            "    POEM,\n" +
                            "    HORROR,\n" +
                            "    FANTASY,\n" +
                            "    MYSTERY\n" );
                    String genre= scanner.next();
                    Genre genre1= Genre.valueOf(genre);
                    Book book = new Book(id,name,authorName,genre1);
                    System.out.println(bookService.saveBook(idLy, book));

                }
                break;
                case 3:{
                    System.out.println("ID: ");
                    Long id = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Full name actor: ");
                    String fullName= scanner.nextLine();
                    System.out.println("Email: ");
                    String email = scanner.nextLine();
                    System.out.println("Phone number: ");
                    String phoneNum = scanner.nextLine();
                    System.out.println("MALE,\n" +
                            "    FEMALE");
                    String gender = scanner.next();
                    Gender gender1 = Gender.valueOf(gender);
                    Reader reader = new Reader(id,fullName,email,phoneNum,gender1);
                    System.out.println(DataBase.readers.add(reader));
                }
                break;
                case 4:{
                    ArrayList<Library> libraries = libraryService.getAllLibraries();
                    System.out.println("All libraries "+libraries);
                }
                break;
                case 5:{
                    System.out.println("Which library: ");
                    Long id = scanner.nextLong();
                    scanner.nextLine();
                    Library library = libraryService.getLibraryById(id);
                    System.out.println(library);
                }
                break;
                case 6:{
                    System.out.println("ID library: ");
                    Long id= scanner.nextLong();
                    scanner.nextLine();
                    ArrayList<Book> books = bookService.getAllBooks(id);
                    System.out.println(books);
                }
                break;
                case 7:{
                    System.out.println("ID library: ");
                    Long id= scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Id book: ");
                    Long idB= scanner.nextLong();
                    Book book = bookService.getBookById(id,idB);
                    System.out.println(book);
                }
                break;
                case 8:{
                    System.out.println("ID library: ");
                    Long id= scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Id book: ");
                    Long idB= scanner.nextLong();
                    String book = bookService.deleteBook(id,idB);
                    System.out.println(book);
                }
                break;
                case 9:{
                    System.out.println("ID library: ");
                    Long id= scanner.nextLong();
                    scanner.nextLine();
                    String book = bookService.clearBooksByLibraryId(id);
                    System.out.println(book);
                }
                break;
                case 10:{
                    ArrayList<Reader> readers = readerService.getAllReaders();
                    System.out.println(readers);
                }
                break;
                case 11:{
                    System.out.println("Reader id: ");
                    Long id = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("ID library: ");
                    Long id1 = scanner.nextLong();
                    scanner.nextLine();
                    Reader reader = readerService.assignReaderToLibrary(id,id1);
                    System.out.println(reader);
                }
                break;
                case 12:{
                    System.out.println("Stop");
                    return;
                }

                default:{
                    System.out.println("Try again");
                }
                break;
            }
        }
    }
}