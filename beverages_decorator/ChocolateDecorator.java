public class ChocolateDecorator extends Beverage {
    private Beverage beverage;

    public ChocolateDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Chocolate";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.5; // Add chocolate cost
    }
}
