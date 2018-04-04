package pl.sda.library.entity;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Reference;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Borrow extends BaseEntity implements Serializable{

    private LocalDate dateOfBorrow;
    @Reference
    private Book book;
    @Reference
    private Borrower borrower;
    private Boolean isBorrowed;

    public Borrow() {
    }

    public LocalDate getDateOfBorrow() {
        return dateOfBorrow;
    }

    public void setDateOfBorrow(LocalDate dateOfBorrow) {
        this.dateOfBorrow = dateOfBorrow;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Borrow)) return false;
        Borrow borrow = (Borrow) o;
        return Objects.equals(getDateOfBorrow(), borrow.getDateOfBorrow()) &&
                Objects.equals(getBook(), borrow.getBook()) &&
                Objects.equals(getBorrower(), borrow.getBorrower());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getDateOfBorrow(), getBook(), getBorrower());
    }
}
