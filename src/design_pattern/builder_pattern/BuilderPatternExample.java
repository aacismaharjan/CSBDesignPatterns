package design_pattern.builder_pattern;

public class BuilderPatternExample {
    public static void main(String[] args) {
        // Example 1: Creating a simple Product (without extra details)
        Product<Void> phone = new Product.Builder<Void>()
                .setName("Iphone 15")
                .setPrice(1299.99)
                .setCategory("Electronics")
                .build();
        System.out.println(phone);

        // Example 2: Creating a Product with extra details (using a String)
        Product<String> laptop = new Product.Builder<String>()
                .setName("Macbook Pro")
                .setPrice(2499.99)
                .setCategory("Computers")
                .setExtraDetails("M2 Chip, 16GB RAM, 1TB SSD")
                .build();
        System.out.println(laptop);

        // Example 3: Creating a Product with extra details (using a custom class)
        Product<Warranty> tv = new Product.Builder<Warranty>()
                .setName("Samsung OLED TV")
                .setPrice(1999.99)
                .setCategory("Home Appliances")
                .setExtraDetails(new Warranty(3, "Samsung Care"))
                .build();
        System.out.println(tv);
    }
}