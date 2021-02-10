package BankApplication;

public class CheckingAccount extends Account{

    private static  double FEE = 2.5;

    // default constructor
    public  CheckingAccount(){
        super();
    }

    /**
     * Paranetr constructor to initalize checkingAccount
     * with a custom Account number and a customer Transcation
     * fees*/

    public CheckingAccount(int accountNumber, double fee){
        super(accountNumber);
        FEE= fee;

    }


    /**
     * function to deposit funds into the account as long the amount parametr is >0
     *
     * Apply transcation fee for the checking amount
     * @param amount
     *
     */
    public  void deposit(double amount){
        //first check amount ia greater than zero
        if (amount > 0){
            balance += amount;
            System.out.printf("Amount: %.2f deposited%n",amount);

            //apply tramsaction fee
            balance-= FEE;
            System.out.printf("Amount: %.2f Applied%n",FEE);
            System.out.printf("Current Balance: %.2f deposited%n",balance);

        }
        else {
            System.out.println("A negative amount cannot be deposited ");
        }
    }

    /**
     * function to withdrwa funds from the account as long as
     * 1.amount to withdraw must ber >0
     * amount to withdraw must be <= blamce
     * @param amount
     * ***/
    public  void withdraw(double amount){
        // same check
        if (amount > 0){
            // checking sufficient balance
            if ((amount + FEE) <= balance){
                System.out.printf("Amount of %.2f withdraw_from Account",amount);
                balance-=amount;
                balance -= FEE;
                System.out.printf("Fee of $ 2f.application",FEE);
                System.out.printf("Current Balance is  of %.2f",balance);
            }
        }
        else {
            System.out.println("A negative amount cannot be withdraw!");
        }

    }


}
