Here are some other common applications of the **Template Method Pattern** with Java snippets:

---

### **1. Data Processing (CSV & JSON Readers)**
**Use Case:** A template for reading data from different file formats.

```java
// Abstract Template Class
abstract class DataProcessor {
    public final void process() {
        readData();
        processData();
        saveData();
    }

    protected abstract void readData();
    protected abstract void processData();

    private void saveData() {
        System.out.println("Saving processed data...");
    }
}

// Concrete Class for CSV
class CSVProcessor extends DataProcessor {
    @Override
    protected void readData() {
        System.out.println("Reading data from CSV file");
    }

    @Override
    protected void processData() {
        System.out.println("Processing CSV data");
    }
}

// Concrete Class for JSON
class JSONProcessor extends DataProcessor {
    @Override
    protected void readData() {
        System.out.println("Reading data from JSON file");
    }

    @Override
    protected void processData() {
        System.out.println("Processing JSON data");
    }
}

// Client Code
public class TemplatePatternDataProcessing {
    public static void main(String[] args) {
        DataProcessor csvProcessor = new CSVProcessor();
        csvProcessor.process();

        System.out.println();

        DataProcessor jsonProcessor = new JSONProcessor();
        jsonProcessor.process();
    }
}
```

---

### **2. Game AI (Chess & Checkers)**
**Use Case:** Defining a common game algorithm with specific rules for different games.

```java
// Abstract Class
abstract class Game {
    public final void play() {
        initialize();
        startPlay();
        endPlay();
    }

    protected abstract void initialize();
    protected abstract void startPlay();
    protected abstract void endPlay();
}

// Concrete Class for Chess
class Chess extends Game {
    @Override
    protected void initialize() {
        System.out.println("Initializing Chess...");
    }

    @Override
    protected void startPlay() {
        System.out.println("Playing Chess...");
    }

    @Override
    protected void endPlay() {
        System.out.println("Ending Chess game.");
    }
}

// Concrete Class for Checkers
class Checkers extends Game {
    @Override
    protected void initialize() {
        System.out.println("Initializing Checkers...");
    }

    @Override
    protected void startPlay() {
        System.out.println("Playing Checkers...");
    }

    @Override
    protected void endPlay() {
        System.out.println("Ending Checkers game.");
    }
}

// Client Code
public class TemplatePatternGame {
    public static void main(String[] args) {
        Game chess = new Chess();
        chess.play();

        System.out.println();

        Game checkers = new Checkers();
        checkers.play();
    }
}
```

---

### **3. Online Payment System (Credit Card & PayPal)**
**Use Case:** Implementing a standardized payment process.

```java
// Abstract Class
abstract class PaymentProcessor {
    public final void processPayment() {
        authenticate();
        processTransaction();
        sendReceipt();
    }

    protected abstract void authenticate();
    protected abstract void processTransaction();

    private void sendReceipt() {
        System.out.println("Sending payment receipt...");
    }
}

// Concrete Class for Credit Card
class CreditCardPayment extends PaymentProcessor {
    @Override
    protected void authenticate() {
        System.out.println("Authenticating Credit Card details...");
    }

    @Override
    protected void processTransaction() {
        System.out.println("Processing Credit Card transaction...");
    }
}

// Concrete Class for PayPal
class PayPalPayment extends PaymentProcessor {
    @Override
    protected void authenticate() {
        System.out.println("Authenticating PayPal account...");
    }

    @Override
    protected void processTransaction() {
        System.out.println("Processing PayPal transaction...");
    }
}

// Client Code
public class TemplatePatternPayment {
    public static void main(String[] args) {
        PaymentProcessor creditCard = new CreditCardPayment();
        creditCard.processPayment();

        System.out.println();

        PaymentProcessor paypal = new PayPalPayment();
        paypal.processPayment();
    }
}
```

---

### **Key Takeaways**
- **Data Processing:** Handling different file formats.
- **Game AI:** Standardizing gameplay flow.
- **Online Payments:** Ensuring consistent payment steps.

These examples highlight how **Template Method Pattern** promotes **code reuse and flexibility**. 🚀