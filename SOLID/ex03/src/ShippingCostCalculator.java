public class ShippingCostCalculator {
    private ShippingCostStrategy strategy;

    public ShippingCostCalculator(ShippingCostStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculateShippingCost(Shipment shipment) {
        return strategy.calculate(shipment);
    }
}
