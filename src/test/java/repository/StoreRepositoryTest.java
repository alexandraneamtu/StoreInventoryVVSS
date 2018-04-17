package repository;

import com.sun.jmx.mbeanserver.Repository;
import junit.framework.TestCase;
import model.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class StoreRepositoryTest extends TestCase {

    StoreRepository repository;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        repository = new StoreRepository();
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


    @Test
    public void testGetProductsCategoryP2() throws IOException{
        StoreRepository repository2 = new StoreRepository();
        assertEquals(0,repository2.getAllProducts().size());
        repository2.addNewProduct(new Product(55,"ciocolata1","aliment1",2));
        repository2.addNewProduct(new Product(56,"ciocolata2","aliment2",2));
        repository2.addNewProduct(new Product(57,"ciocolata3","aliment3",2));
        assertEquals(3,repository2.getAllProducts().size());
        ArrayList<Product> product =repository2.getProductsCategory("aliment2");
        assertEquals(1,product.size());
    }

    @Test
    public void testGetProductsCategoryP1() throws IOException{
        StoreRepository repository2 = new StoreRepository();
        assertEquals(0,repository2.getAllProducts().size());
        ArrayList<Product> product =repository2.getProductsCategory("cioco");
        assertEquals(0,product.size());
    }

}