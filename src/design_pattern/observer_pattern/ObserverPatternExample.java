package design_pattern.observer_pattern;

public class ObserverPatternExample {
    public static void main(String[] args) {
        try {
            // Create Event Publisher
            EventPublisher eventPublisher = new EventPublisher();

            // Create Subscribers
            EmailSubscriber emailSubscriber1 = new EmailSubscriber("John");
            EmailSubscriber emailSubscriber2 = new EmailSubscriber("Alice");
            SmsSubscriber smsSubscriber = new SmsSubscriber("+1234567890");
            PushNotificationSubscriber pushSubscriber = new PushNotificationSubscriber();

            // Register Subscribers
            eventPublisher.registerObserver(emailSubscriber1);
            eventPublisher.registerObserver(emailSubscriber2);
            eventPublisher.registerObserver(smsSubscriber);
            eventPublisher.registerObserver(pushSubscriber);


            // Publish Events
            eventPublisher.publishEvent("Breaking News: Observer Pattern Explained!");
            eventPublisher.publishEvent("New Product Launch: Java Observer in Action");

            // Remove an observer and publish another event
            eventPublisher.removeObserver(emailSubscriber1);
            eventPublisher.publishEvent("Stock Market Update: Prices Soar!");
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
