
public class PaymentService {
    public String pay(PaymentProvider provider, double amount) {
        return provider.pay(amount);
    }
}