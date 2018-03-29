package pl.sda.library.model;

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

    public Author find(String key , String value ) {
        return query.field(key).equal(value).get();
    }
    public void remove(Author author) {

    }

    public Author find(String... name) {
        List<Author> listAuthor = null;
        if (name.length == 3) {
            listAuthor = query.field("name").equal(name[0])
                    .field("firstname").equal(name[1])
                    .field("placeOfBorn").equal(name[2]).asList();
        }
        Author resutlauth;
        if (listAuthor.size() >= 1) {
            resutlauth = listAuthor.get(0);
        } else
            resutlauth = listAuthor.get(listAuthor.size());
        return resutlauth;
    }
}
