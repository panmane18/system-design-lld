package vending_machine;

public class Transaction {
    private Product product;
    private Rack rack;

    public Product getProduct() {
        return product;
    }

    public Rack getRack() {
        return rack;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setRack(Rack rack) {
        this.rack = rack;
    }
}
