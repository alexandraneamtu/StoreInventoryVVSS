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

    @Test
    public void testAddTestCase3() throws IOException {
        assertEquals(0,repository.getAllProducts().size());
        repository.addNewProduct(new Product(5,"ciocolata","aliment",Integer.MAX_VALUE +1));
        assertEquals(0,repository.getAllProducts().size());

    }

    @Test
    public void testAddTestCase4() throws IOException {
        assertEquals(0,repository.getAllProducts().size());
        repository.addNewProduct(new Product(5,"","aliment",7));
        assertEquals(0,repository.getAllProducts().size());

    }

    @Test
    public void testAddTestCase5() throws IOException {
        assertEquals(0,repository.getAllProducts().size());
        repository.addNewProduct(new Product(5,"ciocolata","",7));
        assertEquals(0,repository.getAllProducts().size());

    }


    @Test
    public void testAddTestCase6() throws IOException {
        assertEquals(0,repository.getAllProducts().size());
        repository.addNewProduct(new Product(5,"ciocolata","aliment",7));
        assertEquals(1,repository.getAllProducts().size());
        repository.addNewProduct(new Product(5,"ciocolata","aliment",7));
        assertEquals(1,repository.getAllProducts().size());
    }

    @Test
    public void testAddTestCase7() throws IOException {
        assertEquals(0,repository.getAllProducts().size());
        repository.addNewProduct(new Product(5,"ciocolata","aliment",-3));
        assertEquals(0,repository.getAllProducts().size());
    }


    @Test
    public void testAddTestCase8() throws IOException {
        assertEquals(0,repository.getAllProducts().size());
        repository.addNewProduct(new Product(0,"ciocolata","aliment",2));
        assertEquals(0,repository.getAllProducts().size());
    }

    @Test
    public void testAddTestCase9() throws IOException {
        assertEquals(0,repository.getAllProducts().size());
        repository.addNewProduct(new Product(5,"ciocolata","aliment",0));
        assertEquals(0,repository.getAllProducts().size());
    }

    @Test
    public void testAddTestCase10() throws IOException {
        assertEquals(0,repository.getAllProducts().size());
        repository.addNewProduct(new Product(5,"ciocolata","aliment",5));
        assertEquals(1,repository.getAllProducts().size());
    }

    @Test
    public void testAddTestCase11() throws IOException {
        assertEquals(0,repository.getAllProducts().size());
        repository.addNewProduct(new Product(5,"ciocolata","aliment",7));
        assertEquals(1,repository.getAllProducts().size());
        repository.addNewProduct(new Product(7,"ciocolata","aliment",3));
        assertEquals(2,repository.getAllProducts().size());
    }

    @Test
    public void testAddTestCase12() throws IOException {
        assertEquals(0,repository.getAllProducts().size());
        repository.addNewProduct(new Product(Integer.MAX_VALUE,"c","a",Integer.MAX_VALUE));
        assertEquals(1,repository.getAllProducts().size());
    }

    @Test
    public void testAddTestCase13() throws IOException {
        assertEquals(0,repository.getAllProducts().size());
        repository.addNewProduct(new Product(1,"ciocolata","aliment",1));
        assertEquals(1,repository.getAllProducts().size());
    }

    @Test
    public void testAddTestCase14() throws IOException {
        assertEquals(0,repository.getAllProducts().size());
        repository.addNewProduct(new Product(Integer.MAX_VALUE-1,"ciocolata","aliment",Integer.MAX_VALUE-1));
        assertEquals(1,repository.getAllProducts().size());
    }

    @Test
    public void testAddTestCase15() throws IOException {
        assertEquals(0,repository.getAllProducts().size());
        repository.addNewProduct(new Product(5,"ciocolata","aliment",2));
        assertEquals(1,repository.getAllProducts().size());
    }








    public void testGetProductsCategory() {
    }

    public void testStockSituationProduct() {
    }

    public void testStockSituation() {
    }
}