package pl.sda.library.model;

import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import pl.sda.library.entity.Author;
import pl.sda.library.entity.Book;
import pl.sda.library.entity.BooksType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

public class BookServiceTest {

    @Mock private IBookService bookService;
    private Author author;
    private Book book;

    @Before
    public  void setUp() {
        this.bookService = mock(BookService.class);
        this.author = (new AuthorRepository()).find("name","Hemingway");
        this.book = new Book();
        book.setId(new ObjectId());
        book.setAutorID(author);
        book.setBooksType(BooksType.HISTORY);
        book.setDateOfPublishing(LocalDate.of(2017,03,01));
        book.setDescription("opis");
        book.setIsbn("123456789");
        book.setNumberOfPages(500);
        book.setTitle("House of Cards");
    }

    @Test
    public  void  shouldSaveNewBookIfBookIsGiven() {
        bookService.save(this.book);

        verify(bookService).save(this.book);
    }


    @Test
    public void shouldNotSaveIfNullIsGiven() {
        Book nullbook = null;
        bookService.save(nullbook);

        verify(bookService,never()).save(nullbook);
    }
    @Test
    public void shouldFindListOfAllBooks() {
        List<Book> listBook = new ArrayList<>();
        listBook.add(book);
        when(bookService.findAll()).thenReturn(listBook);

        bookService.findAll();

        verify(bookService).findAll();
        assertThat(bookService.findAll()).isEqualTo(listBook);
    }

    @Test
    public  void shouldFindBookByTitle() {
        String title = "House of Cards";
        when(bookService.findByTitle(title)).thenReturn(book);

        bookService.findByTitle(title);

        verify(bookService).findByTitle(title);
    }

    @Test
    public  void shouldFindBookByID() {
        ObjectId id = book.getId();
        when(bookService.findByID(id)).thenReturn(book);

        bookService.findByID(id);

        verify(bookService).findByID(id);
        assertThat(bookService.findByID(id)).isEqualTo(book);
    }
}

