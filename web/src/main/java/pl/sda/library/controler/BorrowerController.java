package pl.sda.library.controler;

import pl.sda.library.model.BorrowerService;
import pl.sda.library.model.IBorrowerService;

public class BorrowerController {

    private IBorrowerService borrowerService;

    public BorrowerController() { this.borrowerService = new BorrowerService();  }


}
