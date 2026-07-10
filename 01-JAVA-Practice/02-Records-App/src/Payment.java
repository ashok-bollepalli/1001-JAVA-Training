
public sealed class Payment permits CreditCardPayment {

    public void processPayment(){
        System.out.println("Processing Payment....");
    }
}
