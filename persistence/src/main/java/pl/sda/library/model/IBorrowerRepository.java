package pl.sda.library.model;

import org.bson.types.ObjectId;
import pl.sda.library.entity.Borrower;

import java.util.List;

public interface IBorrowerRepository {

    void save(Borrower borrower);
    List<Borrower> findAll();
    Borrower find(ObjectId id);
    void remove(Borrower borrower);

}
