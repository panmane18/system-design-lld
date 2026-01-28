package vending_machine;

public class DispenseState implements VendingMachineState {

    @Override
    public void insertMoney(VendingMachine vm, double amount) {
        throw new IllegalStateException("Dispensing in progress");
    }

    @Override
    public void selectProductByCode(VendingMachine vm, String productCode) {
        throw new IllegalStateException("Dispensing in progress");
    }

    @Override
    public void dispenseProduct(VendingMachine vm) {
        Transaction tx = vm.getCurrentTransaction();

        vm.getInventoryManager().dispenseProductFromRack(tx.getRack());
        vm.getPaymentProcessor().charge(tx.getProduct().getUnitPrice());

        System.out.println("Dispensed: " + tx.getProduct().getDescription());
        System.out.println("Change returned: " +
            vm.getPaymentProcessor().returnChange());

        vm.resetTransaction();
        vm.setState(new NoMoneyInsertedState());
    }

    @Override
    public String getStateDescription() {
        return "Dispense State – Dispensing product.";
    }
}
