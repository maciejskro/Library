package pl.sda.library.controler;

import pl.sda.library.model.BorrowService;
import pl.sda.library.model.IBorrowService;

public class BorrowController {

    private IBorrowService borrowSerevice;

    public BorrowController() {
        this.borrowSerevice = new BorrowService();
    }


}
