package pl.sda.library.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.sda.library.entity.Borrower;

import java.util.List;

public class BorrowerRepository extends BaseManager implements IBorrowerRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(BorrowerRepository.class);
    private Query<Borrower> query;

    BorrowerRepository() {
        this.query = getDatastore().createQuery(Borrower.class);
    }
    @Override
    public void save(Borrower borrower) {
        if (borrower !=null ) {
            getDatastore().save(borrower);
        }
    }

    @Override
    public List<Borrower> findAll() {
        return query.asList();
    }

    @Override
    public Borrower find(ObjectId id ) {
        if (id != null) {
            return query.field("_id").equal(id).get();
        } else return null;
    }

    @Override
    public void remove(Borrower borrower) {
        if (borrower != null) {
            Query<Borrower> remove = getDatastore().createQuery(Borrower.class).filter("_id =", borrower.getId());
            getDatastore().delete(remove);
        }
    }


}
