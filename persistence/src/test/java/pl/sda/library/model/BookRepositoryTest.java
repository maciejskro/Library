package pl.sda.library.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pl.sda.library.entity.Author;
import pl.sda.library.entity.Book;
import pl.sda.library.entity.BooksType;
import pl.sda.library.model.helper.DatabaseCleanerHelper;
import pl.sda.library.model.helper.TestEntityGenerator;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class BookRepositoryTest {

    private BookRepository bookRepository;
    private Book book;
    private DatabaseCleanerHelper cleanerHelper;
    private TestEntityGenerator testEntityGenerator;


    @Before
    public void setUp() {
        bookRepository = new BookRepository();
        this.book = testEntityGenerator.getBook();
        cleanerHelper = new DatabaseCleanerHelper();
    }

    @Test
    public  void  shouldSaveBookWnenBookIsNotNull() {

        bookRepository.save(book);

        Book book2 = bookRepository.find(book.getId());

        assertThat(book).isEqualTo(book2);
    }

    @Test
    public  void shouldNotSaveBookWhenNullIsGiven() {

    }
    @Test
    public void shouldFindNullIfNullIdIsGiven() {
        Book book = bookRepository.find(null);

        assertThat(book).isEqualTo(null);
    }
    @Test
    public void shouldFindOneBookIfIdIsGiven() {

        Book book2 = bookRepository.find(this.book.getId());

        assertThat(book2).isEqualTo(this.book);
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

    @After
    public void cleanDatabases() {
        //cleanerHelper.cleanBook();
        //cleanerHelper.cleanAuthors();
    }
}

