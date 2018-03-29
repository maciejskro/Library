package pl.sda.library.entity;

import org.mongodb.morphia.annotations.Entity;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Author extends BaseEntity implements Serializable{

    private String firstname;
    private String name;
    private String placeOfBorn;


    public Author() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlaceOfBorn() {
        return placeOfBorn;
    }

    public void setPlaceOfBorn(String placeOfBorn) {
        this.placeOfBorn = placeOfBorn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;
        Author author = (Author) o;
        return Objects.equals(getFirstname(), author.getFirstname()) &&
                Objects.equals(getName(), author.getName()) &&
                Objects.equals(getPlaceOfBorn(), author.getPlaceOfBorn());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getFirstname(), getName(), getPlaceOfBorn());
    }

    @Override
    public String toString() {
        return "Author{" +
                "firstname='" + firstname + '\'' +
                ", name='" + name + '\'' +
                ", placeOfBorn='" + placeOfBorn + '\'' +
                '}';
    }
}
