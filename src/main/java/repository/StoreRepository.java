package repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import model.Product;

public class StoreRepository {

	private ArrayList<Product> allProducts=new ArrayList<Product>();
	public ArrayList<Product> getAllProducts() {
	    return allProducts;
	}

	public void readFile(String fname) throws NumberFormatException, IOException{
		FileInputStream f = new FileInputStream(fname);
		DataInputStream in = new DataInputStream(f);
		BufferedReader buf =new BufferedReader(new InputStreamReader(in));
		String rd;
		String[] line;
		while((rd = buf.readLine()) != null ){
				line=rd.split(" ");
				this.allProducts.add(new Product(Integer.parseInt(line[0]),line[1],line[2],Integer.parseInt(line[3])));
		}
		in.close();
	}


	public String addNewProduct(Product p) throws IOException{
		if(     p.getCode() > 0 &&
                p.getQuantity() > 0 &&
                !illegal(p.getName()) &&
                p.getName().length() != 0 &&
                p.getCategory().length() != 0)
		{

			BufferedWriter out = new BufferedWriter(new FileWriter("products.txt",true));

			if(!findCode(p.getCode())){
				out.newLine();
				out.write(p.getCode()+" "+p.getName()+" "+p.getCategory()+" "+p.getQuantity());
				out.close();
				allProducts.add(p);
			}
			else{
				System.err.println("This code already exists");
				out.close();
				return("This code already exists");
			}
		}
		else{
		    System.err.println("Invalid product");
			return("code q");
		}

		System.out.println("Product added");
		return("success");
	}

	private boolean findCode(int code){
        for(Product i: allProducts)
            if(i.getCode()== code)
                return true;
        return false;
    }

	private boolean illegal(String name) {
		char c;
		for(int i=0;i<name.length();++i) {
			c = name.charAt(i);
			if (!((c <= 'z' && c >= 'a') || (c <= 'Z' && c >= 'A')|| (c <= '9' && c >= '1')))
				return true;
		}
		return false;
	}

	public ArrayList<Product> getProductsCategory(String cat){
		ArrayList<Product> cProducts=new ArrayList<Product>();
		for(Product p:allProducts){
			if(p.getCategory().compareTo(cat) == 0){
				cProducts.add(p);
			}
		}
		return cProducts;
	}
	
	public ArrayList<Product> stockSituationProduct(String pname){
		ArrayList<Product> prods=new ArrayList<Product>();
		for(Product p:allProducts)
			if(p.getName().equals(pname))
				prods.add(p);
		return prods;
	}


	public ArrayList<Product> stockSituation() {
		return allProducts;
	}
	
}
