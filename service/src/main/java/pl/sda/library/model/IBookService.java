package pl.sda.library.model;

import org.bson.types.ObjectId;
import pl.sda.library.entity.Book;

import java.util.List;

public interface IBookService {

    void save(Book book);
    List<Book> findAll();
    Book findByID(ObjectId id);
    List<Book> findByTitle(String id);
    void remove(Book book);
}
