package pl.sda.library.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import pl.sda.library.entity.Author;

import java.util.List;

public class AuthorRepository extends BaseManager implements IAuthorRepository {

    private Datastore datastore;
    private Query<Author> query;

    public AuthorRepository() {
        this.datastore = super.getDatastore();
        this.query = datastore.createQuery(Author.class);
    }

    public void save(Author author) {
        if (author !=null) {
            datastore.save(author);
        }
    }
    public List<Author> findAll() {
       return query.asList();
    }

    public Author find(ObjectId id ) {
        return query.field("_id").equal(id).get();
    }

    public Author find(String... name) {
        List<Author> listAuthor = null;
        if (name.length % 2 == 0) {
            for (int i =0 ; i < name.length ; i=i+2) {
                query.field(name[i]).equal(name[i + 1]);
            }
            listAuthor = query.asList();
        }
        Author resutlauth;
        if (listAuthor.size() >= 1) {
            resutlauth = listAuthor.get(0);
        } else
            resutlauth = listAuthor.get(listAuthor.size());
        return resutlauth;
    }

    public void remove(Author author) {
        if (author != null) {
            query = query.filter("_id", author);
            datastore.delete(query);
        }
    }


}
