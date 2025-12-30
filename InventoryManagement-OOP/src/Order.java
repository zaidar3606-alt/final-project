/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
public class Order implements Storable {
    private String orderID, productID, supplierID;
    private int qty;

    public Order(String orderID, String productID, String supplierID, int qty) {
        this.orderID = orderID;
        this.productID = productID;
        this.supplierID = supplierID;
        this.qty = qty;
    }

    @Override
    public String toStorageString() {
        return "ORDER," + orderID + "," + productID + "," + supplierID + "," + qty;
    }

    @Override
    public String toString() {
        return String.format("| OID: %-4s | PID: %-4s | SID: %-4s | Ordered Qty: %-4d |", orderID, productID, supplierID, qty);
    }
}

