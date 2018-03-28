package pl.sda.library.view;

import pl.sda.library.controler.AuthorController;
import pl.sda.library.controler.BookController;
import pl.sda.library.controler.BorrowController;
import pl.sda.library.controler.BorrowerController;
import pl.sda.library.entity.Author;
import pl.sda.library.model.AuthorService;

import java.util.Scanner;

public class AppLauncher {

    private AuthorController authorController;
    private BookController bookController;
    private BorrowController borrowController;
    private BorrowerController borrowerController;

    public AppLauncher() {
        this.authorController = new AuthorController();
        this.bookController = new BookController();
        this.borrowController = new BorrowController();
        this.borrowerController = new BorrowerController();
    }

    public static void main(String[] args) {
        AppLauncher appLauncher = new AppLauncher();
        Scanner scan = new Scanner(System.in);
        String firstname = createString(scan, "Podaj imie autora:");
        String name = createString(scan, "Podaj nazwisko autora:");
        String placeOfBorn = createString(scan, "Podaj miejsce urodzenia autora:");

        appLauncher.authorController.createAuthor( firstname,  name, placeOfBorn);

    }

    public static String createString(Scanner scan, String question) {
        System.out.println(question);
        String result = scan.nextLine();
        return result;
    }
}
