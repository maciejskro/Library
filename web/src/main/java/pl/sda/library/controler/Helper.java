package pl.sda.library.controler;

import java.time.LocalDate;
import java.util.Scanner;

public class Helper {

    private  static final Scanner SCAN = new Scanner(System.in);

    public Helper() {
    }

    protected Scanner getScan() {
        return SCAN;
    }

    protected static String createString(String question) {
        System.out.println(question);
        String result = SCAN.nextLine().trim();
        return result;
    }
    protected static LocalDate createDate(String question) {
        System.out.println( question);
        String result = SCAN.nextLine().trim();
        LocalDate datResult = null;
        if (result.equals("X")) {
            datResult = LocalDate.MAX;
        } else {
            datResult = LocalDate.parse(result);
        }
        return datResult;
    }
    protected static Integer createInteger(String question) {
        if ( question != null) {
            System.out.println(question);
        }
        String result = SCAN.nextLine().trim();
        Integer intResult = null;
        if (result.equals("X")) {
            intResult = Integer.MAX_VALUE;
        } else {
            intResult = Integer.parseInt(result);
        }
        return  intResult;
    }
}
