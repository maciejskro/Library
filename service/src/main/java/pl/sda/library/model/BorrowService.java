package pl.sda.library.model;

import pl.sda.library.entity.Book;
import pl.sda.library.entity.Borrow;
import pl.sda.library.entity.Borrower;

import java.time.LocalDate;
import java.util.List;

public class BorrowService implements IBorrowService {

    private IBorrowRepository borrowRepository;

    public BorrowService() {
        this.borrowRepository = new BorrowRepository();
    }


    @Override
    public LocalDate getBorrow(Book book, Borrower borrower) {
        LocalDate result = borrowRepository.getBorrow(book, borrower);
        return result;
    }

    @Override
    public LocalDate getGiveBack(Book book, Borrower borrower) {
        LocalDate result = borrowRepository.getGiveBack(book, borrower);
        return result;
    }

    @Override
    public List<Borrow> findAllBorrowBook() {
        return borrowRepository.findAllBorrowBook();
    }

     @Override
    public List<Book> showBorrowedBookByUser(Borrower borrower) {
        return borrowRepository.findBorrowedBook(borrower);
    }

    @Override
    public void removeBorrow(Borrow b) {
        borrowRepository.remove(b);
    }


}
