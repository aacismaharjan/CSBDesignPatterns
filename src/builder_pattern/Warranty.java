package builder_pattern;

public class Warranty {
    private int years;
    private String providers;

    public Warranty(int years, String providers) {
        this.years = years;
        this.providers = providers;
    }

    @Override
    public String toString() {
        return "Warranty{" +
                "years=" + years +
                ", providers='" + providers + '\'' +
                '}';
    }
}
