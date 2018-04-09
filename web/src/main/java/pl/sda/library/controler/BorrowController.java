package pl.sda.library.controler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.sda.library.entity.Book;
import pl.sda.library.entity.Borrow;
import pl.sda.library.entity.Borrower;
import pl.sda.library.model.*;

import java.time.LocalDate;
import java.util.List;

public class BorrowController extends Helper{

    private static final Logger LOGGER = LoggerFactory.getLogger(BorrowController.class);
    private IBorrowService borrowSerevice;
    private IBookService bookService;

    public BorrowController() {
        this.bookService = new BookService();
        this.borrowSerevice = new BorrowService();
    }

    public void getBorrow(Book book , Borrower borrower) {
        borrowSerevice.getBorrow(book,borrower);
    }
    public void getGiveMeBack(Book book, Borrower borrower) {
        borrowSerevice.getGiveBack(book,borrower);
    }
    public void callGiveMeBack(Borrow borrow) {
        borrowSerevice.removeBorrow(borrow);
    }

    public List<Book> showBorrowedBookByUser(Borrower borrower) {
        List<Book> result  = borrowSerevice.showBorrowedBookByUser(borrower);
        return result;
    }
    public List<Borrow> showBorrowedBook() {
        List<Borrow> result =borrowSerevice.findAllBorrowBook();
        System.out.println("Wypożyczone książki");
        if (result != null) {
            for (int i = 0; i< result.size() ; i++) {
                System.out.println(""+ i + ". '" + result.get(i).getBook().getTitle() + "' autor:"
                                                 + result.get(i).getBook().getAuthorName() + " pożyczona przez: " + result.get(i).getBorrower().getFullName() );
            }
        }
        return  result;
    }

    public Book getBook2Borrow( String question ) {
        if (question != null ) {
            System.out.println( question );
        }
        List<Book> borrowedBooks = bookService.findBookAvailableToBorrow();

        Book result = null;
        Integer choise = null;
        if (question == null) {
            choise = createInteger(question);
        }
        else choise = createInteger("");
        if ( choise >=0 || choise <= borrowedBooks.size()-1) {
            result = borrowedBooks.get(choise);
        }
        return result;
    }
}
