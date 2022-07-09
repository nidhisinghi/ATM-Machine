package ATM_project;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    private int customerNumber;
    private int pinNumber;
    private double checkingBalance =0;
    private double savingBalance=0;

    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    public int setCustomerNumber(int customerNumber){
        this.customerNumber=customerNumber;
        return customerNumber;
    }

    public int getCustomerNumber(){
        return customerNumber;
    }

    public int setPinNumber(int customerNumber){
        this.customerNumber=customerNumber;
        return pinNumber;
    }

    public int getPinNumber(){
        return pinNumber;
    }

    public double getcheckingBalance(){
        return checkingBalance;
    }

    public double getSavingBalance(){
        return savingBalance;
    }

    public double calCheckingWithdraw(double amount){
        checkingBalance=checkingBalance-amount;
        return checkingBalance;
    }

    public double calSavingWithdraw(double amount){
        savingBalance=savingBalance-amount;
        return checkingBalance;
    }

    public double calCheckingDeposit(double amount){
        checkingBalance=checkingBalance+amount;
        return checkingBalance;
    }

    public double calSavingDeposit(double amount){
        savingBalance=savingBalance+amount;
        return checkingBalance;
    }

    public void getCheckingWithdrawInput(){
        System.out.println("Checking Account Balance: "+moneyFormat.format(checkingBalance));
        System.out.println("Amount you want to withdraw from Checking Account: ");
        double amount = input.nextDouble();

        if((checkingBalance-amount)>=0){
            calCheckingWithdraw(amount);
            System.out.println("New Checking Account Balance: "+ moneyFormat.format(calCheckingWithdraw(amount)));
        }else{
            System.out.println("Insufficient Balance. "+"\n");
        }
    }

    public void getSavingWithdrawInput(){
        System.out.println("Checking Account Balance: "+moneyFormat.format(savingBalance));
        System.out.println("Amount you want to withdraw from savings Account: ");
        double amount = input.nextDouble();

        if((savingBalance-amount)>=0){
            calSavingWithdraw(amount);
            System.out.println("New Checking Account Balance: "+ moneyFormat.format(calSavingWithdraw(amount)));
        }else{
            System.out.println("Insufficient Balance. "+"\n");
        }
    }

    public void getCheckingDepositInput(){
        System.out.println("Checking Account Balance: "+moneyFormat.format(checkingBalance));
        System.out.println("Amount you want to withdraw from Checking Account: ");
        double amount = input.nextDouble();

        calCheckingDeposit(amount);
        System.out.println("New Checking Account Balance: "+moneyFormat.format(calCheckingDeposit(amount)));
    }

    public void getSavingDepositInput(){
        System.out.println("Checking Account Balance: "+moneyFormat.format(savingBalance));
        System.out.println("Amount you want to withdraw from savings Account: ");
        double amount = input.nextDouble();

        calSavingDeposit(amount);
        System.out.println("New Checking Account Balance: "+ moneyFormat.format(calSavingDeposit(amount)));
    }
}
