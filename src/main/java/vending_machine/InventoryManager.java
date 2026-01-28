package vending_machine;

import java.util.HashMap;
import java.util.Map;

public class InventoryManager {
    private Map<String, Rack> racks = new HashMap<>();

    public void updateRack(Map<String, Rack> racks) {
        this.racks = racks;
    }

    public Rack getRack(String rackCode) {
        return racks.get(rackCode);
    }

    public Product getProductInRack(String rackCode) {
        Rack rack = racks.get(rackCode);
        return rack != null ? rack.getProduct() : null;
    }

    public void dispenseProductFromRack(Rack rack) {
        rack.decrementProduct();
    }
}
