package pl.sda.library.entity;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;

public abstract class BaseEntity {

    @Id
    private ObjectId id;
    private Long version;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
