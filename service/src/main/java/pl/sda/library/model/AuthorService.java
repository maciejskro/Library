package pl.sda.library.model;

import pl.sda.library.entity.Author;
import pl.sda.library.entity.Book;

import java.util.List;

public class AuthorService implements IAuthorService {

    private IAuthorRepository authorRepository;
    private IBookRepository bookRepository;

    public AuthorService() {
        this.authorRepository = new AuthorRepository();
        this.bookRepository = new BookRepository();
    }

    @Override
    public void save(Author author) {
        authorRepository.save(author);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author find(String... names) {
            return authorRepository.find(names);
    }

    @Override
    public void remove(Author author) {
        List<Book> list =bookRepository.findAll();
        Author deleted = null;
        for (Book b : list) {
            if (! b.getAutorID().equals(author)) {
                deleted = b.getAutorID();
            }
        }
        authorRepository.remove(deleted);
    }
}
