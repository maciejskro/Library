package pl.sda.library.model;

import pl.sda.library.entity.Author;

import java.util.List;

public interface IAuthorService {

    void save(Author author);
    List<Author> findAll();
    List<Author> find(String... names);
    void remove(Author author);
}
