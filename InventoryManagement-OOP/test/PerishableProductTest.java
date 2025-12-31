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

public class PerishableProductTest {

    @Test
    public void testPerishableDetails() throws InvalidProductException {
        PerishableProduct pp = new PerishableProduct("P003", "Milk", 2.50, 10, "2025-12-31");
        
        // Check that it kept the expiry date correctly in the toString or storage string
        String storageString = pp.toStorageString();
        
        assertTrue("Should identify as PERISHABLE", storageString.startsWith("PERISHABLE"));
        assertTrue("Should contain the date", storageString.contains("2025-12-31"));
    }
}
