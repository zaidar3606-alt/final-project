/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
public class PerishableProduct extends Product {
    private String expiryDate;

    public PerishableProduct(String id, String name, double price, int qty, String expiryDate) throws InvalidProductException {
        super(id, name, price, qty);
        this.expiryDate = expiryDate;
    }

    @Override
    public String toStorageString() {
        return "PERISHABLE," + getProductID() + "," + getName() + "," + getPrice() + "," + getQuantity() + "," + expiryDate;
    }

    @Override
    public String toString() {
        return super.toString() + " Expiry: " + expiryDate + " |";
    }
}
    

