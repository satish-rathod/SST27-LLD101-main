public class OvernightShipping implements ShippingCostStrategy {
    public double calculate(Shipment shipment) {
        return 120 + 10 * shipment.getWeightKg();
    }
}
