package pl.sda.library.controler;

import pl.sda.library.entity.Author;
import pl.sda.library.model.AuthorService;

public class AuthorController {

    private AuthorService authorService;

    public AuthorController() {
        this.authorService = new AuthorService();
    }

    public void createAuthor(String firstname, String name) {
        Author author = new Author();
        author.setName( name);
        author.setFirstname(firstname);
        authorService.save(author);
    }
}
