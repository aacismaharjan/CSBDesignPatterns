package factory_pattern;

public class FactoryPatternDemo {
    public static void main(String[] args) {
        // Get Shape objects using the Factory
        Shape shape1 = ShapeFactory.getShape("circle");
        shape1.draw();

        Shape shape2 = ShapeFactory.getShape("rectangle");
        shape2.draw();
    }
}
