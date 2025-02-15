public class BankAccountClass {

private double BankBalance;


public BankAccountClass(double intialBalance){
    this.BankBalance = intialBalance;
}

public double getBalance(){
    return BankBalance;
}

public boolean deposit(double amount){
    if (amount >0){
        BankBalance+= amount;
        System.out.println("Your deposit was successful. Your new bank balance: "+BankBalance);
        return true;
    }

    else{
        System.out.println("Your deposit was unsuccesful");
        return false;
    }

}

public boolean withdraw (double amount){
    if(amount > 0 &&  amount <= BankBalance){
        BankBalance -= amount;
        System.out.println("Withdrawal successful. Your new amount is R"+BankBalance);
        return true;
    }else if ( amount > BankBalance){
        System.out.println("Invalid amount requested.");
        return false;
    }
        System.out.println("Please try again. ");
        return false;
}


}