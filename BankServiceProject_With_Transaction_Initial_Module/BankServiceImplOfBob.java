package BankServiceProject_With_Transaction_Initial_Module;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankServiceImplOfBob implements BankService {

    static HashMap<String, Customer> customers = new HashMap<>();

    static HashMap<String, Transactions> transactions = new HashMap<>();


    void display(){
        for(Map.Entry<String, Customer> m : customers.entrySet()){
            System.out.println(m.getKey() + " : " + m.getValue());
        }
    }

    // I want a Method to be accesed by Class Name from Atm class


    Atm atm;

    private static String accountPref = "20360100021";

    // Single Scanner object
    static Scanner sc = new Scanner(System.in);


    @Override
    public void visitBank() {

        System.out.println("========== Welcome to Bank 🏦 Of Baroda ==========");

        BankMenu();
    }


    @Override
    public void BankMenu() {

        System.out.println();
        System.out.println("========== BOB BANK MENU ==========");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Open Account");
        System.out.println("4. Close Account");
        System.out.println("5. UPI Transaction");
        System.out.println("6. Loan");
        System.out.println("7. Insurance");
        System.out.println("8. Credit Card");
        System.out.println("9. Find Account");
        System.out.println("10. Use Atm Service");
        System.out.println("11. Check Balance");
        System.out.println("12. Transactions");
        System.out.println("13. Exit");
        System.out.println("====================================");

        System.out.print("Enter your choice: ");

        String choiceInput = sc.nextLine();
        while (choiceInput.trim().isEmpty()) {
            System.out.print("Please enter a valid choice: ");
            choiceInput = sc.nextLine();
        }
        int choice = Integer.parseInt(choiceInput);


        switch (choice) {


            case 1:

                System.out.print("Enter amount to withdraw: ");
                int withdrawAmount = Integer.parseInt(sc.nextLine());

                System.out.print("Enter account number: ");
                String withdrawAccountNo = sc.nextLine();

                withdraw(withdrawAmount, withdrawAccountNo);
                BankMenu();
                break;


            case 2:

                System.out.print("Enter amount to deposit: ");
                int depositAmount = Integer.parseInt(sc.nextLine());

                System.out.print("Enter account number: ");
                String depositAccountNo = sc.nextLine();

                deposit(depositAmount, depositAccountNo);

                BankMenu();
                break;


            case 3:

                System.out.print("Enter customer name: ");
                String name = sc.nextLine();


//                System.out.println();
//                System.out.println("Select Bank:");
//                System.out.println("1. BOB");
//                System.out.println("2. PNB");
//                System.out.println("3. HDFC");
//                System.out.println("4. SBI");
//
//                System.out.print("Enter your choice: ");
//
//                int choice3 = Integer.parseInt(sc.nextLine());


                String bankName = "BOB";

//                if (choice3 == 1) {
//
//                    bankName = "BOB";
//
//                } else if (choice3 == 2) {
//
//                    bankName = "PNB";
//
//                } else if (choice3 == 3) {
//
//                    bankName = "HDFC";
//
//                } else if (choice3 == 4) {
//
//                    bankName = "SBI";
//
//                } else {
//
//                    System.out.println("Invalid bank choice.");
//                    BankMenu();
//                }


                System.out.print("Enter Aadhar number: ");
                String aadharNo = sc.nextLine();


                if (aadharNo.length() != 12) {

                    System.out.println("Invalid Aadhar number.");
                    BankMenu();
                    break;
                }


                System.out.print("Enter initial balance: ");
                int balance = Integer.parseInt(sc.nextLine());


                System.out.println();
                System.out.println("Enter Account Type:");
                System.out.println("1. Saving");
                System.out.println("2. Current");

                System.out.print("Enter your choice: ");

                int choice2 = Integer.parseInt(sc.nextLine());


                String accountType;


                if (choice2 == 1) {

                    accountType = "saving";

                } else if (choice2 == 2) {

                    accountType = "current";

                } else {

                    System.out.println("Invalid account type.");
                    BankMenu();
                    break;
                }


                String accountNo = openAccount(name, accountType, aadharNo, balance, bankName);


                System.out.println();
                System.out.println("Account created successfully.");
                System.out.println("Account Number: " + accountNo);

                BankMenu();
                break;


            case 4:

                System.out.print("Enter customer name: ");
                String closeName = sc.nextLine();

                System.out.print("Enter account number: ");
                String closeAccountNo = sc.nextLine();


                Customer customer = CloseAccount(closeName, closeAccountNo);


                if (customer != null) {

                    System.out.println("Account closed successfully. " + customer.getAccountNo());

                } else {

                    System.out.println("Account not found.");

                }

                BankMenu();
                break;


            case 5:

                System.out.print("Enter UPI amount: ");
                float upiAmount = Float.parseFloat(sc.nextLine());


                System.out.print("Enter UPI ID: ");
                String upiId = sc.nextLine();


                System.out.print("Enter account number: ");
                String acNo = sc.nextLine();


                String upiResult = UpiTransaction(upiAmount, upiId, acNo);


                if (upiResult != null) {

                    System.out.println(upiResult);

                } else {

                    System.out.println("Transaction failed.");

                }

                BankMenu();
                break;


            case 6:

                System.out.print("Enter loan amount: ");
                float loanAmount = Float.parseFloat(sc.nextLine());


                System.out.print("Enter time (years): ");
                int loanTime = Integer.parseInt(sc.nextLine());


                System.out.print("Enter rate: ");
                float loanRate = Float.parseFloat(sc.nextLine());


                System.out.print("Enter Aadhar number: ");
                String loanAadhar = sc.nextLine();


                if (loanAadhar.length() != 12) {

                    System.out.println("Invalid Aadhar number.");
                    BankMenu();
                }


                System.out.print("Enter account number: ");
                String loanAccountNo = sc.nextLine();


                String loanResult = loan(loanAadhar, loanAmount, loanTime, loanRate, loanAccountNo);


                if (loanResult != null) {

                    System.out.println(loanResult);

                } else {

                    System.out.println("Loan failed.");

                }
                BankMenu();
                break;


            case 7:

                System.out.print("Enter Aadhar number: ");
                String insuranceAadhar = sc.nextLine();


                if (insuranceAadhar.length() != 12) {

                    System.out.println("Invalid Aadhar number.");
                    BankMenu();
                    break;
                }


                System.out.print("Enter account number: ");
                String insuranceAccountNo = sc.nextLine();


                System.out.print("Enter insurance amount: ");
                float insuranceAmount = Float.parseFloat(sc.nextLine());


                System.out.print("Enter time: ");
                int insuranceTime = Integer.parseInt(sc.nextLine());


                System.out.print("Enter interest: ");
                float insuranceInterest = Float.parseFloat(sc.nextLine());


                System.out.print("Enter rate: ");
                float insuranceRate = Float.parseFloat(sc.nextLine());


                System.out.print("Enter insurance type: ");
                String insuranceType = sc.nextLine();


                System.out.print("Enter insurance ID: ");
                String insuranceId = sc.nextLine();


                System.out.print("Enter insurance name: ");
                String insuranceName = sc.nextLine();


                System.out.print("Enter insurance number: ");
                String insuranceNo = sc.nextLine();


                System.out.print("Enter start date: ");
                String startDate = sc.nextLine();


                System.out.print("Enter end date: ");
                String endDate = sc.nextLine();


                String insuranceResult = insurance(insuranceAadhar, insuranceAccountNo, insuranceAmount, insuranceTime, insuranceInterest, insuranceRate, insuranceType, insuranceId, insuranceName, insuranceNo, startDate, endDate);


                if (insuranceResult != null) {

                    System.out.println(insuranceResult);

                } else {

                    System.out.println("Insurance failed.");

                }

                BankMenu();
                break;


            case 8:

                System.out.print("Enter account number: ");
                String cardAccountNo = sc.nextLine();


                System.out.print("Enter card number: ");
                String cardNo = sc.nextLine();


                System.out.print("Enter card holder name: ");
                String cardHolderName = sc.nextLine();


                System.out.print("Enter card type: ");
                String cardType = sc.nextLine();


                System.out.print("Enter card start date: ");
                String cardStartDate = sc.nextLine();


                System.out.print("Enter card end date: ");
                String cardEndDate = sc.nextLine();


                System.out.print("Enter CVV: ");
                String cardCvv = sc.nextLine();


                System.out.print("Enter card PIN: ");
                String cardPin = sc.nextLine();


                System.out.print("Enter card status: ");
                String cardStatus = sc.nextLine();


                String cardResult = creditCard(cardAccountNo, cardNo, cardHolderName, cardType, cardStartDate, cardEndDate, cardCvv, cardPin, cardStatus);


                if (cardResult != null) {

                    System.out.println(cardResult);

                } else {

                    System.out.println("Credit card failed.");

                }

                BankMenu();
                break;


            case 9:

                System.out.print("Enter account ID: ");
                String accountId = sc.nextLine();


                Customer foundCustomer = findAccount(accountId);


                if (foundCustomer != null) {

                    System.out.println("\n************ Account Found: **********\n");
//                    System.out.println("Customer Name: " + foundCustomer.getName());
//                    System.out.println("Account Number: " + foundCustomer.getAccountNo());
                    System.out.println(foundCustomer);

                } else {

                    System.out.println("\n*********** Account not found ***********");

                }

                BankMenu();
                break;


            case 10:

                System.out.print("Enter account number: ");
                String accountNo2 = sc.nextLine();


                Customer c = findAccount(accountNo2);


                if (c == null) {

                    System.out.println("Account not found.");
                    BankMenu();
                    break;
                }


                atm = new Atm(c);

                atm.checkPin();

                atm.menu();

                break;


            case 11:

                System.out.print("Enter account number: ");
                String accountNo3 = sc.nextLine();


                Customer c3 = findAccount(accountNo3);


                if (c3 == null) {

                    System.out.println("Account not found.");
                    BankMenu();
                    break;
                }


                System.out.println("Your Net Balance is " + checkBalance(accountNo3));
                BankMenu();
                break;

            case 12:
                System.out.print("\n================= TRANSACTION HISTORY =================\n");
                System.out.print("Enter Your Account No: ");
                String accountNo4 = sc.next();
                showTransactions(accountNo4);
                BankMenu();
                break;

            case 13:

                System.out.println("============= Thank you for visiting " + "Bank Of Baroda Bank. =============");

               return;


            default:

                System.out.println("Invalid choice. Please enter 1-12.");
                BankMenu();
                break;
        }
    }


    public void showTransactions(String accountNo){
        Customer c = findAccount(accountNo.trim());

        if (c == null) {
            System.out.println("Account not found.");
            return;
        }else{
            HashMap<String,Transactions> res = c.getTransactions(accountNo);
            for(String s:res.keySet()){
                Transactions temp = res.get(s);
                System.out.println(temp);
                System.out.println("\n");
            }
        }

        System.out.println("\n\n");

    }


    @Override
    public void withdraw(int amount, String accountNo) {

        Customer c = findAccount(accountNo.trim());

        Transactions t = new Transactions();
        t.transactionId = t.hashCode()+""+c.getAccountNo().substring(0,4);
        t.amount = amount;
        t.transactionType = "Withdrawal";
        t.transactionDate = new Date().toString();
        t.accountNo=accountNo;


        if (c == null) {

            System.out.println("Account not found.");

            return;
        }


        System.out.println("Withdrawal amount: " + amount);


        if (amount <= c.getBalance()) {

            c.setBalance(c.getBalance() - amount);

            System.out.println("Withdrawal successful.");

            System.out.println("Remaining balance: " + c.getBalance());

            transactions.put(t.transactionId, t);
            c.setTransactions(transactions);

        } else {

            System.out.println("Insufficient balance.");
        }
    }


    @Override
    public void deposit(int amount, String accountNo) {

        Customer c = findAccount(accountNo.trim());

        Transactions t = new Transactions();
        t.transactionId = t.hashCode()+""+c.getAccountNo().substring(0,4);
        t.amount = amount;
        t.transactionType = "Deposite";
        t.transactionDate = new Date().toString();
        t.accountNo = accountNo;

        if (c == null) {

            System.out.println("Account not found.");

            return;
        }


        System.out.println("Deposit amount: " + amount);


        c.setBalance(c.getBalance() + amount);

        transactions.put(t.transactionId, t);
        c.setTransactions(transactions);

        System.out.println("Deposit successful.");

        System.out.println("Current balance: " + c.getBalance());
    }


    private float checkBalance(String accountNo) {

        Customer c = findAccount(accountNo);


        if (c == null) {

            return 0;
        }


        return c.getBalance();
    }


    @Override
    public String openAccount(String name, String accountType, String AdharNo, int bal, String bankName) {

        Customer c1 = new Customer();

        c1.setName(name.toUpperCase());

        c1.setAdharNo(AdharNo);

        c1.setAccountType(accountType);

        c1.setBalance(bal);

        c1.setBankName(bankName);

        String hCode = c1.hashCode()+""; //  Integer.toString(n);

        c1.setAccountNo(accountPref +bankName + AdharNo.substring(5, 7) + hCode.substring(6,9));

        Transactions t = new Transactions();
        t.transactionId = t.hashCode()+""+c1.getAccountNo().substring(0,4);
        t.amount = bal;
        t.transactionType = "Open Account";
        t.transactionDate = new Date().toString();
        t.accountNo = c1.getAccountNo();

        customers.put(c1.getAccountNo(), c1);

        transactions.put(t.transactionId, t);
        c1.setTransactions(transactions);

        return c1.getAccountNo();
    }


    @Override
    public Customer CloseAccount(String name, String accountNo) {

        Customer c1 = customers.remove(accountNo.trim());


        return c1;
    }


    @Override
    public String UpiTransaction(float amount, String upiId, String acountno) {

        Customer c = findAccount(acountno.trim());

        Transactions t = new Transactions();
        t.transactionId = t.hashCode()+""+c.getAccountNo().substring(0,4);
        t.amount = amount;
        t.transactionType = "Upi Transaction";
        t.transactionDate = new Date().toString();
        t.accountNo = acountno;

        if (c != null && amount <= c.getBalance()) {

            c.setBalance(c.getBalance() - amount);

            transactions.put(t.transactionId, t);
            c.setTransactions(transactions);

            return "Transaction successful.";
        } else {

            return "Insufficient balance.";
        }
    }


    @Override
    public String loan(String AdharNo, float amount, int time, float rate, String accountNo) {

        Customer c = customers.get(accountNo.trim());


        float si = amount * time * rate / 100;


        float totalAmount = amount + si;


        if (c != null) {

            c.setBalance(c.getBalance() + totalAmount);


            return "Loan successful With SI " + si + " totalAmount is " + totalAmount;

        } else {

            return "Loan failed.";
        }
    }


    @Override
    public String insurance(String AdharNo, String accountNo, float amount, int time, float intrest, float rate, String insuranceType, String insuranceId, String insuranceName, String insuranceNo, String insuranceStartDate, String insuranceEndDate) {

        Customer c1 = customers.get(accountNo.trim());


        float si = amount * time * intrest / 100;


        float totalAmount = amount + si;


        if (c1 != null) {

            c1.setBalance(c1.getBalance() + totalAmount);


            return "Insurance successful.";

        } else {

            return "Insurance failed.";
        }
    }


    @Override
    public String creditCard(String accountNo, String cardNo, String cardHolderName, String cardType, String cardStartDate, String cardEndDate, String cardCvv, String cardPin, String cardStatus) {

        Customer c1 = customers.get(accountNo.trim());


        if (c1 != null) {

            c1.setUpiId(cardNo);


            return "Credit card successful.";

        } else {

            return "Credit Card Not Approved";
        }
    }


    // =============================================================


    @Override
    public Customer findAccount(String accountId) {

        return customers.get(accountId.trim());
    }

}