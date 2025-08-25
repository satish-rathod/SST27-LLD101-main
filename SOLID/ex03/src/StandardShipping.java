public class StandardShipping implements ShippingCostStrategy {
    public double calculate(Shipment shipment) {
        return 50 + 5 * shipment.getWeightKg();
    }
}
