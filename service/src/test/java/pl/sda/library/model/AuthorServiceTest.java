package pl.sda.library.model;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import pl.sda.library.entity.Author;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

public class AuthorServiceTest {

    @Mock private IAuthorRepository authorRepository;
    private Author author;

    @Before
    public void setUp() {
        this.author = new Author();
        author.setName("Hemingway");
        author.setFirstname("Ernest");
        author.setPlaceOfBorn("New York");
    }

    @Test
    public  void shouldReurnNullIfNullIsGiven() {
        authorRepository.find("firstname",null);

        assertThat(authorRepository.find("firstname",null)).isEqualTo(null);
    }
    @Test
    public void shouldFindPropertlyAuthorWhenNameIsGiven() {
        authorRepository.find("name","Hemingway");

        assertThat(authorRepository.find("name","Hemingway")).isEqualTo(author);
    }

    @Test
    public void shouldReturnNullIfNotFoundAuthor() {

    }

    @Test
    public void shouldCallSaveMethod() {
        authorRepository.save(author);

        verify(authorRepository).save(author);
    }

    @Test
    public void shouldCallRemoveMethod() {
        authorRepository.remove(author);

        verify(authorRepository).remove(author);
    }
 }
