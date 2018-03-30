package pl.sda.library.model;

import org.junit.Before;
import org.junit.Test;
import pl.sda.library.entity.Author;
import pl.sda.library.entity.Borrow;
import pl.sda.library.model.helper.TestEntityGenerator;

import static org.junit.Assert.*;

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
    public void getBorrow() {
        borrowRepository.getBorrow(testEntityGenerator.getBook(), testEntityGenerator.getBorrower());
    }

    @Test
    public void getGiveBack() {
    }
}