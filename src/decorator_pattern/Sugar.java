package decorator_pattern;

public class Sugar extends CoffeeDecorator{
    public Sugar(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return super.getDescription() + ", Sugar";
    }

    public double getCost() {
        return super.getCost() + 5.0; // Extra cost for Sugar
    }
}
