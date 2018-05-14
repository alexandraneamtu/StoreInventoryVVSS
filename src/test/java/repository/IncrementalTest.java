package repository;

import junit.framework.TestCase;
import model.Product;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;


public class IncrementalTest extends TestCase{

    StoreRepository repository;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        repository = new StoreRepository();
    }


    @Test
    public void testRequirementA() throws IOException {
        assertEquals(0,repository.getAllProducts().size());
        repository.addNewProduct(new Product(5,"carne","aliment",7));
        assertEquals(1,repository.getAllProducts().size());
        repository.addNewProduct(new Product(7,"carne","aliment",3));
        assertEquals(2,repository.getAllProducts().size());
    }


    @Test
    public void testRequirementsAandB() throws IOException{
        StoreRepository repository2 = new StoreRepository();
        assertEquals(0,repository2.getAllProducts().size());
        repository2.addNewProduct(new Product(55,"carne1","aliment1",2));
        repository2.addNewProduct(new Product(56,"carne2","aliment2",2));
        repository2.addNewProduct(new Product(57,"carne3","aliment3",2));
        assertEquals(3,repository2.getAllProducts().size());
        ArrayList<Product> product =repository2.getProductsCategory("aliment2");
        assertEquals(1,product.size());
    }


    @Test
    public void testRequirementsAandBandC() throws IOException{
        StoreRepository repository5 = new StoreRepository();
        assertEquals(0,repository5.getAllProducts().size());
        repository5.addNewProduct(new Product(65,"carne1","aliment1",2));
        repository5.addNewProduct(new Product(66,"carne2","aliment2",2));
        repository5.addNewProduct(new Product(67,"carne3","aliment3",2));
        assertEquals(3,repository5.getAllProducts().size());
        ArrayList<Product> product2 = repository5.getProductsCategory("aliment2");
        assertEquals(1,product2.size());
        ArrayList<Product> product =repository5.stockSituationProduct("carne2");
        assertEquals(1,product.size());
        assertEquals(3,repository5.stockSituation().size());
    }

}
