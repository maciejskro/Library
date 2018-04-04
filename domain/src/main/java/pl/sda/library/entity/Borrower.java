package pl.sda.library.entity;

import org.mongodb.morphia.annotations.Entity;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Borrower extends BaseEntity implements Serializable {

    private String firstname;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;

    public Borrower(){
    }

    public Borrower(String firstname, String name, String address, String phoneNumber, String email) {
        this.firstname = firstname;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return  firstname + " " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Borrower)) return false;
        Borrower borrower = (Borrower) o;
        return Objects.equals(getFirstname(), borrower.getFirstname()) &&
                Objects.equals(getName(), borrower.getName()) &&
                Objects.equals(getAddress(), borrower.getAddress()) &&
                Objects.equals(getPhoneNumber(), borrower.getPhoneNumber()) &&
                Objects.equals(getEmail(), borrower.getEmail());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getFirstname(), getName(), getAddress(), getPhoneNumber(), getEmail());
    }

    @Override
    public String toString() {
        return "Borrower{" +
                "firstname='" + firstname + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
