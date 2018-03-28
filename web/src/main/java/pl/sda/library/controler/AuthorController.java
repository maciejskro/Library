package pl.sda.library.controler;

import pl.sda.library.entity.Author;
import pl.sda.library.model.AuthorService;

import java.util.List;

public class AuthorController {

    private AuthorService authorService;

    public AuthorController() {
        this.authorService = new AuthorService();
    }

    public void createAuthor(String firstname, String name, String placeOfBorn) {
        Author author = new Author();
        author.setName( name);
        author.setFirstname(firstname);
        author.setPlaceOfBorn(placeOfBorn);
        authorService.save(author);
    }
    public List<Author> findAuthor(String... name) {
        List<Author> result = authorService.find(name);
        return result;
    }

    public void removeAuthor(Author author) {
        authorService.remove(author);
    }
}
