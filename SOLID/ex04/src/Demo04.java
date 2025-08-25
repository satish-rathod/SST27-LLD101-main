
public class Demo04 {
    public static void main(String[] args) {
        PaymentService service = new PaymentService();
        System.out.println(service.pay(new UpiPayment(), 499));
        System.out.println(service.pay(new CardPayment(), 1000));
        System.out.println(service.pay(new WalletPayment(), 250));
    }
}
