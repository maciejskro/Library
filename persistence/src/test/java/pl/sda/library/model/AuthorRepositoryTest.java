package pl.sda.library.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import pl.sda.library.entity.Author;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class AuthorRepositoryTest {

    private AuthorRepository authorRepository;
    private AuthorRepository mockAuthorRepository;
    private Query<Author> mockQueryAuthor;
    private Author testAuthor;
    @Before
    public void setUp() {
        this.authorRepository = new AuthorRepository();
        this.mockAuthorRepository = mock(AuthorRepository.class);
        this.testAuthor = new Author();
        this.mockQueryAuthor = mock(Query.class);
        testAuthor.setFirstname("Ernest");
        testAuthor.setName("Hemingway");
        testAuthor.setPlaceOfBorn("New York");
    }

    @Test
    public void shouldSaveAuthorInDatabase() {
        Author auth = testAuthor;

        Author auth2 = authorRepository.find("name","Hemingway");
        if (auth2 == null ) {
            authorRepository.save(auth);
        }

        assertThat(auth).isEqualTo(auth2);
    }

    @Test
    public void shouldNotSaveIfNullGiven() {
        Author auth = null;

        AuthorRepository authRepo = mockAuthorRepository;
        Datastore ds = mock(Datastore.class);
        authRepo.save(auth);

        verify(authRepo).save(auth);
        verify(ds,never()).save(auth);
    }

    @Test
    public void  shouldFindAuthorByName() {

        Author auth = authorRepository.find("name","Hemingway");

        assertThat(auth).isEqualTo(testAuthor);
    }

    @Test
    public  void shouldFindAuthorByAllSequence() {
        Author auth = authorRepository.find("firstname",testAuthor.getFirstname(), "name",testAuthor.getName());

        assertThat(auth).isEqualTo(testAuthor);
    }

    @Test
    public void shouldRemoveAuthorByID() {

        mockAuthorRepository.remove(testAuthor);

        verify(mockAuthorRepository).remove(testAuthor);

    }
    @Test
    public void shouldNotRermoveIfNullIsGiven() {
        Author auth = null;
        Datastore ds = mock(Datastore.class);

        mockAuthorRepository.remove(auth);

        verify(mockAuthorRepository).remove(auth);
        verify(ds,never()).delete(mockQueryAuthor);
    }

    @After
    public void saveAuthorAfterDeleteTest() {
        //authorRepository.save(testAuthor);
    }
}
