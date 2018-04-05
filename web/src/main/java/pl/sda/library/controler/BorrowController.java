package pl.sda.library.controler;

import pl.sda.library.entity.Book;
import pl.sda.library.entity.Borrow;
import pl.sda.library.entity.Borrower;
import pl.sda.library.model.BorrowService;
import pl.sda.library.model.IBorrowService;

import java.time.LocalDate;

public class BorrowController {

    private IBorrowService borrowSerevice;

    public BorrowController() {
        this.borrowSerevice = new BorrowService();
    }

    public void getBorrow(Book book , Borrower borrower) {
        borrowSerevice.getBorrow(book,borrower);
    }
    public void getGiveMeBack(Book book, Borrower borrower) {
        borrowSerevice.getGiveBack(book,borrower);
    }

}
