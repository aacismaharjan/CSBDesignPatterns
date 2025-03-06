package design_pattern.decorator_pattern;

public class CoffeeDecorator implements Coffee{
    protected Coffee coffee;

    public CoffeeDecorator (Coffee coffee) {
        this.coffee = coffee;
    }

    public String getDescription() {
        return coffee.getDescription();
    }

    public double getCost() {
        return coffee.getCost();
    }
}
