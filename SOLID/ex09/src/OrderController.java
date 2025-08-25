public class OrderController {
    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void create(String id) {
        orderRepository.saveOrder(id);
        System.out.println("Created order: " + id);
    }
}