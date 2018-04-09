package pl.sda.library.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.sda.library.entity.Book;
import pl.sda.library.entity.Borrow;

import java.util.List;


public class BookRepository extends BaseManager implements IBookRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookRepository.class);
    private Datastore datastore;

    public BookRepository() {
        super();
        this.datastore = super.getDatastore();
    }

    public void save(Book book) {
        if(book != null) {
            datastore.save(book);
        }
    }

    public List<Book> findAll() {
        Query<Book> query = getDatastore().createQuery(Book.class);
        return query.asList();
    }

    public List<Book> findBookAvailableToBorrow() {
        List<Book> listBooks = findAll();
        Query<Borrow> queryBorrow = getDatastore().createQuery(Borrow.class).disableValidation()
                .filter("book <>", listBooks);

        for( Borrow b : queryBorrow.asList()) {
            System.out.println(b.getBook().getTitle());
        }
//        if (queryBorrow.asList().isEmpty() || queryBorrow.asList().size() == 0) {
//            Query<Book> show = getDatastore().createQuery(Book.class).filter("_id nin", .getId());
//        }
        return listBooks;
    }

    @Override
    public Book find(ObjectId id) {
        Query<Book> findOne = getDatastore().createQuery(Book.class).field("_id").equal(id);
        return findOne.get();
    }

    public Book findByTitle(String title) {
        Query<Book> findOne = getDatastore().createQuery(Book.class).field("title").equal(title);
        return findOne.get();
    }

    public void remove(Book book) {
        if (book != null ) {
            Query<Borrow> queryBorrow = getDatastore().createQuery(Borrow.class).disableValidation()
                                .field("book").hasThisOne(getDatastore().getKey(book));
            if (  queryBorrow.asList().isEmpty() || queryBorrow.asList().size() ==0 ){
                Query<Book> remove = getDatastore().createQuery(Book.class).filter("_id =", book.getId());
                getDatastore().delete(remove);
            }

        }
    }

}
