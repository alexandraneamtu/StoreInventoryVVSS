package repository;

import com.sun.jmx.mbeanserver.Repository;
import junit.framework.TestCase;
import model.Product;

import java.io.IOException;

public class StoreRepositoryTest extends TestCase {

    StoreRepository repository;

    public void setUp() throws Exception {
        super.setUp();
        repository = new StoreRepository();
    }

    public void testGetAllProducts() {
    }

    public void testReadFile() {
    }

    public void testAddNewProduct() throws IOException {
        assertTrue(repository.getAllProducts().size()==0);
        repository.addNewProduct(new Product(3,"ciocolata","aliment",4));
        assertTrue(repository.getAllProducts().size()==1);
    }

    public void testGetProductsCategory() {
    }

    public void testStockSituationProduct() {
    }

    public void testStockSituation() {
    }
}