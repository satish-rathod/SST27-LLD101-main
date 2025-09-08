package beverages_decorator;

public class Client {

	public static void main(String[] args) {
		

		
		Beverage coffee = new Cappuccino();
        System.out.println("Coffee");
		System.out.println("normal Cappuccino Coffee: " + coffee.cost());

		coffee = new ChocolateDecorator(coffee);
		System.out.println("Coffee with Chocolate: " + coffee.getDescription() + ", Cost: " + coffee.cost());

		coffee = new ChocolateDecorator(coffee);
		System.out.println("Coffee with more Chocolate: " + coffee.getDescription() + ", Cost: " + coffee.cost());

		Beverage vanillaCappuccino = new VanillaDecorator(new Cappuccino());
		System.out.println("Cappuccino with Vanilla: " + vanillaCappuccino.getDescription() + ", Cost: " + vanillaCappuccino.cost());

		Beverage fancyLatte = new WhippedCreamDecorator(new VanillaDecorator(new Latte()));
		System.out.println("Latte with Vanilla and Whipped Cream: " + fancyLatte.getDescription() + ", Cost: " + fancyLatte.cost());

		Beverage superDeluxe = new WhippedCreamDecorator(new ChocolateDecorator(new VanillaDecorator(new Cappuccino())));
		System.out.println("Cappuccino with Vanilla, Chocolate, and Whipped Cream: " + superDeluxe.getDescription() + ", Cost: " + superDeluxe.cost());

	}

}s