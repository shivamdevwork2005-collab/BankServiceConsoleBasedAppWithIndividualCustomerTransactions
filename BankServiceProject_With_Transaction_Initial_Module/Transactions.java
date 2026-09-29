package BankServiceProject_With_Transaction_Initial_Module;

public class Transactions {

    String transactionId;
    float amount;
    String transactionType;
    String transactionDate;
    String accountNo;

    @Override
    public String toString() {
        return "\n=========================== Transaction Details ==========================" +
                "\nTransaction ID   : " + transactionId +
                "\nAmount           : Rs" + amount +
                "\nTransaction Type : " + transactionType +
                "\nTransaction Date : " + transactionDate +
                "\n==========================================================================";
    }
}
