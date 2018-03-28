package pl.sda.library.model;

import pl.sda.library.entity.Borrower;

import java.util.List;

public interface IBorrowerService {

    void save(Borrower author);
    List<Borrower> findAll();
    Borrower find(String... names);
    void remove(Borrower author);
}
