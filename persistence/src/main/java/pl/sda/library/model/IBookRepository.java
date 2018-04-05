package pl.sda.library.model;

import org.bson.types.ObjectId;
import pl.sda.library.entity.Book;

import java.util.List;

public interface IBookRepository {

    void save(Book book);
    List<Book> findAll();
    Book find(ObjectId id);
    Book findByTitle(String title);
    void remove(Book book);

}
