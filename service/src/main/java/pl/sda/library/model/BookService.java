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
        return bookRepository.findAll();
    }

    @Override
    public Book findByID(ObjectId id) {
        return bookRepository.find(id);
    }

    @Override
    public Book findByTitle(String id) {
        Book result = null;
        for (Book b : bookRepository.findAll()) {
            if (b.getTitle().equals(id)) {
                result =b;
            }
        }
        return result;
    }

    @Override
    public void remove(Book book) {
        bookRepository.remove(book);
    }
}
