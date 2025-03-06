package design_pattern.decorator_pattern;

public class Milk extends CoffeeDecorator{
    public Milk (Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return super.getDescription() + ", Milk";
    }

    public double getCost() {
        return super.getCost() + 10.00; // Extgra cost for Milk
    }
}
