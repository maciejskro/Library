package pl.sda.library.model;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pl.sda.library.entity.Author;
import pl.sda.library.entity.Borrow;
import pl.sda.library.entity.Borrower;
import pl.sda.library.model.helper.TestEntityGenerator;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BorrowRepositoryTest {

    private BorrowRepository borrowRepository;
    private TestEntityGenerator testEntityGenerator;
    private Borrow borrow;
    @Before
    public void setUp() throws Exception {
        this.borrowRepository = new BorrowRepository();
        this.testEntityGenerator = new TestEntityGenerator();
        this.borrow = testEntityGenerator.getBorrow();
    }

    @Test
    public void t01_getBorrow() {
        borrowRepository.getBorrow(testEntityGenerator.getBook(), testEntityGenerator.getBorrower());

    }

    @Test
    public void t05_getGiveBack() {
    }

    @Test
    public void t03_findAllBorrow() {

    }
    @After
    public void cleanAllBorrowCollection() {
        borrowRepository.getDatastore()
                .delete(borrowRepository.getDatastore().createQuery(Borrow.class));
    }

}