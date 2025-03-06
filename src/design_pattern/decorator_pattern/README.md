# Decorator Pattern
- allows you to dynamically add new behavior to an object
- without modifying it's existing code
- useful for extending functionalities in a flexible and reusable way

## Key Takeways
- Extends functionality dynamically without modifying existing classess
- Follows Open-Closed Principle - new behaviors are added via composition
- reusable & scalable - multiple decorators can be stacked
  Here’s a **quick Java example** for each real-world use case of the **Decorator Pattern** 🚀

---

### **🔹 1. Text Formatting (Bold, Italic)**
```java
interface Text {
    String format();
}

class PlainText implements Text {
    public String format() { return "Hello"; }
}

class BoldText implements Text {
    private Text text;
    public BoldText(Text text) { this.text = text; }
    public String format() { return "**" + text.format() + "**"; }
}

class ItalicText implements Text {
    private Text text;
    public ItalicText(Text text) { this.text = text; }
    public String format() { return "_" + text.format() + "_"; }
}

public class TextDecoratorDemo {
    public static void main(String[] args) {
        Text text = new ItalicText(new BoldText(new PlainText()));
        System.out.println(text.format()); // Output: _**Hello**_
    }
}
```

---

### **🔹 2. Clothing Layers (Winter Wear)**
```java
interface Outfit { String wear(); }

class TShirt implements Outfit {
    public String wear() { return "T-Shirt"; }
}

class Sweater implements Outfit {
    private Outfit outfit;
    public Sweater(Outfit outfit) { this.outfit = outfit; }
    public String wear() { return outfit.wear() + " + Sweater"; }
}

class Jacket implements Outfit {
    private Outfit outfit;
    public Jacket(Outfit outfit) { this.outfit = outfit; }
    public String wear() { return outfit.wear() + " + Jacket"; }
}

public class ClothingDecoratorDemo {
    public static void main(String[] args) {
        Outfit outfit = new Jacket(new Sweater(new TShirt()));
        System.out.println(outfit.wear()); // Output: T-Shirt + Sweater + Jacket
    }
}
```

---

### **🔹 3. Car Customization (Sunroof, Sports Package)**
```java
interface Car { String assemble(); }

class BasicCar implements Car {
    public String assemble() { return "Basic Car"; }
}

class Sunroof implements Car {
    private Car car;
    public Sunroof(Car car) { this.car = car; }
    public String assemble() { return car.assemble() + " + Sunroof"; }
}

class SportsPackage implements Car {
    private Car car;
    public SportsPackage(Car car) { this.car = car; }
    public String assemble() { return car.assemble() + " + Sports Package"; }
}

public class CarDecoratorDemo {
    public static void main(String[] args) {
        Car car = new SportsPackage(new Sunroof(new BasicCar()));
        System.out.println(car.assemble()); // Output: Basic Car + Sunroof + Sports Package
    }
}
```

---

### **🔹 4. Coffee Customization (Milk, Sugar)**
```java
interface Coffee { String getDescription(); double getCost(); }

class SimpleCoffee implements Coffee {
    public String getDescription() { return "Plain Coffee"; }
    public double getCost() { return 50.0; }
}

class Milk implements Coffee {
    private Coffee coffee;
    public Milk(Coffee coffee) { this.coffee = coffee; }
    public String getDescription() { return coffee.getDescription() + ", Milk"; }
    public double getCost() { return coffee.getCost() + 10.0; }
}

class Sugar implements Coffee {
    private Coffee coffee;
    public Sugar(Coffee coffee) { this.coffee = coffee; }
    public String getDescription() { return coffee.getDescription() + ", Sugar"; }
    public double getCost() { return coffee.getCost() + 5.0; }
}

public class CoffeeDecoratorDemo {
    public static void main(String[] args) {
        Coffee coffee = new Sugar(new Milk(new SimpleCoffee()));
        System.out.println(coffee.getDescription() + " -> Rs. " + coffee.getCost());
        // Output: Plain Coffee, Milk, Sugar -> Rs. 65.0
    }
}
```

---

### **🔹 5. Game Power-ups (Speed Boost, Shield)**
```java
interface Player { String getAbilities(); }

class BasicPlayer implements Player {
    public String getAbilities() { return "Basic Abilities"; }
}

class SpeedBoost implements Player {
    private Player player;
    public SpeedBoost(Player player) { this.player = player; }
    public String getAbilities() { return player.getAbilities() + " + Speed Boost"; }
}

class Shield implements Player {
    private Player player;
    public Shield(Player player) { this.player = player; }
    public String getAbilities() { return player.getAbilities() + " + Shield"; }
}

public class GameDecoratorDemo {
    public static void main(String[] args) {
        Player player = new Shield(new SpeedBoost(new BasicPlayer()));
        System.out.println(player.getAbilities()); // Output: Basic Abilities + Speed Boost + Shield
    }
}
```

---

### **🔹 6. Streaming Services (Ad-Free, 4K Video)**
```java
interface StreamingPlan { String getFeatures(); }

class BasicPlan implements StreamingPlan {
    public String getFeatures() { return "Basic Plan"; }
}

class AdFree implements StreamingPlan {
    private StreamingPlan plan;
    public AdFree(StreamingPlan plan) { this.plan = plan; }
    public String getFeatures() { return plan.getFeatures() + " + Ad-Free"; }
}

class UltraHD implements StreamingPlan {
    private StreamingPlan plan;
    public UltraHD(StreamingPlan plan) { this.plan = plan; }
    public String getFeatures() { return plan.getFeatures() + " + 4K Ultra HD"; }
}

public class StreamingDecoratorDemo {
    public static void main(String[] args) {
        StreamingPlan plan = new UltraHD(new AdFree(new BasicPlan()));
        System.out.println(plan.getFeatures()); // Output: Basic Plan + Ad-Free + 4K Ultra HD
    }
}
```

---

### **🔹 7. Notifications (Sound, Vibration)**
```java
interface Notification { String send(); }

class BasicNotification implements Notification {
    public String send() { return "Notification Sent"; }
}

class Sound implements Notification {
    private Notification notification;
    public Sound(Notification notification) { this.notification = notification; }
    public String send() { return notification.send() + " + Sound Alert"; }
}

class Vibration implements Notification {
    private Notification notification;
    public Vibration(Notification notification) { this.notification = notification; }
    public String send() { return notification.send() + " + Vibration"; }
}

public class NotificationDecoratorDemo {
    public static void main(String[] args) {
        Notification notification = new Vibration(new Sound(new BasicNotification()));
        System.out.println(notification.send()); // Output: Notification Sent + Sound Alert + Vibration
    }
}
```
