public non-sealed class CreditCardPayment extends Payment{

    @Override
    public void processPayment() {
       System.out.println("Credit Payment Completed...");
    }
}
