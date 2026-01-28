package vending_machine;

public interface VendingMachineState {

    void insertMoney(VendingMachine vm, double amount);

    void selectProductByCode(VendingMachine vm, String productCode);

    void dispenseProduct(VendingMachine vm);

    String getStateDescription();
}
