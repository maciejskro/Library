package pl.sda.library.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.sda.library.controler.*;
import pl.sda.library.entity.*;

import java.time.LocalDate;
import java.util.List;

public class AppLauncher extends Helper {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppLauncher.class);
    private final AuthorController authorController;
    private final BookController bookController;
    private final BorrowController borrowController;
    private final BorrowerController borrowerController;


    private AppLauncher() {
        this.authorController = new AuthorController();
        this.bookController = new BookController();
        this.borrowController = new BorrowController();
        this.borrowerController = new BorrowerController();
    }

    public static void main(String[] args) {
        AppLauncher appLauncher = new AppLauncher();
        String menuOption;
        boolean flags = true;
        do {
            appLauncher.showMenu();
            menuOption = createString("Wybierz z menu");

            switch ( menuOption)  {
                case "1" :
                    appLauncher.controlerCreateAuthor();
                    break;
                case "2":
                    appLauncher.controlerCreateBook();
                    break;
                case "3":
                    appLauncher.controlerCreateBorrower();
                    break;
                case "4":
                    appLauncher.controlerBorrow();
                    break;
                case "5":
                    appLauncher.controlerReturnBook();
                    break;
                case "6":
                    appLauncher.controlerDeleteAuthor();
                    break;
                case "7":
                    appLauncher.controlerDeleteBook();
                    break;
                case "8":
                    appLauncher.controlerDeleteBorrower();
                    break;
                default :
                    flags = false;

            }

        } while ( flags );

    }

    void showMenu() {
        System.out.println("Menu : \n"+
        "1 - dodaj autora książki \n"+
        "2 - dodaj nową książkę \n"+
        "3 - dodaj użytkownika \n" +
        "4 - wypożycz książke \n" +
        "5 - oddaj książkę \n"+
        "6 - usuń autora \n"+
        "7 - usuń książkę \n"+
        "8 - usuń użytkownika \n"+
        "X - wyjście z programu");
    }

    void controlerCreateAuthor() {
        String firstname = createString("Podaj imie autora:");
        String name = createString( "Podaj nazwisko autora:");
        String placeOfBorn = createString( "Podaj miejsce urodzenia autora:");

            authorController.createAuthor( firstname,  name, placeOfBorn);
    }
    void controlerCreateBook() {
        String title = createString( "Podaj tytuł ksążki");
        Author autorID = authorController.getChoosenAuthor(null);
        LocalDate dateOfPublishing  = createDate("Podaj date publikacji");
        String isbn = createString( "Podaj numer ISBN");
        BooksType booksType = bookController.getBooksType("Wybierz typ książki");
        Integer numberOfPages = createInteger( "Podaj ilość stron książki");
        String description = createString( "Podaj krótki opis książki");

         bookController.createBook(title,dateOfPublishing,isbn,booksType,numberOfPages,description,autorID);
    }
    void controlerCreateBorrower() {
        System.out.println(" Dane wyporzyczającego");
        String  firstname = createString("Podaj imię:");
        String name = createString("Podaj nazwisko:");
        String address = createString("Podaj adres zamieszkania");
        String phoneNumber = createString("Podaj numer telefonu");
        String email = createString("Podaj email do korespondenci");

        borrowerController.createBorrower(firstname,name,address,phoneNumber,email);
    }
    void controlerBorrow() {
        bookController.showAllBooksToBorrow("Lista książek do wypożyczenia");
        Book book = borrowController.getBook2Borrow("Wybierz kiążkę");
        Borrower borrower = borrowerController.getBorrower("Wybierz wyporzyczającego");
        borrowController.getBorrow(book, borrower);
    }

    void controlerDeleteAuthor() {
        Author author = authorController.getChoosenAuthor("Podaj autora którego chcesz usunąć:");
        authorController.removeAuthor(author);
    }

    void controlerDeleteBook() {
        Book book = bookController.getChoosenBook("Wybierz książkę z listy");
        bookController.remove(book);
    }
    void controlerDeleteBorrower() {
        System.out.println("to do :) ");
    }
    void controlerReturnBook() {
        //Borrower borrower =  borrowerController.getBorrower("Wybierz użytkownika");
        //List<Book> hasBook = borrowController.showBorrowedBookByUser(borrower);
        List<Borrow> borrowedBook = borrowController.showBorrowedBook();
        Integer choise = createInteger("Którą pozycje zrwracamy");
        borrowController.callGiveMeBack(borrowedBook.get(choise));
    }










}
