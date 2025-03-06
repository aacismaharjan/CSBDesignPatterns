package design_pattern.decorator_pattern;

public class SimpleCoffee implements  Coffee{
    public String getDescription() {
        return "Plain Coffee";
    }

    public double getCost() {
        return 50.0;
    }
}
