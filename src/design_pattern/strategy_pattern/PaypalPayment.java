package design_pattern.strategy_pattern;

public class PaypalPayment  implements  PaymentStrategy{
    private String email;

    public PaypalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal: " + email);
    }
}
