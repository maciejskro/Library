package pl.sda.library.model;

import pl.sda.library.entity.Borrow;

import java.util.List;

public class BorrowService implements IBorrowService {

    private IBorrowRepository borrowRepository;

    public BorrowService() {
        this.borrowRepository = new BorrowRepository();
    }
    @Override
    public void save(Borrow borrow) {

    }

    @Override
    public List<Borrow> findAll() {
        return null;
    }

    @Override
    public Borrow findByName(String name) {
        return null;
    }

    @Override
    public void remove(Borrow borrow) {

    }
}
