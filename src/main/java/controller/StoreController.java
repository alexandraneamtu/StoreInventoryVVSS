package controller;

import java.io.IOException;
import java.util.ArrayList;

import repository.StoreRepository;
import model.Product;

public class StoreController {

	StoreRepository repository =new StoreRepository();
	public void readProducts(String f){
		try {
			repository.readFile(f);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void addProduct(Product p){
		try {
			repository.addNewProduct(p);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public ArrayList<Product> getProductsCategory(String cat){
		return repository.getProductsCategory(cat);
	}
	
	public ArrayList<Product> stockSituationProduct(String pname){
		return repository.stockSituationProduct(pname);
	}

	public ArrayList<Product> stockSituation(){
		return repository.stockSituation();
	}
}
