package pl.sda.library.model;

import org.bson.types.ObjectId;
import pl.sda.library.entity.Author;

import java.util.List;

public interface IAuthorRepository {

    void save(Author author);
    List<Author> findAll();
    Author find(ObjectId id);
    Author find(String... names);
    void remove(Author author);
}
