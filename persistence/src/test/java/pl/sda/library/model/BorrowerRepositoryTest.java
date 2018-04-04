package pl.sda.library.model;

import org.junit.*;
import org.junit.runners.MethodSorters;
import pl.sda.library.entity.Borrower;
import pl.sda.library.model.helper.TestEntityGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BorrowerRepositoryTest {
    private BorrowerRepository borrowerRepository;
    private TestEntityGenerator tng;

    @Before
    public void setupClass() {
        tng = new TestEntityGenerator();
        borrowerRepository =  new BorrowerRepository();
    }

    @Test
    public void t01_testSaveAndFindAll() throws Exception {

        borrowerRepository.save(tng.getBorrower());
        Borrower borrower = null;
        List<Borrower> borrowers = borrowerRepository.findAll();
        for (Borrower b : borrowers) {
            if (b.equals(tng.getBorrower())) {
                borrower = b;
            }
        }
        assertThat(borrower).isEqualTo(tng.getBorrower());
    }

    @Test
    public void t05_testFindAll() throws Exception {
        borrowerRepository.save(tng.getBorrower());
        List<Borrower> result = borrowerRepository.findAll();
        assertThat(result.size()).isGreaterThan(0);
    }

    @Test
    public void t10_testFind() throws Exception {
        borrowerRepository.save(tng.getBorrower());
        List<Borrower> listBorrowers = borrowerRepository.findAll();
        Borrower result = borrowerRepository.find(listBorrowers.get(0).getId());
        Assert.assertEquals(listBorrowers.get(0), result);
    }

    @Test
    public void  t99_testRemove() throws Exception {
        borrowerRepository.save(tng.getBorrower());
        Borrower  bb = borrowerRepository.findAll().get(0);
        borrowerRepository.remove(bb);
        assertThat(borrowerRepository.findAll()).isEmpty();
    }
    @After
    public void  cleanBorrowerCollections() {
        borrowerRepository.getDatastore()
                .delete(borrowerRepository.getDatastore().createQuery(Borrower.class));
    }
}
