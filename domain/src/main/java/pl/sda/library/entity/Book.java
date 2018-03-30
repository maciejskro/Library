package pl.sda.library.entity;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Reference;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Book extends BaseEntity implements Serializable {

    private String title;
    private LocalDate dateOfPublishing;
    private String isbn;
    private BooksType booksType;
    private Integer numberOfPages;
    private String description;
    @Reference
    private Author autorID;

    public Book(){
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDateOfPublishing() {
        return dateOfPublishing;
    }

    public void setDateOfPublishing(LocalDate dateOfPublishing) {
        this.dateOfPublishing = dateOfPublishing;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public BooksType getBooksType() {
        return booksType;
    }

    public void setBooksType(BooksType booksType) {
        this.booksType = booksType;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Author getAutorID() {
        return autorID;
    }

    public void setAutorID(Author autorID) {
        this.autorID = autorID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(getTitle(), book.getTitle()) &&
                Objects.equals(getDateOfPublishing(), book.getDateOfPublishing()) &&
                Objects.equals(getIsbn(), book.getIsbn()) &&
                getBooksType() == book.getBooksType() &&
                Objects.equals(getNumberOfPages(), book.getNumberOfPages()) &&
                Objects.equals(getDescription(), book.getDescription()) &&
                Objects.equals(getAutorID(), book.getAutorID());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getTitle(), getDateOfPublishing(), getIsbn(), getBooksType(), getNumberOfPages(), getDescription(), getAutorID());
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", dateOfPublishing=" + dateOfPublishing +
                ", isbn='" + isbn + '\'' +
                ", booksType=" + booksType +
                ", numberOfPages=" + numberOfPages +
                ", description='" + description + '\'' +
                ", autorName=" + autorID.getFirstname() + " " + autorID.getName() +
                '}';
    }
}
