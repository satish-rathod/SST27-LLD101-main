public class OrderService {
    private final double taxRate = 0.18;
    private final EmailSender emailSender;

    public OrderService(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    double totalWithTax(double subtotal) {
        return subtotal + subtotal * taxRate;
    }

    void checkout(String customerEmail, double subtotal) {
        double total = totalWithTax(subtotal);
        emailSender.send(customerEmail, "Thanks! Your total is " + total);
        System.out.println("Order stored (pretend DB).");
    }
}