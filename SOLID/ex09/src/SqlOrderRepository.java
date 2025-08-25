public class SqlOrderRepository implements OrderRepository {
    @Override
    public void saveOrder(String order) {
        System.out.println("Saved order " + order + " to SQL");
    }
}
