package pl.sda.library.controler;


import pl.sda.library.entity.Author;
import pl.sda.library.entity.Book;
import pl.sda.library.entity.BooksType;
import pl.sda.library.model.BookService;
import pl.sda.library.model.IBookService;

import java.time.LocalDate;
import java.util.List;

public class BookController {

    private IBookService bookService;

    public BookController() {
        this.bookService = new BookService();
    }

    public List<Book> findAllBook() {
        return bookService.findAll();
    }

    public void createBook(String title, LocalDate dateOfPublishing, String isbn, BooksType booksType,
                           Integer numberOfPages, String description, Author autor) {
        Book book = new Book(title,dateOfPublishing, isbn,booksType,numberOfPages,description,autor);
        bookService.save(book);
    }

}
