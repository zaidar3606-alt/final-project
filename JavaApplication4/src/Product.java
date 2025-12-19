/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Acer
 */

    public class Product implements Storable {
    private String productID;
    private String name;
    private double price;
    private int quantity;

    public Product(String productID, String name, double price, int quantity) throws InvalidProductException {
        if (price < 0 || quantity < 0) throw new InvalidProductException("Price/Quantity cannot be negative.");
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductID() { return productID; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public void setPrice(double price) { this.price = price; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public String toStorageString() {
        return "PRODUCT," + productID + "," + name + "," + price + "," + quantity;
    }

    @Override
    public String toString() {
        return String.format("| ID: %-4s | Name: %-15s | Price: $%-8.2f | Qty: %-4d |", productID, name, price, quantity);
    }
}
    



