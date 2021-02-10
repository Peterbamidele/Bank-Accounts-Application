package BankApplication;

import java.util.Scanner;

public class AccountMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // array of Account
        Account accounts[]= new Account[20];
        int numAccounts = 0;

        int choice;
        do {
            choice = menu(input);
            System.out.println();

            if (choice == 1){
                accounts[numAccounts++]=createAccount(input);
            }else if (choice == 2){
                    deposit(accounts,numAccounts,input);
                }else if (choice == 3){
                    withdrawal(accounts,numAccounts,input);
                }else if (choice == 4){
                    applyInterest(accounts, numAccounts,input);
            }else {
                System.out.println("GoodBye");
            }
            System.out.println();

        }while(choice != 5);

    }


    /** //Account choice***

    **/
    public static int accountMenu(Scanner input){
        System.out.println("Select Account Type:");
        System.out.println("1. Checking Account");
        System.out.println("2. Saving Account");

        int choice;
        do {
            System.out.print("Enter choice ");
            choice = input.nextInt();

        }while (choice < 1 || choice > 2);

        return choice;

    }

    public static int searchAccount(Account accounts[], int count,int accountNumber){
       for (int i= 0; i<count; i++ ){
           if(accounts[i].getAccoutNumber() == accountNumber){
               return i;
           }
       }
        return -1;
    }

        /**
         *To perform Deposit on selected amount **/
    public  static void  deposit(Account accounts [],int count, Scanner input ){
        // Get the account number
        System.out.print("\nPlease enter account number:");
        int accountNumber = input.nextInt();
        // search for account
        int index = searchAccount(accounts ,count, accountNumber);

        if (index >= 0) {

            //      Amount
            System.out.print("Please enter Deposit Amount: ");
            double amount = input.nextDouble();

            accounts[index].deposit(amount);
        }
        else {
            System.out.println("Oga AccountNumber Doesnt Exits" + accountNumber);
        }

    }

    /**
     * withdrawal method
     *
    **/

    public static void withdrawal(Account accounts[], int count , Scanner input){
        // Get the account number
        System.out.print("\nPlease enter account number:");
        int accountNumber = input.nextInt();
        // search for account
        int index = searchAccount(accounts ,count, accountNumber);

        if (index >= 0) {
            //      Amount
            System.out.print("Please enter Withdrawal Amount: ");
            double amount = input.nextDouble();
            accounts[index].withdraw(amount);
        }
        else {
            System.out.println("Oga AccountNumber Doesnt Exits" + accountNumber);
        }

    }
    /**
     * Interst **/

    public static void applyInterest (Account accounts[], int count , Scanner input){
        // Get the account number
        System.out.print("\nPlease enter account number:");
        int accountNumber = input.nextInt();
        // search for account
        int index = searchAccount(accounts ,count, accountNumber);

        if (index >= 0) {
            //must be from saving account
            if (accounts[index] instanceof SavingAccount)
                ((SavingAccount)accounts[index]).applyInterest();
        }
        else {
            System.out.println("Oga AccountNumber Doesnt Exits" + accountNumber);
        }

    }

    /**
     * Creating an new accounts*/
    public static Account createAccount(Scanner input){
        Account account = null;
        int chioce = accountMenu(input);

        int accountNumber;
        System.out.print("Enter Account Number");
        accountNumber = input.nextInt();

        if (chioce == 1) { // ckecking Account
            System.out.print("Enter Transaction Amount");
            double fee = input.nextDouble();
            account = new CheckingAccount(accountNumber, fee);
        }else {// saving account
            System.out.print("Please Enter Interest Rate");
            double intereset_rate = input.nextDouble();
            account = new SavingAccount(accountNumber, intereset_rate);
         }
        return account;

    }


    /**
     * Menu to display option and get user's selection
     * */

    public static int menu(Scanner input){
        System.out.println("___Bank Account Menu___");
        System.out.println("1.___Create New Account___");
        System.out.println("2.___Deposit Funds___");
        System.out.println("3.___Withdraw Funds___");
        System.out.println("4.___Apply Interest___");
        System.out.println("5.___Quit___");

        int choice;

        do {
            System.out.print("Enter choice: ");
            choice = input.nextInt();
        }while (choice < 1 || choice > 5);

        return choice;

    }

    }


