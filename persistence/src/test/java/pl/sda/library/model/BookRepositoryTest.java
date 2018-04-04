package pl.sda.library.model;

import org.bson.types.ObjectId;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pl.sda.library.entity.Author;
import pl.sda.library.entity.Book;
import pl.sda.library.model.helper.DatabaseCleanerHelper;
import pl.sda.library.model.helper.TestEntityGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BookRepositoryTest {

    private BookRepository bookRepository;
    private Book book;
    private DatabaseCleanerHelper cleanerHelper;
    private TestEntityGenerator testEntityGenerator;


    @Before
    public void setUp() {
        bookRepository = new BookRepository();
        this.testEntityGenerator = new TestEntityGenerator();
        this.book = testEntityGenerator.getBook();
        cleanerHelper = new DatabaseCleanerHelper();
    }

    @Test
    public  void  t1_shouldSaveBookWnenBookIsNotNull() {
        AuthorRepository authRepo = new AuthorRepository();
        Author auth = testEntityGenerator.getAuthor();
        authRepo.save(auth);

        book.setAutorID(auth);
        bookRepository.save(book);
        Book book2 = bookRepository.find(book.getId());

        assertThat(book).isEqualTo(book2);
    }

    @Test
    public  void t2_shouldNotSaveBookWhenNullIsGiven() {
        bookRepository.save(null);
        Book book2 = bookRepository.find(null);

        assertThat(book2).isEqualTo(null);
    }
    @Test
    public void t3_shouldFindNullIfNullIdIsGiven() {
        Book book = bookRepository.find(null);

        assertThat(book).isEqualTo(null);
    }
    @Test
    public void t5_shouldFindOneBookIfIdIsGiven() {

        Book book2 = bookRepository.find(this.book.getId());

        assertThat(book2).isEqualTo(this.book);
    }


    @Test
    public void t6_shouldReturnNullIfIDNotFound() {
        Book book2 = bookRepository.find(new ObjectId());

        assertThat(book2).isEqualTo(book);
    }
    @Test
    public void t4_shouldReturnAllListOfCollection() {
        List<Book> listofBooks =  bookRepository.findAll();
        this.book.setId(listofBooks.get(0).getId());

        assertThat(listofBooks.size()).isGreaterThanOrEqualTo(1);
        assertThat(listofBooks).element(0).isNotNull();
    }
    @Test
    public void t11_shouldNotRemoveIfNULLIsGiven() {
         bookRepository.remove(null);


    }
    @Test
    public void t100_shouldRemoveBookIfIDIsGiven() {

    }

    @After
    public void cleanDatabases() {
        //cleanerHelper.cleanBook();
        //cleanerHelper.cleanAuthors();
    }
}

