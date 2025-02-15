
public class MainClass{


    public static void main(String[] args) {

       BankAccountClass account = new BankAccountClass(1000.00);
       ATM atm = new ATM(account);
       atm.start();
    }
}