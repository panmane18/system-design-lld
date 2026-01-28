package vending_machine;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private VendingMachineState currentState;
    private final InventoryManager inventoryManager;
    private final PaymentProcessor paymentProcessor;
    private Transaction currentTransaction;
    private final List<Transaction> transactionHistory;

    public VendingMachine() {
        this.inventoryManager = new InventoryManager();
        this.paymentProcessor = new PaymentProcessor();
        this.transactionHistory = new ArrayList<>();
        this.currentTransaction = new Transaction();
        this.currentState = new NoMoneyInsertedState();
    }

    public void setState(VendingMachineState state) {
        this.currentState = state;
    }

    public void insertMoney(double amount) {
        currentState.insertMoney(this, amount);
    }

    public void selectProduct(String rackCode) {
        currentState.selectProductByCode(this, rackCode);
    }

    public void dispenseProduct() {
        currentState.dispenseProduct(this);
    }

    public void resetTransaction() {
        transactionHistory.add(currentTransaction);
        currentTransaction = new Transaction();
    }

    public InventoryManager getInventoryManager() {
        return inventoryManager;
    }

    public PaymentProcessor getPaymentProcessor() {
        return paymentProcessor;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }
}
