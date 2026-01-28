package vending_machine;

import java.math.BigDecimal;

public class NoMoneyInsertedState implements VendingMachineState {

    @Override
    public void insertMoney(VendingMachine vm, double amount) {
        vm.getPaymentProcessor().addBalance(BigDecimal.valueOf(amount));
        vm.setState(new MoneyInsertedState());
    }

    @Override
    public void selectProductByCode(VendingMachine vm, String productCode) {
        throw new IllegalStateException("Cannot select product without inserting money.");
    }

    @Override
    public void dispenseProduct(VendingMachine vm) {
        throw new IllegalStateException("No product selected.");
    }

    @Override
    public String getStateDescription() {
        return "No Money Inserted State – Insert money to proceed.";
    }
}
