package pl.sda.library.model.helper;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import pl.sda.library.entity.Author;
import pl.sda.library.entity.Book;


public class DatabaseCleanerHelper {

    private MongoClient mongoClient;
    private Morphia morphia;
    private Datastore ds;

    public DatabaseCleanerHelper() {
        this.morphia = new Morphia();
        this.mongoClient = new MongoClient();
        this.ds = morphia.createDatastore(mongoClient,"library");
    }

    public void cleanAuthors() {
        Query<Author> q = ds.createQuery(Author.class).filter("name = ", "Hemingway");
        ds.delete(q);
    }

    public void cleanBook() {
        Query<Book> q = ds.createQuery(Book.class).filter("title = ","Tytuł ksiązki");
        ds.delete(q);
    }
}
