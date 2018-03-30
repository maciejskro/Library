package pl.sda.library.model.helper;

import pl.sda.library.entity.*;
import pl.sda.library.model.AuthorRepository;

import java.time.LocalDate;

public class TestEntityGenerator {

    private Author author;
    private Book book;
    private Borrower borrower;
    private Borrow borrow;

    public Author getAuthor() {
        this.author = new Author();
        author.setFirstname("Ernest");
        author.setName("Hemingway");
        author.setPlaceOfBorn("New York");
        return this.author;
    }
    public Book getBook() {
        this.book = new Book();
            book.setBooksType(BooksType.HISTORY);
            book.setDateOfPublishing(LocalDate.of(2018,3,12));
            book.setDescription("dowolny opis");
            book.setIsbn("28834555");
            book.setNumberOfPages(500);
            book.setTitle("Tytuł ksiązki");
            book.setAutorID(getAuthor());
        return this.book;
    }
    public Borrower getBorrower() {
        this.borrower = new Borrower();
            borrower.setName("Kowalski");
            borrower.setFirstname("Piotr");
            borrower.setAddress("ul. Zachodnia 1, 12-223 Kraków");
            borrower.setEmail("kowalski@gmail.com");
            borrower.setPhoneNumber("+48 666 666 123");
        return borrower;
    }

    public Borrow getBorrow() {
        this.borrow = new Borrow();
        borrow.setBook(getBook());
        borrow.setBorrower(getBorrower());
        borrow.setDateOfBorrow(LocalDate.now());
        return  borrow;
    }
}
