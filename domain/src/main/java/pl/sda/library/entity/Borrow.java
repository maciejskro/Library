package pl.sda.library.entity;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Reference;

import java.time.LocalDate;

@Entity
public class Borrow extends BaseEntity{

    private LocalDate dateOfBorrow;
    @Reference
    private Book book;
    @Reference
    private Borrower borrower;

    public Borrow() {
    }
}
