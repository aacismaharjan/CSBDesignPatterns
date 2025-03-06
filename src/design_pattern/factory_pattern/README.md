# Factory Method Pattern in java
- Creation Design Pattern
- Interface for creating objects
- But allows subclasses to alter the type of objects that will be created

## When to use Factory Method Pattern
- Exact type of object to be created is determined at runtime
- Object creation logic is complex or involves conditional logic
- When working with interfaces or abstract classes, and actual object instantiation should be decoupled.


---

### **1. Logger Factory**
**Use Case:** Different types of logging mechanisms.

```java
// Logger Interface
interface Logger {
    void log(String message);
}

// Concrete Loggers
class ConsoleLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("Console Logger: " + message);
    }
}

class FileLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("File Logger: " + message);
    }
}

// Logger Factory
class LoggerFactory {
    public static Logger getLogger(String type) {
        switch (type.toLowerCase()) {
            case "console":
                return new ConsoleLogger();
            case "file":
                return new FileLogger();
            default:
                throw new IllegalArgumentException("Unknown logger type: " + type);
        }
    }
}

// Client Code
public class FactoryPatternLogger {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger("console");
        logger.log("Factory Pattern Example!");
    }
}
```

---

### **2. Database Connection Factory**
**Use Case:** Handling different database connections dynamically.

```java
// Database Connection Interface
interface Database {
    void connect();
}

// Concrete Database Implementations
class MySQLDatabase implements Database {
    @Override
    public void connect() {
        System.out.println("Connected to MySQL Database");
    }
}

class PostgreSQLDatabase implements Database {
    @Override
    public void connect() {
        System.out.println("Connected to PostgreSQL Database");
    }
}

// Database Factory
class DatabaseFactory {
    public static Database getDatabase(String type) {
        switch (type.toLowerCase()) {
            case "mysql":
                return new MySQLDatabase();
            case "postgresql":
                return new PostgreSQLDatabase();
            default:
                throw new IllegalArgumentException("Unknown database type: " + type);
        }
    }
}

// Client Code
public class FactoryPatternDatabase {
    public static void main(String[] args) {
        Database db = DatabaseFactory.getDatabase("mysql");
        db.connect();
    }
}
```

---

### **3. Notification Factory**
**Use Case:** Sending notifications via different channels (SMS, Email).

```java
// Notification Interface
interface Notification {
    void send(String message);
}

// Concrete Notification Types
class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Email Notification: " + message);
    }
}

class SMSNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("SMS Notification: " + message);
    }
}

// Notification Factory
class NotificationFactory {
    public static Notification getNotification(String type) {
        switch (type.toLowerCase()) {
            case "email":
                return new EmailNotification();
            case "sms":
                return new SMSNotification();
            default:
                throw new IllegalArgumentException("Unknown notification type: " + type);
        }
    }
}

// Client Code
public class FactoryPatternNotification {
    public static void main(String[] args) {
        Notification notification = NotificationFactory.getNotification("sms");
        notification.send("Hello from Factory Pattern!");
    }
}
```
