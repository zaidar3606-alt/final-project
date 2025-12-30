/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        manager.loadFromFile();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n====== Inventory Management System ======");
            System.out.println("1. Add Product      2. View All Data    3. Update Product");
            System.out.println("4. Delete Product   5. Search Product   6. Add Supplier");
            System.out.println("7. Place Order      8. Save Data        9. Exit");
            System.out.print("Enter choice: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1 -> {
                        String id = getValidProductID(sc, "Enter ID (1-50): ");
                        System.out.print("Name: "); String name = sc.nextLine();
                        System.out.print("Price: "); double price = Double.parseDouble(sc.nextLine());
                        System.out.print("Qty: "); int qty = Integer.parseInt(sc.nextLine());
                        System.out.print("Perishable? (y/n): ");
                        if (sc.nextLine().equalsIgnoreCase("y")) {
                            System.out.print("Expiry (YYYY-MM-DD): ");
                            manager.addProduct(new PerishableProduct(id, name, price, qty, sc.nextLine()));
                        } else manager.addProduct(new Product(id, name, price, qty));
                    }
                    case 2 -> manager.viewAll();
                    case 3 -> {
                        String id = getValidProductID(sc, "Update ID: ");
                        System.out.print("New Price: "); double p = Double.parseDouble(sc.nextLine());
                        System.out.print("New Qty: "); int q = Integer.parseInt(sc.nextLine());
                        manager.updateProduct(id, p, q);
                    }
                    case 4 -> manager.deleteProduct(getValidProductID(sc, "Delete ID: "));
                    case 5 -> System.out.println(manager.findProduct(getValidProductID(sc, "Search ID: ")));
                    case 6 -> {
                        System.out.print("Sup ID: "); String sid = sc.nextLine();
                        System.out.print("Sup Name: "); String sn = sc.nextLine();
                        System.out.print("Contact: "); String scon = sc.nextLine();
                        manager.addSupplier(new Supplier(sid, sn, scon));
                    }
                    case 7 -> {
                        System.out.print("Order ID: "); String oid = sc.nextLine();
                        String pid = getValidProductID(sc, "Product ID: ");
                        System.out.print("Supplier ID: "); String sid = sc.nextLine();
                        System.out.print("Order Qty: "); int oq = Integer.parseInt(sc.nextLine());
                        manager.addOrder(new Order(oid, pid, sid, oq));
                    }
                    case 8 -> manager.saveToFile();
                    case 9 -> { manager.saveToFile(); System.exit(0); }
                    default -> System.out.println("Invalid Choice.");
                }
            } catch (Exception e) { System.err.println("Error: " + e.getMessage()); }
        }
    }

    // FIXED: No longer throws UnsupportedOperationException
    private static String getValidProductID(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int id = Integer.parseInt(sc.nextLine());
                if (id >= 1 && id <= 50) return String.valueOf(id);
                else System.out.println("Must be 1-50.");
            } catch (Exception e) { System.out.println("Enter a valid number."); }
        }
    }
}

class InvalidProductException extends Exception { public InvalidProductException(String m) { super(m); } }