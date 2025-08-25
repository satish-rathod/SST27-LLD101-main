public class Demo01 {
    public static void main(String[] args) {
        EmailSender emailSender = new EmailClient();
        OrderService orderService = new OrderService(emailSender);
        orderService.checkout("a@shop.com", 100.0);
    }
}
