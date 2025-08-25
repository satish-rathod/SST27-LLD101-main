public class WalletPayment implements PaymentProvider {
    public String pay(double amount) {
        return "Wallet debit: " + amount;
    }
}
