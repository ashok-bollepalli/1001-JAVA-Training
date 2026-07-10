public class SealedClassDemo {

    public static void main(String[] args) {

        Payment p = new CreditCardPayment();
        p.processPayment();

    }
}
