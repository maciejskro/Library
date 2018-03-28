package pl.sda.library.model;

import pl.sda.library.entity.Book;

import java.util.List;

public interface IBookService {

    void save(Book book);
    List<Book> findAll();
    void remove(Book book);
}
