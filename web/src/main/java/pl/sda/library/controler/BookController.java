package pl.sda.library.controler;


import pl.sda.library.entity.Author;
import pl.sda.library.entity.Book;
import pl.sda.library.entity.BooksType;
import pl.sda.library.model.*;

import java.time.LocalDate;
import java.util.List;

public class BookController extends  Helper{

    private IBookService bookService;
    private IAuthorService authorService;

    public BookController() {
        this.bookService = new BookService();
        this.authorService = new AuthorService();
    }

    public List<Book> findAllBook() {
        return bookService.findAll();
    }

    public void createBook(String title, LocalDate dateOfPublishing, String isbn, BooksType booksType,
                           Integer numberOfPages, String description, Author autor) {
        Book book = new Book(title,dateOfPublishing, isbn,booksType,numberOfPages,description,autor);
        bookService.save(book);
    }

    public void showAllBookType() {
        for (int i =0 ; i< BooksType.values().length; i ++) {
            System.out.println( "" + i + " ->" + BooksType.values()[i] + " (" + BooksType.values()[i].getDescription() +")");
        }
        System.out.println("X -> anuluj wybór");
    }
    public BooksType getBooksType(String  question) {
        showAllBookType();
        System.out.println(question);
        Integer choice =Integer.parseInt( getScan().nextLine() );
        BooksType result = null;
        if (choice >= 0 || choice <= BooksType.values().length-1) {
            result = BooksType.values()[choice];
        }
        return result;
    }

    public List<Book> showAllBooks( String question ) {
        if( question != null) {
            System.out.println(question);
        }
        List<Book> result = findAllBook();
        for (int i = 0; i < result.size(); i++) {
            System.out.println("" + i + " ->" + result.get(i).getTitle() + " ," + result.get(i).getAuthorName() );
        }
        System.out.println("X -> anuluj wybów");
        return result;
    }
    public Book getChoosenBook() {
        List<Book> lista = showAllBooks(null);
        Book result = null;
        Integer choise = createInteger("Wybierz książkę z listy");
        if ( choise >= 0 || choise <= lista.size()-1) {
            result = lista.get(choise);
        } else if (choise.equals(Integer.MAX_VALUE)) {
            return null;
        }
        return  result;
    }
    public void remove(Book book) {
        if (book != null) {
            bookService.remove(book);
        }
    }

}
