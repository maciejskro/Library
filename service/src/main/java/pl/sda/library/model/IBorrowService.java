package pl.sda.library.model;

import pl.sda.library.entity.Book;
import pl.sda.library.entity.Borrow;

import java.util.List;

public interface IBorrowService {

    void save(Borrow borrow);
    List<Borrow> findAll();
    Borrow findByName(String name);
    void remove(Borrow borrow);

}
