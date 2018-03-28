package pl.sda.library.model;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import pl.sda.library.entity.Author;

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
    public  void shouldFindNullIfNullIsGiven() {

    }
    @Test
    public void shouldFindPropertlyAuthorWhenNameIsGiven() {

    }
 }
