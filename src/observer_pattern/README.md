# Observer Pattern
- Behavioral Design Pattern
- an Object (called Subject) maintains a list of dependents (called Observers)
- notifies them of any state changes
- by calling one of their methods
- useful in event-driven programming, reactive systems, and real-time applications


## Key Components of the Observer Pattern
- Subject (Publisher/Observable)
  - Maintains a list of observers
  - Provides methods to register, unregister, and notify observers
- Observer (Subscriber/Listener)
  - Defines an interface with an `update()` method to receive notifications from the subject.
- Concrete Subject
  - Extends the subject and contains the actual business logic
  - Notifies observers when there is a state change
-Concrete Observer
  - Implements the observer interface and updates itself based on the notification received.

## Generic Event Notification System


## Advantages of Observer Pattern
- Loose Coupling: The publisher doesn't need to know the details of observes. New observers can be added without modifying existing code.
- Scalability: New subscribers can easily subscribe or unsubscribe dynamically
- Reusability: Common notification logic is reusable across different types of events.
- Separation of Concerns: Publishers handle only event publishing; observers handle responses independently.

## Use Cases of Observer Pattern

### Logging System - Notify Multiple Loggers
```java
public class LoggingObserverDemo {
    public static void main(String[] args) {
        LogManager logManager = new LogManager();
        logManager.addLogger(new ConsoleLogger());
        logManager.addLogger(new FileLogger());

        logManager.notifyLoggers("User logged in.");
    }
}
```

### Messaging System - KAFKA-like PUB/SUB
```java
public class MessagingObserverDemo {
    public static void main(String[] args) {
        MessageBroker broker = new MessageBroker();

        broker.subscribe(new SmsSubscriber());
        broker.subscribe(new EmailSubscriber());

        broker.publish("New order received!");
    }
}
```

### Stock Market App - Real-time Updates
```java
public class StockMarketObserverDemo {
    public static void main(String[] args) {
        Stock stock = new Stock();

        stock.addObserver(new MobileAppStockView());
        stock.addObserver(new WebAppStockView());

        stock.setPrice(101.75);
    }
}
```


### Social Media Notifications - New Post Alerts
```java
public class SocialMediaObserverDemo {
  public static void main(String[] args) {
    SocialMedia facebook = new SocialMedia();

    facebook.follow(new MobileUser());
    facebook.follow(new EmailUser());

    facebook.postUpdate("🎉 New Feature Released!");
  }
}
```