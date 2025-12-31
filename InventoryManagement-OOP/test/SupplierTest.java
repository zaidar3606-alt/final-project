/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class SupplierTest {

    @Test
    public void testSupplierDetails() {
        Supplier s = new Supplier("S001", "MegaCorp", "555-1234");
        
        assertEquals("S001", s.getSupplierID());
        assertEquals("MegaCorp", s.getName());
    }

    @Test
    public void testSupplierStorageString() {
        Supplier s = new Supplier("S002", "FreshFoods", "bob@mail.com");
        
        // Expected format: SUPPLIER,ID,Name,Contact
        assertEquals("SUPPLIER,S002,FreshFoods,bob@mail.com", s.toStorageString());
    }
}
