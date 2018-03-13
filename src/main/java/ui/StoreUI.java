package ui;

import controller.StoreController;
import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Vlad on 17-Mar-16.
 */
public class StoreUI {
    public StoreController ctrl;
    Scanner in;

    public StoreUI(StoreController ctrl){
        this.ctrl=ctrl;
        this.in=new Scanner(System.in);
    }

    public void printMenu() {
        String menu;
        menu = "These are the available commands:\n";
        menu += "\t 1 - Add new product \n";
        menu += "\t 2 - Display all products from a category\n";
        menu += "\t 3 - Stock situation for all products \n";
        menu += "\t 4 - Stock situation for a product \n";
        menu += "\t 0 - Exit \n";
        System.out.println(menu);
    }

    public void addNewProduct()
    {
        System.out.println("Give the Product code:");
        int pCode = Integer.parseInt(in.nextLine());

        System.out.println("Give the product name:");
        String pName = in.nextLine();

        System.out.println("Give the product category:");
        String pCategory = in.nextLine();

        System.out.println("Give the quantity:");
        int pQunatity = Integer.parseInt(in.nextLine());

        Product p = new Product(pCode,pName,pCategory,pQunatity);
        ctrl.addProduct(p);
    }

    public void displayCategory()
    {
        System.out.println("Give category");
        String cat=in.nextLine();
        List<Product> temp = ctrl.getProductsCategory(cat);

        if(temp.size() != 0)
            for (Product p : temp)
                System.out.println(p.toString());
        else
            System.out.println("No product from the given category!\n");

    }

    public void displayStock()
    {

        ArrayList<Product> temp = ctrl.stockSituation();

        if(temp.size() != 0)
            for (Product p : temp)
                System.out.println(p.toString());

        else
            System.out.println("No products!\n");

    }

    public void displayStockFor()
    {
        System.out.println("Give product name");
        String cat=in.nextLine();
        ArrayList<Product> temp = ctrl.stockSituationProduct(cat);

        if(temp.size() != 0)
            for (Product p : temp) {
                System.out.println(p.toString());
            }
        else
            System.out.println("No product with the given name!\n");

    }

    public int readCommand() {
        System.out.println("Give a command: ");
        int c = 0;
        c = Integer.parseInt(in.nextLine());
        return c;
    }

    public void executeCommand(int c) {
        switch(c) {
            case 1:
                addNewProduct();
                break;
            case 2:
                displayCategory();
                break;
            case 3:
                displayStock();
                break;
            case 4:
                displayStockFor();
                break;
            default:
                System.out.println("B'bye now!...\n");
                break;
        }
    }

    public void run() {
        int c;
        do {
            printMenu();
            c = readCommand();
            executeCommand(c);
        } while(c != 0);

    }



}
