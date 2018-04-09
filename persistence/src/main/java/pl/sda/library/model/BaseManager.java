package pl.sda.library.model;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseManager {

    private final Morphia morphia;
    private final MongoClient mongoClient;
    private Datastore datastore;
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseManager.class);

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
