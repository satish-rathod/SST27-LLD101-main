public class WhippedCreamDecorator extends Beverage {
    private Beverage beverage;

    public WhippedCreamDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whipped Cream";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.6; // Add whipped cream cost
    }
}
