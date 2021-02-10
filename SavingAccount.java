package BankApplication;
// saving Account child class
// has an interest rate
// a method to apply interest - profit

public class SavingAccount  extends  Account{
    //interest rate
    private  double interestRate;

    // default constructor
    public SavingAccount(){
        super();
    }

    public SavingAccount(int accountNumber, double interestRate){
        super(accountNumber);
        this.interestRate = interestRate;
    }

    //getter and setter

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double calcInterest(){
        return balance * interestRate;
    }
    public void  applyInterest(){
        double interest = calcInterest();
        System.out.printf("Interest amount %.2f added to balance",interest);
        deposit(interest);
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
            // checking suffient balance
            if ((amount) <= balance){
                System.out.printf("Amount of %.2f withdraw_from Account",amount);
                balance-=amount;
                System.out.printf("Current Balance is  of %.2f",balance);
            }
        }
        else {
            System.out.println("A negative amount cannot be withdraw!");
        }

    }

}
