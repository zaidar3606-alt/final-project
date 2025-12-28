/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.*;
import java.util.*;

public class InventoryManager {
    private List<Product> products = new ArrayList<>();
    private List<Supplier> suppliers = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();
    private final String FILE_NAME = "inventory_data.txt";

    public void addProduct(Product p) { products.add(p); }
    public void addSupplier(Supplier s) { suppliers.add(s); }
    public void addOrder(Order o) { orders.add(o); }

    public void viewAll() {
        System.out.println("\n--- Products ---");
        if (products.isEmpty()) System.out.println("No products.");
        else products.forEach(System.out::println);

        System.out.println("\n--- Suppliers ---");
        if (suppliers.isEmpty()) System.out.println("No suppliers.");
        else suppliers.forEach(System.out::println);

        System.out.println("\n--- Orders ---");
        if (orders.isEmpty()) System.out.println("No orders.");
        else orders.forEach(System.out::println);
    }

    public void updateProduct(String id, double p, int q) throws Exception {
        Product prod = findProduct(id);
        prod.setPrice(p);
        prod.setQuantity(q);
    }

    public void deleteProduct(String id) throws Exception {
        products.remove(findProduct(id));
    }

    public Product findProduct(String id) throws Exception {
        return products.stream().filter(p -> p.getProductID().equals(id)).findFirst()
                .orElseThrow(() -> new Exception("Product not found."));
    }

    public void saveToFile() {
        try (PrintWriter out = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Product p : products) out.println(p.toStorageString());
            for (Supplier s : suppliers) out.println(s.toStorageString());
            for (Order o : orders) out.println(o.toStorageString());
            System.out.println("All data saved to " + FILE_NAME);
        } catch (IOException e) { System.err.println("Save failed."); }
    }

    public void loadFromFile() {
        File f = new File(FILE_NAME);
        if (!f.exists()) return;
        try (Scanner sc = new Scanner(f)) {
            while (sc.hasNextLine()) {
                String[] d = sc.nextLine().split(",");
                switch (d[0]) {
                    case "PRODUCT" -> products.add(new Product(d[1], d[2], Double.parseDouble(d[3]), Integer.parseInt(d[4])));
                    case "PERISHABLE" -> products.add(new PerishableProduct(d[1], d[2], Double.parseDouble(d[3]), Integer.parseInt(d[4]), d[5]));
                    case "SUPPLIER" -> suppliers.add(new Supplier(d[1], d[2], d[3]));
                    case "ORDER" -> orders.add(new Order(d[1], d[2], d[3], Integer.parseInt(d[4])));
                }
            }
        } catch (Exception e) { System.out.println("Loaded existing data."); }
    }

    void viewProducts() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
