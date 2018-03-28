package pl.sda.library.controler;


import pl.sda.library.model.BookService;

public class BookController {

    private BookService bookService;

    public BookController() {
        this.bookService = new BookService();
    }
}
