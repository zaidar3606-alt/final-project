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

public class InventoryManagerTest {

    @Test
    public void testAddAndFindProduct() throws Exception {
        InventoryManager manager = new InventoryManager();
        Product p = new Product("P004", "Bread", 1.50, 20);
        
        manager.addProduct(p);
        
        Product found = manager.findProduct("P004");
        assertNotNull("Product should be found", found);
        assertEquals("Bread", found.getName());
    }

    @Test(expected = Exception.class)
    public void testDeleteProduct() throws Exception {
        InventoryManager manager = new InventoryManager();
        Product p = new Product("P005", "Candy", 0.50, 50);
        manager.addProduct(p);
        
        // Delete it
        manager.deleteProduct("P005");
        
        // Trying to find it now should throw an exception
        manager.findProduct("P005");
    }
}
