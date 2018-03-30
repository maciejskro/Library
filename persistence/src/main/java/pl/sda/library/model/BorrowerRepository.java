package pl.sda.library.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.query.Query;
import pl.sda.library.entity.Borrower;

import java.util.List;

public class BorrowerRepository extends BaseManager implements IBorrowerRepository {

    private Query<Borrower> query;

    BorrowerRepository() {
        this.query = getDatastore().createQuery(Borrower.class);
    }
    @Override
    public void save(Borrower borrower) {
        getDatastore().save(borrower);
    }

    @Override
    public List<Borrower> findAll() {
        return query.asList();
    }

    @Override
    public Borrower find(ObjectId id ) {
        return query.field("_id").equal(id).get();
    }

    @Override
    public void remove(Borrower borrower) {
        getDatastore().delete(borrower);
    }


}
