package pl.sda.library.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.sda.library.entity.Borrower;

import java.util.List;

public class BorrowerService implements IBorrowerService {

    private IBorrowerRepository borrowerRepository;

    private static final Logger logger = LoggerFactory.getLogger(BorrowerService.class);
    public BorrowerService() {
        this.borrowerRepository = new BorrowerRepository();
    }

    @Override
    public void save(Borrower author) {
        borrowerRepository.save(author);
        logger.info("borrower saved" + author.toString());
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
        logger.info("remover borrower" + author.toString());
    }
}
