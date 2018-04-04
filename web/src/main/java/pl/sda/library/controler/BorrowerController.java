package pl.sda.library.controler;

import pl.sda.library.entity.Borrower;
import pl.sda.library.model.BorrowerService;
import pl.sda.library.model.IBorrowerService;

import java.util.List;

public class BorrowerController {

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

}
