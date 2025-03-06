package observer_pattern;

public class SmsSubscriber implements Observer<String>{
    private String phoneNumber;

    public SmsSubscriber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void update(String event) {
        System.out.println("SMS sent to " + phoneNumber + ": " + event);
    }
}
