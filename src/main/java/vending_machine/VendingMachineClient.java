package vending_machine;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class VendingMachineClient {

    public static void main(String[] args) {

        // 1. Create products
        Product coke = new Product("COKE", "Coca Cola", new BigDecimal("25"));
        Product pepsi = new Product("PEPSI", "Pepsi", new BigDecimal("30"));

        // 2. Create racks
        Rack rackA1 = new Rack("A1", coke, 5);
        Rack rackB1 = new Rack("B1", pepsi, 3);

        // 3. Load inventory
        Map<String, Rack> racks = new HashMap<>();
        racks.put("A1", rackA1);
        racks.put("B1", rackB1);

        // 4. Create vending machine
        VendingMachine vm = new VendingMachine();
        vm.getInventoryManager().updateRack(racks);

        // 5. Client interaction (like a real user)
        try {
            System.out.println("=== VENDING MACHINE STARTED ===");

            vm.insertMoney(50);             // insert money
            vm.selectProduct("A1");         // select product
            vm.dispenseProduct();           // dispense

            System.out.println("=== TRANSACTION COMPLETE ===");

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
