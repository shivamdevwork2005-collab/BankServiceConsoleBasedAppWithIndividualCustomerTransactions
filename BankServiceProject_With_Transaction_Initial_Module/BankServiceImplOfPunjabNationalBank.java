package BankServiceProject_With_Transaction_Initial_Module;

import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class BankServiceImplOfPunjabNationalBank implements BankService {

    Scanner sc = new Scanner(System.in);

    HashMap<String, Customer> customers = new HashMap<>();
    static HashMap<String, Transactions> transactions = new HashMap<>();

    Atm atm;

    private static String accountPref = "20560100031";

    @Override
    public void visitBank() {
        System.out.println("========== Welcome to National Bank 🏦 Of Punjab ==========");
        BankMenu();
    }

    @Override
    public void BankMenu() {

        System.out.println();
        System.out.println("========== National Bank Of Punjab BANK MENU ==========");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Open Account");
        System.out.println("4. Close Account");
        System.out.println("5. UPI Transaction");
        System.out.println("6. Loan");
        System.out.println("7. Insurance");
        System.out.println("8. Credit Card");
        System.out.println("9. Find Account");
        System.out.println("10. Use Atm Service of National Bank Of Punjab");
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

                System.out.print("Enter amount 💵 to withdraw: ");
                int withdrawAmount = Integer.parseInt(sc.nextLine());

                System.out.print("Enter account number: ");
                String withdrawAccountNo = sc.nextLine();

                withdraw(withdrawAmount, withdrawAccountNo);
                BankMenu();
                break;

            case 2:

                System.out.print("Enter amount 💵 to deposit: ");
                int depositAmount = Integer.parseInt(sc.nextLine());

                System.out.print("Enter account number: ");
                String depositAccountNo = sc.nextLine();

                deposit(depositAmount, depositAccountNo);
                BankMenu();
                break;

            case 3:

                System.out.print("Enter customer name: ");
                String name = sc.nextLine();

                System.out.println("Enter Account Type:");
                System.out.println("1. Saving");
                System.out.println("2. Current");

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

//                System.out.println("Select Bank:");
//                System.out.println("1. BOB");
//                System.out.println("2. PNB");
//                System.out.println("3. HDFC");
//                System.out.println("4. SBI");
//
//                int choice3 = Integer.parseInt(sc.nextLine());

                String bankName = "PNB";

//                if (choice3 == 1) {
//                    bankName = "BOB";
//                } else if (choice3 == 2) {
//                    bankName = "PNB";
//                } else if (choice3 == 3) {
//                    bankName = "HDFC";
//                } else if (choice3 == 4) {
//                    bankName = "SBI";
//                } else {
//                    System.out.println("Invalid bank choice.");
//                    BankMenu();
//                    break;
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

                String accountNo = openAccount(
                        name,
                        accountType,
                        aadharNo,
                        balance,
                        bankName
                );

                System.out.println("Account created successfully.");
                System.out.println("Account Number: " + accountNo);

                BankMenu();
                break;

            case 4:

                System.out.print("Enter customer name: ");
                String closeName = sc.nextLine();

                System.out.print("Enter account number: ");
                String closeAccountNo = sc.nextLine();

                Customer customer = CloseAccount(
                        closeName,
                        closeAccountNo
                );

                if (customer != null) {
                    System.out.println(
                            "Account closed successfully. "
                                    + customer.getAccountNo()
                    );
                } else {
                    System.out.println("Account not found.");
                }

                BankMenu();
                break;

            case 5:

                System.out.print("Enter UPI amount 💵: ");
                float upiAmount = Float.parseFloat(sc.nextLine());

                System.out.print("Enter UPI ID: ");
                String upiId = sc.nextLine();

                System.out.print("Enter account number: ");
                String acNo = sc.nextLine();

                String upiResult = UpiTransaction(
                        upiAmount,
                        upiId,
                        acNo
                );

                System.out.println(upiResult);

                BankMenu();
                break;

            case 6:

                System.out.print("Enter loan 💵 amount: ");
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
                    break;
                }

                System.out.print("Enter account number: ");
                String loanAccountNo = sc.nextLine();

                String loanResult = loan(
                        loanAadhar,
                        loanAmount,
                        loanTime,
                        loanRate,
                        loanAccountNo
                );

                System.out.println(loanResult);

                BankMenu();
                break;

            case 7:

                System.out.print("Enter Aadhar number: ");
                String insuranceAadhar = sc.nextLine();

                System.out.print("Enter account number: ");
                String insuranceAccountNo = sc.nextLine();

                System.out.print("Enter insurance 💵 amount: ");
                float insuranceAmount =
                        Float.parseFloat(sc.nextLine());

                System.out.print("Enter time: ");
                int insuranceTime =
                        Integer.parseInt(sc.nextLine());

                System.out.print("Enter interest: ");
                float insuranceInterest =
                        Float.parseFloat(sc.nextLine());

                System.out.print("Enter rate: ");
                float insuranceRate =
                        Float.parseFloat(sc.nextLine());

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

                String insuranceResult = insurance(
                        insuranceAadhar,
                        insuranceAccountNo,
                        insuranceAmount,
                        insuranceTime,
                        insuranceInterest,
                        insuranceRate,
                        insuranceType,
                        insuranceId,
                        insuranceName,
                        insuranceNo,
                        startDate,
                        endDate
                );

                System.out.println(insuranceResult);

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

                String cardResult = creditCard(
                        cardAccountNo,
                        cardNo,
                        cardHolderName,
                        cardType,
                        cardStartDate,
                        cardEndDate,
                        cardCvv,
                        cardPin,
                        cardStatus
                );

                System.out.println(cardResult);

                BankMenu();
                break;

            case 9:

                System.out.print("Enter account ID: ");
                String accountId = sc.nextLine();

                Customer foundCustomer = findAccount(accountId);

                if (foundCustomer != null) {
                    System.out.println("Account Found:");
//                    System.out.println(foundCustomer.getName());
                    System.out.println(foundCustomer);
                } else {
                    System.out.println("Account not found.");
                }

                BankMenu();
                break;

            case 10:

                System.out.print("Enter account number:- ");
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

                System.out.print("Enter account number:- ");
                String accountNo3 = sc.nextLine();

                Customer c3 = findAccount(accountNo3);

                if (c3 == null) {
                    System.out.println("Account not found.");
                    BankMenu();
                    break;
                }

                System.out.println(
                        "Your Net Balance is "
                                + checkBalance(accountNo3)
                );

                BankMenu();
                break;

            case 12:
                System.out.print("\n========== TRANSACTION HISTORY ==========\n");
                System.out.print("Enter Your Account No: ");
                String accountNo4 = sc.next();
                showTransactions(accountNo4);
                BankMenu();
                break;


            case 13:

                System.out.println(
                        "============= Thank you for visiting National Bank Of Punjab Bank.=================="
                );

                return;

            default:

                System.out.println(
                        "Invalid choice. Please enter 1-12."
                );
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

        if (c == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.println("Withdrawal 💵 amount: " + amount);

        if (amount <= c.getBalance()) {

            float balance = c.getBalance();
            balance -= amount;
            c.setBalance(balance);

            transactions.put(t.transactionId, t);
            c.setTransactions(transactions);

            System.out.println("Withdrawal successful.");

        } else {

            System.out.println("Insufficient 💵 balance.");
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

        if (c == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.println("Deposit 💵 amount: " + amount);

        float balance = c.getBalance();
        balance += amount;

        c.setBalance(balance);

        transactions.put(t.transactionId, t);
        c.setTransactions(transactions);

        System.out.println("Deposit successful.");
    }

    private float checkBalance(String accountNo) {

        Customer c = findAccount(accountNo);

        if (c == null) {
            return 0;
        }

        return c.getBalance();
    }

    @Override
    public String openAccount(
            String name,
            String accountType,
            String AdharNo,
            int bal,
            String bankName) {

        Customer c1 = new Customer();

        c1.setName(name.toUpperCase());
        c1.setAdharNo(AdharNo);
        c1.setBalance(bal);
        c1.setAccountType(accountType);
        c1.setBankName(bankName);

        String hCode = c1.hashCode()+""; //  Integer.toString(n);
        c1.setAccountNo(accountPref +bankName + AdharNo.substring(5, 7) + hCode.substring(6,9));

        Transactions t = new Transactions();
        t.transactionId = t.hashCode()+""+c1.getAccountNo().substring(0,4);
        t.amount = bal;
        t.transactionType = "Open Account";
        t.transactionDate = new Date().toString();

        transactions.put(t.transactionId, t);
        c1.setTransactions(transactions);

        customers.put(c1.getAccountNo(), c1);

        return c1.getAccountNo();
    }

    @Override
    public Customer CloseAccount(String name, String accountNo) {

        Customer c1 = customers.remove(accountNo.trim());

        return c1;
    }

    @Override
    public String UpiTransaction(
            float amount,
            String upiId,
            String acountno) {

        Customer c = findAccount(acountno.trim());

        Transactions t = new Transactions();
        t.transactionId = t.hashCode()+""+c.getAccountNo().substring(0,4);
        t.amount = amount;
        t.transactionType = "Upi Transaction";
        t.transactionDate = new Date().toString();

        if (c == null) {
            return "Account not found.";
        }

        if (amount <= c.getBalance()) {

            float balance = c.getBalance();
            balance -= amount;

            c.setBalance(balance);

            transactions.put(t.transactionId, t);
            c.setTransactions(transactions);

            return "Transaction 💵 successful.";

        } else {

            return "Insufficient 💵 balance.";
        }
    }

    @Override
    public String loan(
            String AdharNo,
            float amount,
            int time,
            float rate,
            String accountNo) {

        Customer c = customers.get(accountNo.trim());

        if (c == null) {
            return "Loan failed.";
        }

        float si = amount * time * rate / 100;
        float totalAmount = amount + si;

        float balance = c.getBalance();
        balance += totalAmount;

        c.setBalance(balance);

        return "Loan successful With Si "
                + si
                + " totalAMount is "
                + totalAmount;
    }

    @Override
    public String insurance(
            String AdharNo,
            String accountNo,
            float amount,
            int time,
            float intrest,
            float rate,
            String insuranceType,
            String insuranceId,
            String insuranceName,
            String insuranceNo,
            String insuranceStartDate,
            String insuranceEndDate) {

        Customer c1 = customers.get(accountNo.trim());

        if (c1 == null) {
            return "Insurance failed.";
        }

        float si = amount * time * intrest / 100;
        float totalAmount = amount + si;

        float balance = c1.getBalance();
        balance += totalAmount;

        c1.setBalance(balance);

        return "Insurance successful.";
    }

    @Override
    public String creditCard(
            String accountNo,
            String cardNo,
            String cardHolderName,
            String cardType,
            String cardStartDate,
            String cardEndDate,
            String cardCvv,
            String cardPin,
            String cardStatus) {

        Customer c1 = customers.get(accountNo.trim());

        if (c1 != null) {

            c1.setUpiId(cardNo);

            return "Credit card successful.";

        } else {

            return "Credit Card Not Approved";
        }
    }

    @Override
    public Customer findAccount(String accountId) {

        return customers.get(accountId.trim());
    }
}