package pl.sda.library.model;

import org.mongodb.morphia.query.Query;
import pl.sda.library.entity.Book;
import pl.sda.library.entity.Borrow;
import pl.sda.library.entity.Borrower;

import java.time.LocalDate;
import java.util.List;

public class BorrowRepository extends BaseManager implements IBorrowRepository {

    private Query<Borrow> query;

    public BorrowRepository() {
        query = getDatastore().createQuery(Borrow.class);
    }

    @Override
    public LocalDate getBorrow(Book book, Borrower borrower) {
        LocalDate result = LocalDate.now();
        Borrow borrow = new Borrow();
            borrow.setBook(book);
            borrow.setBorrower(borrower);
            borrow.setDateOfBorrow(result);
            getDatastore().save(borrow);
        return result;
    }

    @Override
    public LocalDate getGiveBack(Book book, Borrower borrower) {
      return  null;
    }

    @Override
    public List<Borrow> findAllBorrowBook() {
        return query.asList();
    }

}
