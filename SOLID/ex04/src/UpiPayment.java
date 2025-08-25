public class UpiPayment implements PaymentProvider {
    public String pay(double amount) {
        return "Paid via UPI: " + amount;
    }
}
