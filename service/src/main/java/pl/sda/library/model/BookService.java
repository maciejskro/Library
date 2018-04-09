package pl.sda.library.model;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.sda.library.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookService implements IBookService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookService.class);
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
        return bookRepository.findAll();
    }

    @Override
    public Book findByID(ObjectId id) {
        return bookRepository.find(id);
    }

    @Override
    public List<Book> findByTitle(String id) {
        List<Book> result = new ArrayList<>();
        for (Book b : bookRepository.findAll()) {
            if (b.getTitle().equals(id)) {
                result.add(b);
            }
        }
        return result;
    }

    @Override
    public List<Book> findBookAvailableToBorrow() {
        return  bookRepository.findBookAvailableToBorrow ();
    }

    @Override
    public void remove(Book book) {
        bookRepository.remove(book);
    }
}
