package pl.sda.library.controler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.sda.library.entity.Author;
import pl.sda.library.model.AuthorService;
import pl.sda.library.model.BorrowerService;
import pl.sda.library.model.IAuthorService;

import java.util.List;

public class AuthorController extends Helper {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorController.class);
    private IAuthorService authorService;

    public AuthorController() {
        super();
        this.authorService = new AuthorService();
    }

    public void createAuthor(String firstname, String name, String placeOfBorn) {
        Author author = new Author();
        author.setName( name);
        author.setFirstname(firstname);
        author.setPlaceOfBorn(placeOfBorn);
        authorService.save(author);
    }

    public Author findAuthor(String... name) {
        Author result = authorService.find(name);
        return result;
    }
    public List<Author> findListAuthor() {
        return authorService.findAll();
    }

    public void removeAuthor(Author author) {
        authorService.remove(author);
    }

    public List<Author> showAllAuthor(String question) {
        if ( question != null) {
            System.out.println(question);
        }
        List<Author> result = findListAuthor();

        for (int i = 0; i < result.size(); i++) {
            System.out.println( "" + i + " -> " + result.get(i).getFirstname() + " " +result.get(i).getName());
        }
        System.out.println("X -> anuluj wybór");
        return  result;
    }
    public Author getChoosenAuthor(String question) {
        List<Author> lista = showAllAuthor(question);
        Author result = null;
        Integer choise = createInteger("Wybierz autora");
        if ( choise >= 0 || choise <= lista.size()-1) {
            result = lista.get(choise);
        } else if (choise.equals(Integer.MAX_VALUE)) {
            return null;
        }
        return  result;
    }
}
