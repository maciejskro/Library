package pl.sda.library.model;

import pl.sda.library.entity.Borrower;

import java.util.List;

public class BorrowerService implements IBorrowerService {

    private IBorrowerRepository borrowerRepository;

    public BorrowerService() {
        this.borrowerRepository = new BorrowerRepository();
    }

    @Override
    public void save(Borrower author) {

    }

    @Override
    public List<Borrower> findAll() {
        return null;
    }

    @Override
    public Borrower find(String... names) {
        return null;
    }

    @Override
    public void remove(Borrower author) {

    }
}
