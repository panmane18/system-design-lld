package vending_machine;

public class Rack {
    private final String rackCode;
    private final Product product;
    private int count;

    public Rack(String rackCode, Product product, int count) {
        this.rackCode = rackCode;
        this.product = product;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public Product getProduct() {
        return product;
    }

    public String getRackCode() {
        return rackCode;
    }

    public void decrementProduct() {
        if (count <= 0) {
            throw new IllegalStateException("Rack is empty");
        }
        count--;
    }
}
