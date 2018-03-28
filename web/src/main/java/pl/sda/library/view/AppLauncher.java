package pl.sda.library.view;

import pl.sda.library.controler.AuthorController;

import java.util.Scanner;

public class AppLauncher {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstname = "";
        String name = "";
        AuthorController authorConroler = new AuthorController();
        authorConroler.createAuthor( firstname,  name);
        String authorname = scan.nextLine();
    }
}
