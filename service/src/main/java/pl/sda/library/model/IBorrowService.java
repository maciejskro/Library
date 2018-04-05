package pl.sda.library.model;

import pl.sda.library.entity.Book;
import pl.sda.library.entity.Borrow;
import pl.sda.library.entity.Borrower;

import java.time.LocalDate;
import java.util.List;

public interface IBorrowService {

    LocalDate getBorrow(Book book , Borrower borrower);
    LocalDate getGiveBack(Book book , Borrower borrower);
    List<Borrow> findAllBorrowBook();
    List<Book> showBorrowedBookByUser(Borrower borrower);
    void removeBorrow(Borrow b);
}
