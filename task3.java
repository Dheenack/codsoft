package task3;
/*
 * ATM interface
 * methods can be done are 
 * deposit:deposits some money to user account
 * withdrawl:withdrawl of money from user account
 * check balance: checks the balance of user account
 */
import java.util.Scanner;
class ATM{
private Bank_account account;
public ATM(Bank_account acc){
    this.account=acc;
}
//ATM deposit
public void deposit(int amount){
    if(this.account.deposit(amount)){
        System.out.println("Rs."+amount+" has been deposited successfully");
    }
    else{
        System.out.println("deposition unsuccessful...try again");
    }
}
//ATM withdrawl
public void withdrawl(int amount){
    if(this.account.withdrawl(amount)){
        System.out.println("Rs."+amount+" has been withdrawl successfully");
    }
    else{
        System.out.println("Check your balance and try again");
    }
}
//ATM check balance
public void checkBalance(){
    System.out.println("Your current balance is "+this.account.giveBalance()+" .");
}
}
//* Bank account class
class Bank_account{
    //required variables
    int acc_no;
    String acc_holder;
    double balance;
    //constructor
    public Bank_account(int acc_no,String name,Double Balance){
        this.acc_no=acc_no;
        this.acc_holder=name;
        this.balance=Balance;
    }
    //deposit class
public boolean deposit(int amount){
    if(amount>0){
        this.balance+=amount;
        System.out.println("deposition successful");
        return true;
    }
    else{
        System.out.println("deposit amount should be greater than zero");
        return false;
    }
}
//withdrawl class
public boolean withdrawl(int amount){
    if(amount>0){
        if(this.balance>=amount){
            this.balance-=amount;
            return true;
        }
        else{
            System.out.println("Insufficient balance");
            return false;
        }
    }
    else{
        System.out.println("Withdrawl amount should be less than zero.");
        return false;
    }
}
//check balance
public double giveBalance(){
    return this.balance;
}
}
//!Main class
public class task3 {
    public static void main(String...args){
        Scanner scan=new Scanner(System.in);
        // User instance
        Bank_account user1 = new Bank_account(4211,"Sri",25000.0);
        //ATM instance
        ATM atm=new ATM(user1);
        int choice;
        do{
            System.out.println("*************************************************");
            System.out.println("Welcome to ATM:");
            System.out.println("*************************************************");
            System.out.println("1.Deposit\n2.Withdrawl\n3.check Balance\n4.Exit");
            System.out.println("Enter your choice:");
            choice=scan.nextInt();
            switch(choice){
                case 1 :
                {
                    System.out.println("Enter your deposit amount(as whole number::minimum=500):");
                    int deposit_amt=scan.nextInt();
                    atm.deposit(deposit_amt);
                    break;
                }
                case 2 :
                {
                    System.out.println("Enter your Withdrawl amount(as whole number::minimum=500):");
                    int withdrawl_amt=scan.nextInt();
                    atm.withdrawl(withdrawl_amt);
                    break;
                }
                case 3:
                {
                    atm.checkBalance();
                    break;
                }
                case 4:
                {
                    System.out.println("Thank you..!");
                    System.exit(0);
                }
            }
        }while(choice>0 && choice<4);
        scan.close();
    }
}