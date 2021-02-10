package BankApplication;

public abstract class Account {
    private  int accoutNumber;
    protected double balance;

    public Account(){

    }

    public Account(int accountNumber) {
        this.accoutNumber = accoutNumber;
        balance = 0;
    }

    //Getter Method
    public  double getBalance(){
        return this.balance;
    }

    public int getAccoutNumber(){
        return this.accoutNumber;
    }

    // Abstract
    /**
     * function to deposit funds into the account as long the amount parametr is >0
     *
     * Apply transcation fee for the checking amount
     * @param amount
     *
     */
    public  abstract  void deposit(double amount);

    /**
     * function to withdrwa funds from the account as long as
     * 1.amount to withdraw must ber >0
     * amount to withdraw must be <= blamce
     * @param amount
     * ***/
    public abstract void withdraw(double amount);


}
