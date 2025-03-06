package template_pattern;

// Abstract class defining the template
abstract class BeverageTemplate {
    // Template method (final to prevent overriding)
    public final void prepareBeverage() {
        boilWater();
        brew();
        pourInCup();
        if (wantCondiments()) { // Hook method
            addCondiments();
        }
    }

    private void boilWater() {
        System.out.println("Boiling water");
    }

    private void pourInCup() {
        System.out.println("Pouring into cup");
    }

    // Abstract methods to be implemented by subclasses
    protected abstract void brew();
    protected abstract void addCondiments();

    // Hook method (can be overridden to change behavior)
    protected boolean wantCondiments() {
        return true;
    }
}
