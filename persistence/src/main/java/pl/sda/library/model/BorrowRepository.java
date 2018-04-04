package pl.sda.library.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import pl.sda.library.entity.Book;
import pl.sda.library.entity.Borrow;
import pl.sda.library.entity.Borrower;

import java.time.LocalDate;
import java.util.List;

public class BorrowRepository extends BaseManager implements IBorrowRepository {

    private Query<Borrow> query;
    private Datastore ds;

    public BorrowRepository() {
        query = getDatastore().createQuery(Borrow.class);
    }

    @Override
    public LocalDate getBorrow(Book book, Borrower borrower) {
        LocalDate resultDate = LocalDate.now();
        Borrow borrow = new Borrow();
            borrow.setBook(book);
            borrow.setBorrower(borrower);
            borrow.setDateOfBorrow(resultDate);
            getDatastore().save(borrow);
        return resultDate;
    }

    @Override
    public LocalDate getGiveBack(Book book, Borrower borrower) {
        getDatastore().find(Borrow.class).disableValidation();
           Query<Borrow> q = query.field("book").equal(book.getId())
                   .field("borrower").equal(borrower.getId());
           LocalDate result = q.get().getDateOfBorrow();
         getDatastore().delete(q);
         return result;
    }

    @Override
    public List<Borrow> findAllBorrowBook() {
        return query.asList();
    }

}
