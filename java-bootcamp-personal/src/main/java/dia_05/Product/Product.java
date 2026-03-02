package dia_05.Product;

public class Product {
    private String name;
    private double price;
    private int stock;
    private String category;

    //
    public Product(String name, double price, int stock, String category) {
        setName(name);
        setPrice(price);
        setStock(stock);
        this.category = category;
    }

    public Product(String name, double price, String category) {
        this(name, price, 0, category);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name != null && !name.isBlank()){
            this.name = name;
        }else{
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price > 0){
            this.price = price;
        }else {
            throw new IllegalArgumentException("Price cannot be 0 or negative");
        }
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if(stock >=  0){
            this.stock = stock;
        }else{
            throw new IllegalArgumentException("Stock cannot be negative");
        }
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isAvailable(){
        return stock > 0;
    }

    public void sell (int quantity){
        if(quantity <= 0){
            throw  new IllegalArgumentException("Quantity cannot be 0 or negative");
        }
        if(quantity > stock){
            throw  new IllegalArgumentException("Quantity cannot be greater than stock");
        }
        stock -= quantity;
    }

    public void restock (int quantity){
        if(quantity <= 0){
            throw new IllegalArgumentException("Restock quantity must be positive");
        }

        stock += quantity;
    }

    public double getTotalValue(){
        return price * stock;
    }

    public void displayInfo(){
        System.out.println("\nName: " + name);
        System.out.println("Price: " + price);
        System.out.println("Stock: " + stock);
        System.out.println("Category: " + category);
        System.out.println("Total Value: " + getTotalValue());
    }

}
