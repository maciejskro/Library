package pl.sda.library.model;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import pl.sda.library.entity.Author;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AuthorServiceTest {

    @Mock private IAuthorRepository authorRepository;
    private Author author;

    @Before
    public void setUp() {
        this.author = new Author();
        author.setName("Hemingway");
        author.setFirstname("Ernest");
        author.setPlaceOfBorn("New York");
        authorRepository = mock(AuthorRepository.class);
    }

    @Test
    public  void shouldReurnNullIfNullIsGiven() {
        authorRepository.find("firstname",null);

        assertThat(authorRepository.find("firstname",null)).isEqualTo(null);
    }
    @Test
    public void shouldFindPropertlyAuthorWhenNameIsGiven() {
        when(authorRepository.find("name","Hemingway")).thenReturn(author);

        authorRepository.find("name","Hemingway");


        assertThat(authorRepository.find("name","Hemingway")).isEqualTo(author);
    }

    @Test
    public void shouldReturnNullIfNotFoundAuthor() {
        authorRepository.find("name" , "Sienkiewicz");

        assertThat(authorRepository.find("name","Sienkiewicz")).isEqualTo(null);
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
