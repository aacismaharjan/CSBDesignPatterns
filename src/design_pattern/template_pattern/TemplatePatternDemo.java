package design_pattern.template_pattern;

public class TemplatePatternDemo {
    public static void main(String[] args) {
        System.out.println("Preparing Tea:");
        BeverageTemplate tea = new Tea();
        tea.prepareBeverage();

        System.out.println("\nPreparing Coffee:");
        BeverageTemplate coffee = new Coffee();
        coffee.prepareBeverage();
    }
}
