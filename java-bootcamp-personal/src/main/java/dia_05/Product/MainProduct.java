package dia_05.Product;

import java.util.ArrayList;

public class MainProduct {
    public static void main(String[] args){

        ArrayList<Product> products = new ArrayList<>();

        Product objProduct1 = new Product("Water",1000,10,"Drink");
        Product objProduct2 = new Product("Tomato",700,3,"Vegetable");
        Product objProduct3 = new Product("Potato",500,5,"Vegetable");
        Product objProduct4 = new Product("lemon",400,"Vegetable");

        products.add(objProduct1);
        products.add(objProduct2);
        products.add(objProduct3);
        products.add(new Product("Water 2",1100,10,"Drink"));

        System.out.println("Products available:");
        for(Product p : products){
            if(p.isAvailable()){
                System.out.println("Product " + p.getName() + " is available");
            }
        }

        System.out.println("Restock: ");
        objProduct4.restock(19);
        System.out.println("\nProduct " + objProduct4.getName() + " is stocked (" + objProduct4.getStock() +")");

        System.out.println("Sell: ");
        objProduct4.sell(9);
        System.out.println("\nProduct " + objProduct4.getName() + " is stocked (" + objProduct4.getStock() +")");

        System.out.println("\n----- Information products -----");
        for(Product p : products){
            p.displayInfo();
        }

        System.out.println();
        for (Product p : products){
            if(p.isAvailable()){
                System.out.println("Product " + p.getName() + "\n"
                + "Total value: " + p.getTotalValue() + "\n");
            }
        }
    }
}
