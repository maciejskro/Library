package pl.sda.library.model;

import pl.sda.library.entity.Book;

import java.util.List;

public class BookService implements IBookService {

    private IBookRepository bookRepository;

    public BookService() {
        this.bookRepository = new BookRepository();
    }

    @Override
    public void save(Book book) {

    }

    @Override
    public List<Book> findAll() {
        return null;
    }

    @Override
    public Book findByID(String id) {
        return null;
    }

    @Override
    public void remove(Book book) {

    }
}
