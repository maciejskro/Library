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
    public  void  t01_shouldSaveBookWnenBookIsNotNull() {
        AuthorRepository authRepo = new AuthorRepository();
        Author auth = testEntityGenerator.getAuthor();
        authRepo.save(auth);

        book.setAutorID(auth);
        bookRepository.save(book);
        Book book2 = bookRepository.find(book.getId());

        assertThat(book).isEqualTo(book2);
    }

    @Test
    public  void t02_shouldNotSaveBookWhenNullIsGiven() {
        bookRepository.save(null);
        Book book2 = bookRepository.find(null);

        assertThat(book2).isEqualTo(null);
    }
    @Test
    public void t03_shouldFindNullIfNullIdIsGiven() {
        Book book = bookRepository.find(null);

        assertThat(book).isEqualTo(null);
    }
    @Test
    public void t05_shouldFindOneBookIfIdIsGiven() {
        List<Book> listbook = bookRepository.findAll();
        Book book2 = bookRepository.find(listbook.get(0).getId());
        System.out.println(listbook.size());
        assertThat(book2).isEqualTo(this.book);
    }

    @Test
    public void t06_shouldReturnNullIfIDNotFound() {
        Book book2 = bookRepository.find(new ObjectId());

        assertThat(book2).isNull();
    }
    @Test
    public void t04_shouldReturnAllListOfCollection() {
        List<Book> listofBooks =  bookRepository.findAll();
        this.book.setId(listofBooks.get(0).getId());

        assertThat(listofBooks.size()).isGreaterThanOrEqualTo(1);
        assertThat(listofBooks).element(0).isNotNull();
    }
    @Test
    public void t11_shouldNotRemoveIfNULLIsGiven() {
        List<Book> listbook = bookRepository.findAll();
        int howmany = listbook.size();
         bookRepository.remove(null);
       List<Book> listbook2 = bookRepository.findAll();
       assertThat(howmany).isEqualTo(listbook2.size());
    }
    @Test
    public void t99_shouldRemoveBookIfIDIsGiven() {
        List<Book> listbook = bookRepository.findAll();
        int howmany = listbook.size();
        bookRepository.remove(listbook.get(0));
        List<Book> listbook2 = bookRepository.findAll();
        assertThat(howmany).isGreaterThan(listbook2.size());


    }

    @After
    public void cleanDatabases() {
        //cleanerHelper.cleanBook();
        //cleanerHelper.cleanAuthors();
    }
}

