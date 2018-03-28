package pl.sda.library.model;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import pl.sda.library.entity.Book;

import static org.mockito.Mockito.mock;

public class BookRepositoryTest {

    @Mock private Morphia mockMorphia;
    @Mock private Datastore mockDatastore;
    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
    private BookRepository bookRepository;

    @Before
    public void setUp() {
        bookRepository = mock(BookRepository.class);
    }

    @Test
    public  void  shouldSaveBookWnenBookIsNotNull() {
        Book book = new Book();
        bookRepository.save(book);
        Mockito.verify(bookRepository).save(book);
    }

    @Test
    public  void shouldNotSaveBookWhenNullIsGiven() {

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

