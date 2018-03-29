package pl.sda.library.model;

import pl.sda.library.entity.Author;

import java.util.List;

public interface IAuthorRepository {

    void save(Author author);
    List<Author> findAll();
    Author find(String key, String value);
    void remove(Author author);
}
