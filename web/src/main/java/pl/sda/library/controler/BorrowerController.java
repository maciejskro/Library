package pl.sda.library.controler;

import pl.sda.library.entity.Borrower;
import pl.sda.library.model.BorrowerService;
import pl.sda.library.model.IBorrowerService;

import java.util.List;

public class BorrowerController extends Helper{

    private IBorrowerService borrowerService;

    public BorrowerController() {
        this.borrowerService = new BorrowerService();  }

    public List<Borrower> findAllBorrower() {
        return borrowerService.findAll();
    }

    public void createBorrower(String frstname, String name, String address, String phoneNumber ,String  email) {
        Borrower borrower = new Borrower(frstname,name, address, phoneNumber ,email ) ;
        borrowerService.save(borrower);
    }


    public List<Borrower> showAllBorrowers(String question) {
        if (question != null) {
            System.out.println(question);
        }
        List<Borrower>  listaBorrowersow = findAllBorrower();
        for ( int i = 0 ; i< listaBorrowersow.size() ; i++) {
            System.out.println("" + i + " ->" + listaBorrowersow.get(i).getFullName());
        }
        System.out.println("X -> anuluj wybór");
        return listaBorrowersow;
    }
    public Borrower getBorrower( String question ) {
        List<Borrower> lista = showAllBorrowers(null);
        if ( question != null) {
            System.out.println(question);
        }
        Integer choise = Integer.parseInt( getScan().nextLine());
        Borrower result = null;
        if (choise >=0 || choise <= lista.size()-1) {
            result = lista.get(choise);
        }
        return result;
    }
}
