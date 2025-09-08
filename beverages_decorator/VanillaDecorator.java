public class VanillaDecorator extends Beverage {
    private Beverage beverage;

    public VanillaDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Vanilla";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.4; // Add vanilla cost
    }
}
