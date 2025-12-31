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

public class ProductTest {

    @Test
    public void testValidProductCreation() {
        try {
            Product p = new Product("P001", "Apple", 0.99, 100);
            assertEquals("P001", p.getProductID());
            assertEquals("Apple", p.getName());
            assertEquals(0.99, p.getPrice(), 0.001);
        } catch (InvalidProductException e) {
            fail("Valid product should not throw exception.");
        }
    }

    @Test(expected = InvalidProductException.class)
    public void testInvalidProductPrice() throws InvalidProductException {
        // This should trigger the exception because price is negative
        new Product("P002", "Bad Apple", -5.00, 10);
    }
}


