/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Acer
 */
public class Supplier implements Storable {
    private String supplierID, name, contact;

    public Supplier(String supplierID, String name, String contact) {
        this.supplierID = supplierID;
        this.name = name;
        this.contact = contact;
    }

    public String getSupplierID() { return supplierID; }
    public String getName() { return name; }

    @Override
    public String toStorageString() {
        return "SUPPLIER," + supplierID + "," + name + "," + contact;
    }

    @Override
    public String toString() {
        return String.format("| SID: %-4s | Supplier: %-15s | Contact: %-15s |", supplierID, name, contact);
    }
}

    

