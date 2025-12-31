/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Acer
 */

    
import org.junit.Test;
import static org.junit.Assert.*;

public class OrderTest {

    @Test
    public void testOrderCreation() {
        // Create an order: ID "O100", Product "P001", Supplier "S99", Qty 50
        Order order = new Order("O100", "P001", "S99", 50);
        
        // Verify the storage string format matches what saveToFile() needs
        // Expected format: ORDER,OrderID,ProductID,SupplierID,Quantity
        String expected = "ORDER,O100,P001,S99,50";
        assertEquals(expected, order.toStorageString());
    }

    @Test
    public void testOrderToString() {
        Order order = new Order("O200", "P002", "S98", 10);
        String display = order.toString();
        
        // Verify the display string contains the key details
        assertTrue(display.contains("O200"));
        assertTrue(display.contains("10"));
    }
}
