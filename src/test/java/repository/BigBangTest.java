package repository;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import junit.framework.TestCase;
import model.Product;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class BigBangTest extends TestCase {

    StoreRepository repository;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        repository = new StoreRepository();
    }


    @Test
    public void testRequirementA() throws IOException {
        assertEquals(0,repository.getAllProducts().size());
        repository.addNewProduct(new Product(5,"paine","aliment",7));
        assertEquals(1,repository.getAllProducts().size());
        repository.addNewProduct(new Product(7,"paine","aliment",3));
        assertEquals(2,repository.getAllProducts().size());
    }


    @Test
    public void testRequirementB() throws IOException{
        StoreRepository repository2 = new StoreRepository();
        assertEquals(0,repository2.getAllProducts().size());
        repository2.addNewProduct(new Product(55,"paine1","aliment1",2));
        repository2.addNewProduct(new Product(56,"paine2","aliment2",2));
        repository2.addNewProduct(new Product(57,"paine3","aliment3",2));
        assertEquals(3,repository2.getAllProducts().size());
        ArrayList<Product> product =repository2.getProductsCategory("aliment2");
        assertEquals(1,product.size());
    }


    public void testRequirementC1() throws IOException{
        StoreRepository repository4 = new StoreRepository();
        repository4.addNewProduct(new Product(75,"paine1","aliment1",2));
        assertEquals(1,repository4.stockSituation().size());


    }

    @Test
    public void testRequirementC2() throws IOException{
        StoreRepository repository3 = new StoreRepository();
        assertEquals(0,repository3.getAllProducts().size());
        repository3.addNewProduct(new Product(65,"carne1","aliment1",2));
        repository3.addNewProduct(new Product(66,"carne2","aliment2",2));
        repository3.addNewProduct(new Product(67,"carne3","aliment3",2));
        assertEquals(3,repository3.getAllProducts().size());
        ArrayList<Product> product =repository3.stockSituationProduct("carne2");
        assertEquals(1,product.size());
    }


    @Test
    public void testBigBang() throws IOException{
        StoreRepository repository5 = new StoreRepository();
        assertEquals(0,repository5.getAllProducts().size());
        repository5.addNewProduct(new Product(65,"ou1","aliment1",2));
        repository5.addNewProduct(new Product(66,"ou2","aliment2",2));
        repository5.addNewProduct(new Product(67,"ou3","aliment3",2));
        assertEquals(3,repository5.getAllProducts().size());
        ArrayList<Product> product =repository5.stockSituationProduct("ou2");
        assertEquals(1,product.size());
        ArrayList<Product> product2 = repository5.getProductsCategory("aliment2");
        assertEquals(1,product.size());
        assertEquals(3,repository5.stockSituation().size());
    }
}
