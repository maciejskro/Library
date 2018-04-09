package pl.sda.library.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.sda.library.entity.Borrower;

import java.util.List;

public class BorrowerService implements IBorrowerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BorrowerService.class);
    private IBorrowerRepository borrowerRepository;


    public BorrowerService() {
        this.borrowerRepository = new BorrowerRepository();
    }

    @Override
    public void save(Borrower author) {
        borrowerRepository.save(author);
        LOGGER.info("borrower saved" + author.toString());
    }

    @Override
    public List<Borrower> findAll() {
        return borrowerRepository.findAll();
    }

    @Override
    public Borrower find(String... names) {
        return null;
    }


    @Override
    public void remove(Borrower author) {
        borrowerRepository.remove(author);
        LOGGER.info("remover borrower" + author.toString());
    }
}
