package pl.sda.library.model;

import org.junit.Before;
import org.junit.Test;
import org.mongodb.morphia.Datastore;
import pl.sda.library.entity.Author;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class AuthorRepositoryTest {

    private AuthorRepository authorRepository;
    private AuthorRepository mockAuthorRepository;
    private Author testAuthor;
    @Before
    public void setUp() {
        this.authorRepository = new AuthorRepository();
        this.mockAuthorRepository = mock(AuthorRepository.class);
        this.testAuthor = new Author();
        testAuthor.setFirstname("Ernest");
        testAuthor.setName("Hemingway");
        testAuthor.setPlaceOfBorn("New York");
    }

    @Test
    public void shouldSaveAuthorInDatabase() {
        Author auth = testAuthor;

        Author auth2 = authorRepository.find("Hemingway");
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

        Author auth = authorRepository.find("Hemingway");

        assertThat(auth).isEqualTo(testAuthor);
    }

    @Test
    public  void shouldFindAuthorByAllSequence() {
        Author auth = authorRepository.find(testAuthor.getFirstname(), testAuthor.getName(), testAuthor.getPlaceOfBorn());

        assertThat(auth).isEqualTo(testAuthor);
    }

    @Test
    public void shouldRemoveAuthorByID() {
        Datastore ds = mock(Datastore.class);

        verify(mockAuthorRepository).remove(testAuthor);
        verify(ds).delete(testAuthor);
    }
    @Test
    public void shouldNotRermoveIfNullIsGiven() {
        Author auth = null;
        Datastore ds = mock(Datastore.class);

        verify(mockAuthorRepository).remove(auth);
        verify(ds).delete(auth);
    }
}
