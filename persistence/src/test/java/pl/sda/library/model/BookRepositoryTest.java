package pl.sda.library.model;

import org.junit.Before;
import org.junit.Test;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import pl.sda.library.entity.Author;
import pl.sda.library.entity.Book;
import pl.sda.library.entity.BooksType;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class BookRepositoryTest {

    private Morphia mockMorphia;
    private Datastore mockDatastore;
    private BookRepository bookRepository;

    @Before
    public void setUp() {
       // bookRepository = mock(BookRepository.class);
        bookRepository = new BookRepository();
    }

    @Test
    public  void  shouldSaveBookWnenBookIsNotNull() {
        Book book = new Book();
        book.setBooksType(BooksType.HISTORY);
        book.setDateOfPublishing(LocalDate.of(2018,3,12));
        book.setDescription("dowolnuy opis");
        book.setIsbn("28834555");
        book.setNumberOfPages(500);
        book.setTitle("Tytuł ksiązki");
          Author author = new Author();
            author.setFirstname("John");
            author.setName("Hemingway");
            author.setPlaceOfBorn("New York");
        //book.setAutorID(author);
        bookRepository.save(book);
        Book book2 = bookRepository.find(book);

        assertThat(book).isEqualTo(book2);
    }

    @Test
    public  void shouldNotSaveBookWhenNullIsGiven() {
        Book book = null;
        bookRepository.save(book);
    }
    @Test
    public void shouldFindNullIfNullIdIsGiven() {

    }
    @Test
    public void shouldFindOneBookIfIdIsGiven() {

    }
    @Test
    public void shouldReturnNullIfIDNotFound() {

    }
    @Test
    public void shouldReturnAllListOfCollection() {

    }
    @Test
    public void shouldNotRemoveIfNULLIsGiven() {

    }
    @Test
    public void shouldRemoveBookIfIDIsGiven() {

    }
}

