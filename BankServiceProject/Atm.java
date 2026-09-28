package BankServiceProject;

import java.util.Scanner;

public class Atm implements Bank {

    Customer c ;       // Customer object

    Atm(Customer c){
        this.c = c;
    }

    BankApplication bapp = new BankApplication();

    static int pin; // No final

     {
        System.out.println("\n========================================");
        System.out.println("          🏦 ATM MACHINE");
        System.out.println("========================================");
        System.out.println("\nPlease Set Your 4 digit ATM PIN: ");

        Scanner sc = new Scanner(System.in);
        String temP = sc.next();

        if(temP.length() == 4 && charChek(temP)){
            pin = Integer.parseInt(temP);
            System.out.println("\n----------------------------------------");
            System.out.println("       PIN SET SUCCESSFULLY!");
            System.out.println("----------------------------------------\n");
        }else{
            System.out.println("\n----------------------------------------");
            System.out.println("       ❌ PIN SET FAILED!");
            System.out.println("----------------------------------------\n");

            Atm a = new Atm(c); // means again non_static block runs for the same customer;
        }


    }

    // *********************pin Validation***************************
    // Character.isDigit(ch);
    // Character.isLetter(ch);
    // Character.isNumber(ch);
    // Character.isAlphabetic(ch);
    // Character.isUpperCase(ch);
    // Character.isLowerCase(ch);
    // Character.isWhitespace(ch);
    // Character.isLetterOrDigit(ch);

    boolean charChek(String str){
         for(char ch:str.toCharArray()){
             if(!Character.isDigit(ch)) return false;
         }
         return true;
    }


    int yourPin() {
        System.out.println("\n========================================");
        System.out.println("           ATM LOGIN");
        System.out.println("========================================");

        System.out.print("\nPlease Enter Your PIN: ");

        int yourPin = new Scanner(System.in).nextInt();

        return yourPin;
    }

    public void checkPin() {

        int yourPin = yourPin();

        if (pin == yourPin) {

            System.out.println("\n----------------------------------------");
            System.out.println("          ✔️ PIN MATCHED");
            System.out.println("----------------------------------------");

            menu();

        } else {

            System.out.println("\n----------------------------------------");
            System.out.println("        ❌ INCORRECT PIN");
            System.out.println("----------------------------------------");
            System.out.println("Please Enter the Correct PIN.\n");

            checkPin();
        }
    }

    public void menu() {

        System.out.println("\n========================================");
        System.out.println("             ATM MENU"                     );
        System.out.println("========================================");

        System.out.println("\n" +
                            "1. Check Balance 💵");
        System.out.println("2. Withdraw 💵");
        System.out.println("3. Deposit 💵");
        System.out.println("4. Change Password");
        System.out.println("5. Visit Bank Service");
        System.out.println("6. Exit");

        System.out.println("\n----------------------------------------");
        System.out.print("Enter Your Choice: ");

        int input = new Scanner(System.in).nextInt();

        switch (input) {

            case 1:
                checkBalance();
                break;

            case 2:
                System.out.print("\nEnter 💵 Amount to Withdraw: ");

                int amount = new Scanner(System.in).nextInt();

                withdraw(amount);
                break;

            case 3:
                System.out.print("\nEnter 💵 Amount to Deposit: ");

                int depositAmount = new Scanner(System.in).nextInt();

                deposite(depositAmount);
                break;

            case 4:
                System.out.println("\n Please You Can Change Your Pin: ");
                changePass();
                break;

            case 5:
                String accountNo = c.getAccountNo();
                if(accountNo.contains("BOB")){
                    BankService b = new BankServiceImplOfBob();
                    b.BankMenu();
                    bapp.start();
                    break;
                }else if(accountNo.contains("SBI")){
                    BankService b = new BankServiceImplOfSbi();
                    b.BankMenu();
                    bapp.start();
                    break;
                }else if(accountNo.contains("PNB")){
                    BankService b = new BankServiceImplOfPunjabNationalBank();
                    b.BankMenu();
                    bapp.start();
                    break;
                }else{
                    System.out.println("\n----------------------------------------");
                    System.out.println("       ❌ INVALID CHOICE");
                    System.out.println("----------------------------------------");
                    System.out.println("Please Enter a Valid Choice.\n");
                    bapp.start();
                    break;
                }

            case 6:
                exit();
                break;

            default:
                System.out.println("\n----------------------------------------");
                System.out.println("       ❌ INVALID CHOICE");
                System.out.println("----------------------------------------");
                System.out.println("Please Enter a Valid Choice.\n");

                menu();
                break;
        }
    }


    private void exit() {
        System.out.println("\n========================================");
        System.out.println("       THANK YOU FOR USING OUR ATM");
        System.out.println("========================================");
        System.out.println("\nHave a Nice Day! 😊\n");

        System.exit(0); // i Adarsh can use return keyword by declaring my this method as boolean and return true;
    }

    @Override
    public void deposite(int amount) {
        float balance = c.getBalance();
        balance+=amount;
        c.setBalance(balance);

        System.out.println("\n----------------------------------------");
        System.out.println("         💵 DEPOSIT SUCCESSFUL");
        System.out.println("----------------------------------------");
        System.out.println("Deposited 💵 Amount : Rs" + amount);
        System.out.println("Current 💵 Balance  : Rs" + c.getBalance());
        System.out.println("----------------------------------------");

        menu();
    }

    @Override
    public void withdraw(int amount) {

        if (amount <= c.getBalance()) {

            float balance = c.getBalance();
            balance-=amount;
            c.setBalance(balance);

            System.out.println("\n----------------------------------------");
            System.out.println("         WITHDRAWAL SUCCESSFUL");
            System.out.println("----------------------------------------");
            System.out.println("Withdrawn 💵 Amount : Rs" + amount);
            System.out.println("Remaining 💵 Balance: Rs" + c.getBalance());
            System.out.println("----------------------------------------");

        } else {
            System.out.println("\n----------------------------------------");
            System.out.println("        ✗ INSUFFICIENT 💵 BALANCE");
            System.out.println("----------------------------------------");
            System.out.println("Please Enter a Valid Amount 💵.");
            System.out.println("----------------------------------------");
        }

        menu();
    }

    @Override
    public void checkBalance() {
        System.out.println("\n----------------------------------------");
        System.out.println("             ACCOUNT 💵 BALANCE");
        System.out.println("----------------------------------------");
        System.out.println("Current 💵 Balance: Rs" + c.getBalance());
        System.out.println("----------------------------------------");

        menu();
    }

    @Override
    public void changePass() {
        resetPin();
    }

    private void resetPin() {
        System.out.println("\n========================================");
        System.out.println("           ATM Pin Reset");
        System.out.println("========================================");

        System.out.print("\nPlease Enter Your New PIN: ");

        int yourPin = new Scanner(System.in).nextInt();
        pin = yourPin;

        System.out.println("\n----------------------------------------");
        System.out.println("          ✔️ PIN RESET");
        System.out.println("----------------------------------------");

        checkPin();
    }
}



