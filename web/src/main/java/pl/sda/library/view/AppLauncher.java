package pl.sda.library.view;

import pl.sda.library.controler.*;
import pl.sda.library.entity.*;

import java.time.LocalDate;
import java.util.List;

public class AppLauncher extends Helper {


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
        //appLauncher.controlerCreateAuthor();
        //appLauncher.controlerCreateBook();
        //appLauncher.controlerCreateBorrower();
        //appLauncher.controlerBorrow();
        //appLauncher.controlerDeleteAuthor();
        //appLauncher.controlerReturnBook();
        appLauncher.controlerDeleteBook();
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
        bookController.showAllBooks("Lista książek do wypożyczenia");
        Book book = borrowController.getBook2Borrow("Wybierz kiążkę");
        Borrower borrower = borrowerController.getBorrower("Wybierz wyporzyczającego");
        borrowController.getBorrow(book, borrower);
    }

    void controlerDeleteAuthor() {
        Author author = authorController.getChoosenAuthor("Podaj autora którego chcesz usunąć:");
        authorController.removeAuthor(author);
    }

    void controlerDeleteBook() {
        Book book = bookController.getChoosenBook();
        bookController.remove(book);
    }
    void controlerDeleteBorrower() {

    }
    void controlerReturnBook() {
        //Borrower borrower =  borrowerController.getBorrower("Wybierz użytkownika");
        //List<Book> hasBook = borrowController.showBorrowedBookByUser(borrower);
        List<Borrow> borrowedBook = borrowController.showBorrowedBook();
        Integer choise = createInteger("Którą pozycje zrwracamy");
        borrowController.callGiveMeBack(borrowedBook.get(choise));
    }










}
