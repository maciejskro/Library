package pl.sda.library.controler;


import pl.sda.library.model.BookService;
import pl.sda.library.model.IBookService;

public class BookController {

    private IBookService bookService;

    public BookController() {
        this.bookService = new BookService();
    }
}
