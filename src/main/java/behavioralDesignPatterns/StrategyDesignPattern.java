package behavioralDesignPatterns;

public class StrategyDesignPattern {
    public static void main(String[] args) {
        PaymentStrategy creditCrad= new PaymentByCreditCard();
        PaymentStrategy gpay= new PaymentByGpay();
        creditCrad.pay(100);
        gpay.pay(10);
    }
}
interface PaymentStrategy{
    public void pay(int amount);
}
class CreditCard{
    String number,expDate,cvv;
    public CreditCard(String n, String e, String c){
        number=n;
        expDate=e;
        cvv=c;
    }
}
class PaymentByCreditCard implements PaymentStrategy{
    private CreditCard card;
    @Override
    public void pay(int amount) {
        card= new CreditCard("123","12/22","22");
        System.out.println("validating card details...");
        System.out.println("payment done with amount:"+amount);
    }
}
class PaymentByGpay implements PaymentStrategy{
    String upiId;
    @Override
    public void pay(int amount) {
        upiId="sass@okhdcs";
        System.out.println("validatong upi id...");
        System.out.println("payment done amount:"+ amount);
    }
}