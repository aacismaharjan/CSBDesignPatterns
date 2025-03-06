package decorator_pattern;

public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + " -> Rs. " + coffee.getCost());

        coffee = new Milk(coffee);
        System.out.println(coffee.getDescription() + " -> Rs. " + coffee.getCost());

        coffee = new Sugar(coffee);
        System.out.println(coffee.getDescription() + " -> Rs. " + coffee.getCost());
    }
}
