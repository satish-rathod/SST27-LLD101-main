public class Demo03 {
    public static void main(String[] args) {
    Shipment shipment1 = new Shipment(5.0);
    Shipment shipment2 = new Shipment(2.0);
    Shipment shipment3 = new Shipment(1.0);

    ShippingCostCalculator standardCalculator = new ShippingCostCalculator(new StandardShipping());
    ShippingCostCalculator expressCalculator = new ShippingCostCalculator(new ExpressShipping());
    ShippingCostCalculator overnightCalculator = new ShippingCostCalculator(new OvernightShipping());

    System.out.println("Standard shipping cost: " + standardCalculator.calculateShippingCost(shipment1));
    System.out.println("Express shipping cost: " + expressCalculator.calculateShippingCost(shipment2));
    System.out.println("Overnight shipping cost: " + overnightCalculator.calculateShippingCost(shipment3));
    }
}
