package observer_pattern;

public class PushNotificationSubscriber implements Observer<String>{
    @Override
    public void update(String event) {
        System.out.println("Push Notification: " + event);
    }
}
