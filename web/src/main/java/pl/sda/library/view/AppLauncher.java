package pl.sda.library.view;

import pl.sda.library.controler.AuthorController;
import pl.sda.library.controler.BookController;
import pl.sda.library.controler.BorrowController;
import pl.sda.library.controler.BorrowerController;
import pl.sda.library.entity.Author;
import pl.sda.library.entity.Book;
import pl.sda.library.entity.BooksType;
import pl.sda.library.entity.Borrower;
import sun.rmi.server.InactiveGroupException;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class AppLauncher {

    private  static final Scanner SCAN = new Scanner(System.in);
    private final AuthorController authorController;
    private final BookController bookController;
    private final BorrowController borrowController;
    private final BorrowerController borrowerController;

    public AppLauncher() {
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

    }

    public void controlerCreateAuthor() {
        String firstname = createString("Podaj imie autora:");
        String name = createString( "Podaj nazwisko autora:");
        String placeOfBorn = createString( "Podaj miejsce urodzenia autora:");

            authorController.createAuthor( firstname,  name, placeOfBorn);
    }
    public void controlerCreateBook() {
        String title = createString( "Podaj tytuł ksążki");
        LocalDate dateOfPublishing  = createDate("Podaj date publikacji");
        String isbn = createString( "Podaj numer ISBN");
        BooksType booksType = getBooksType("Wybierz typ książki");
        Integer numberOfPages = createInteger( "Podaj ilość stron książki");
        String description = createString( "Podaj krótki opis książki");
        Author autorID = getChoosenAuthor();

         bookController.createBook(title,dateOfPublishing,isbn,booksType,numberOfPages,description,autorID);
    }
    public void controlerCreateBorrower() {
        System.out.println(" Dane wyporzyczającego");
        String  firstname = createString("Podaj imię:");
        String name = createString("Podaj nazwisko:");
        String address = createString("Podaj adres zamieszkania");
        String phoneNumber = createString("Podaj numer telefonu");
        String email = createString("Podaj email do korespondenci");

        borrowerController.createBorrower(firstname,name,address,phoneNumber,email);
    }
    public void controlerCreateBorrow() {
        showAllBooks();
        Book book = getBook2Borrow();


    }


    public static String createString( String question) {
        System.out.println(question);
        String result = SCAN.nextLine();
        return result;
    }
    public static LocalDate createDate(String question) {
        System.out.println( question);
        String result = SCAN.nextLine();
        return LocalDate.parse(result);
    }
    public static Integer createInteger(String question) {
        System.out.println(question);
        String result = SCAN.nextLine();
        return  Integer.parseInt(result);
    }

    public List<Author> showAllAuthor() {
        List<Author> result = authorController.findListAuthor();
            for (int i = 0; i < result.size(); i++) {
                System.out.println( "" + i + " -> " + result.get(i).getFirstname() + " " +result.get(i).getName());
            }
        return  result;
    }
    private Author getChoosenAuthor() {
        List<Author> lista = showAllAuthor();
        Author result = null;
        Integer choise = createInteger("Wybierz autora");
        if ( choise >= 0 || choise <= lista.size()-1) {
            result = lista.get(choise);
        }
        return  result;
    }

    public void showAllBookType() {
        for (int i =0 ; i< BooksType.values().length; i ++) {
            System.out.println( "" + i + " ->" + BooksType.values()[i] + " (" + BooksType.values()[i].getDescription() +")");
        }
    }
    public BooksType getBooksType(String  question) {
        showAllBookType();
        System.out.println(question);
        Integer choice =Integer.parseInt( SCAN.nextLine() );
        BooksType result = null;
        if (choice >= 0 || choice <= BooksType.values().length-1) {
            result = BooksType.values()[choice];
        }
        return result;
    }

    public List<Borrower> showAllBorrowers() { ;
        List<Borrower>  listaBorrowersow = borrowerController.findAllBorrower();
        for ( int i =0 ; i< listaBorrowersow.size() ; i++) {
            System.out.println("" + i + " ->" + listaBorrowersow.get(i).getFullName());
        }
        return listaBorrowersow;
    }
    public Borrower getBorrower(String question) {
        List<Borrower> lista = showAllBorrowers();
        System.out.println("Wybierz wypożyczającego");
        Integer choise = Integer.parseInt( SCAN.nextLine());
        Borrower result = null;
        if (choise >=0 || choise <= lista.size()-1) {
            result = lista.get(choise);
        }
        return result;
    }

    public List<Book> showAllBooks() {
        List<Book> result = bookController.findAllBook();
        for(int i = 0; i < result.size(); i++) {
            System.out.println("" + i + " ->" + result.get(i).getTitle() + " ," + result.get(i).getAuthorName() );
        }
        return result;
    }
    public Book getBook2Borrow() {
        List<Book> bookList = bookController.findAllBook();
        Book result = null;
        Integer choise = createInteger("Wybierz książkę");
        if ( choise >=0 || choise <= bookList.size()-1) {
            result = bookList.get(choise);
        }
        return result;
    }

}
