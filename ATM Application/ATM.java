public class ATM{

private BankAccountClass account;

public ATM(BankAccountClass account){
    this.account = account;
}

private void checkBankBalance(){
    System.out.println("Your bank balance is R "+ account.getBalance());
}

public void start(){
    java.util.Scanner scanner = new java.util.Scanner(System.in);
    boolean running = true;

    while(running){
        System.out.println("\n Welcome to the bank of developers. Please select an option to continue:");
        System.out.println("1: Check bank balance");
        System.out.println("2: Deposit into bank account");
        System.out.println("3: Withdraw money from bank account");
        System.out.println("4: Exit");

        int option = scanner.nextInt();
        switch (option){
            case 1: 
            checkBankBalance();
            break;
                case 2:
                    System.out.println("Please enter amount you want to deposit");
                    double amountToDeposit = scanner.nextDouble();
                    account.deposit(amountToDeposit);
                    break;
                        case 3:
                            System.out.println("Please enter amount you want to withdraw");
                            double amountToWithdraw = scanner.nextDouble();
                            account.withdraw(amountToWithdraw);
                            break;
                                case 4:
                                    running = false;
                                    System.out.println("Thank you for using the bank of developers. Goodbye.");
                                    break;
        
        default: 
            System.out.println("Invalid option selected. Please try again.");
        }
    }

    scanner.close();
}

}