package pl.sda.library.model;

import pl.sda.library.entity.Author;

import java.util.List;

public class AuthorService implements IAuthorService {

    private IAuthorRepository authorRepository;

    public AuthorService() {
        this.authorRepository = new AuthorRepository();
    }

    @Override
    public void save(Author author) {
        authorRepository.save(author);
    }

    @Override
    public List<Author> findAll() {
        return null;
    }

    @Override
    public List<Author> find(String... names) {
        return null;
    }

    @Override
    public void remove(Author author) {

    }
}
