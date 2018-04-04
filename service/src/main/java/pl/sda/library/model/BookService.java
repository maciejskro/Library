package pl.sda.library.model;

import org.bson.types.ObjectId;
import pl.sda.library.entity.Book;

import java.util.List;

public class BookService implements IBookService {

    private IBookRepository bookRepository;

    public BookService() {
        this.bookRepository = new BookRepository();
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return null;
    }

    @Override
    public Book findByID(ObjectId id) {
        return null;
    }

    @Override
    public Book findByTitle(String id) {
        return null;
    }

    @Override
    public void remove(Book book) {

    }
}
