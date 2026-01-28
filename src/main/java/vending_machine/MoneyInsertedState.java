package vending_machine;

public class MoneyInsertedState implements VendingMachineState {

    @Override
    public void insertMoney(VendingMachine vm, double amount) {
        vm.getPaymentProcessor().addBalance(
            java.math.BigDecimal.valueOf(amount)
        );
    }

    @Override
    public void selectProductByCode(VendingMachine vm, String productCode) {
        Rack rack = vm.getInventoryManager().getRack(productCode);
        if (rack == null) {
            throw new IllegalArgumentException("Invalid product code");
        }

        if (rack.getProductCount() <= 0) {
            throw new IllegalStateException("Product out of stock");
        }

        vm.getCurrentTransaction().setRack(rack);
        vm.getCurrentTransaction().setProduct(rack.getProduct());

        if (vm.getPaymentProcessor()
              .getCurrentBalance()
              .compareTo(rack.getProduct().getUnitPrice()) < 0) {
            throw new IllegalStateException("Insufficient funds");
        }

        vm.setState(new DispenseState());
    }

    @Override
    public void dispenseProduct(VendingMachine vm) {
        throw new IllegalStateException("Select product first");
    }

    @Override
    public String getStateDescription() {
        return "Money Inserted State – Select a product.";
    }
}
