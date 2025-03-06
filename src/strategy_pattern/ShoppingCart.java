package strategy_pattern;

public class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    // Set the strategy dynamically
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        if(paymentStrategy == null) {
            throw new IllegalStateException("Payment strategy not set");
        }
        paymentStrategy.pay(amount);
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Using credit card payment strategy
        cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9878"));
        cart.checkout(100);

        cart.setPaymentStrategy(new PaypalPayment("user@example.com"));
        cart.checkout(200);
    }
}
