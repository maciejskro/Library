package pl.sda.library.model;

import org.mongodb.morphia.Datastore;

public class AuthorRepository extends BaseManager {

    private Datastore datastore;

    public AuthorRepository() {
        this.datastore = getDatastore();
    }
}
