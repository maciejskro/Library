package pl.sda.library.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import pl.sda.library.entity.Book;

import java.util.List;


public class BookRepository extends BaseManager implements IBookRepository {

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
            Query<Book> remove = getDatastore().createQuery(Book.class).filter("_id =", book.getId());
            getDatastore().delete(remove);
        }
    }

}
