package design_pattern.observer_pattern;

public class EmailSubscriber implements Observer<String>{
    private String name;

    public EmailSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String event) {
        System.out.println(name + " received email: " + event);
    }
}
