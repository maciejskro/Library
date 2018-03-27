package pl.sda.library.model;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

public class BaseManager {

    private final Morphia morphia;
    private final MongoClient mongoClient;
    private Datastore datastore;

    public BaseManager() {
        this.morphia = new Morphia();
        this.mongoClient = new MongoClient();
        this.datastore = morphia.createDatastore(mongoClient,"library");
    }

    public Datastore getDatastore() {
        return datastore;
    }
    public Morphia getMorphia() {
        return  morphia;
    }
}
