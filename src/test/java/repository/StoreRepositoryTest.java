package repository;

import com.sun.jmx.mbeanserver.Repository;
import junit.framework.TestCase;
import model.Product;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class StoreRepositoryTest extends TestCase {

    StoreRepository repository;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        repository = new StoreRepository();
    }

    public void testGetAllProducts() {
    }

    public void testReadFile() {
    }

    public void testAddNewProduct() throws IOException {
        assertEquals(0,repository.getAllProducts().size());
        repository.addNewProduct(new Product(2,"ciocolata","aliment",4));
        assertEquals(1,repository.getAllProducts().size());
    }

    @Test
    public void testAddProductCase1() throws IOException {
        assertEquals(0,repository.getAllProducts().size());
        repository.addNewProduct(new Product(-1,"ciocolata","aliment",5));
        assertEquals(0,repository.getAllProducts().size());

    }


    @Test
    public void testAddTestCase2() throws IOException {
        assertEquals(0,repository.getAllProducts().size());
        repository.addNewProduct(new Product(Integer.MAX_VALUE +1,"ciocolata","aliment",5));
        assertEquals(0,repository.getAllProducts().size());

    }

    public void testGetProductsCategory() {
    }

    public void testStockSituationProduct() {
    }

    public void testStockSituation() {
    }
}