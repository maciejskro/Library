package pl.sda.library.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import pl.sda.library.entity.Author;
import pl.sda.library.model.helper.DatabaseCleanerHelper;
import pl.sda.library.model.helper.TestEntityGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class AuthorRepositoryTest {

    private AuthorRepository authorRepository;
    private Query<Author> queryAuthor;
    private Author testAuthor;
    private DatabaseCleanerHelper cleanerHelper;
    private TestEntityGenerator testEntityGenerator;


    @Before
    public void setUp() {
        this.authorRepository = new AuthorRepository();
        this.testAuthor = new Author();
        this.queryAuthor = authorRepository.getDatastore().createQuery(Author.class);
        this.testEntityGenerator = new TestEntityGenerator();
        testAuthor = testEntityGenerator.getAuthor();
        authorRepository.getDatastore().save(testAuthor);
        cleanerHelper = new DatabaseCleanerHelper();
    }

    @Test
    public void shouldSaveAuthorInDatabase() {
        Author auth = testAuthor;

        authorRepository.save(auth);
        Author auth2 = authorRepository.find("name","Hemingway");


        assertThat(auth).isEqualTo(auth2);
    }

    @Test
    public void shouldNotSaveIfNullGiven() {
        Author auth = null;

        AuthorRepository authRepo = mock(AuthorRepository.class);
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

        authorRepository.remove(testAuthor);
        Author find = authorRepository.find(testAuthor.getId());

        assertThat(authorRepository.find(testAuthor.getId())).isNull();
        //verify(authorRepository).remove(testAuthor);

    }

    @After
    public void saveAuthorAfterDeleteTest() {
        //authorRepository.save(testAuthor);
        cleanerHelper.cleanAuthors();
    }
}
