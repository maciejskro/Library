package pl.sda.library.model;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import pl.sda.library.entity.Book;

import java.util.List;


public class BookRepository extends BaseManager {

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
    public Book find(Book book) {
        Query<Book> findOne = getDatastore().createQuery(Book.class).filter("_id",book);
        return findOne.get();
    }

    public List<Book> find() {
        Query<Book> query = getDatastore().createQuery(Book.class);
        return query.asList();
    }

    public void remove(Book book) {
        Book remove = find(book);
        getDatastore().delete(remove);
    }
}
