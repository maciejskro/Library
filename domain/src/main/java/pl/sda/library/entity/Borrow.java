package pl.sda.library.entity;

import org.mongodb.morphia.annotations.Entity;

import java.time.LocalDate;

@Entity
public class Borrow extends BaseEntity{

    private LocalDate dateOfBorrow;
    private Book book;
    private Borrower borrower;

    public Borrow() {
    }
}
