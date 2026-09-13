import java.util.Scanner;
class BankAccount {
private String accountNumber;
private String accountHolderName;
private double balance;
public BankAccount(String accountNumber, String accountHolderName, double balance) {
    setAccountNumber(accountNumber);
    setAccountHolderName(accountHolderName);
    setBalance(balance);
}
public String getAccountNumber() {
    return accountNumber;
}
public void setAccountNumber(String accountNumber) {
    if (accountNumber != null && !accountNumber.trim().isEmpty() && accountNumber.trim().length() >= 5) {
        this.accountNumber = accountNumber;
    } else {
        this.accountNumber = "00000";
    }
}
public String getAccountHolderName() {
    return accountHolderName;
}
public void setAccountHolderName(String accountHolderName) {
    if (accountHolderName != null && !accountHolderName.trim().isEmpty() && accountHolderName.trim().length() >= 3) {
        this.accountHolderName = accountHolderName;
    } else {
        this.accountHolderName = "Unknown";
    }
}
public double getBalance() {
    return balance;
}
public void setBalance(double balance) {
    if (balance >= 0) {
        this.balance = balance;
    } else {
        this.balance = 0;
    }
}
public void deposit(double amount) {
    if (amount > 0) {
        balance += amount;
    } else {
        System.out.println("Invalid Deposit Amount");
    }
}
public void withdraw(double amount) {
    if (amount > 0 && amount <= balance) {
        balance -= amount;
    } else {
        System.out.println("Insufficient Balance");
    }
}
public void displayAccountDetails() {
    System.out.println("Account Number: " + accountNumber);
    System.out.println("Account Holder Name: " + accountHolderName);
    System.out.println("Available Balance: " + balance);
}
}
public class Main {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
    System.out.print("Enter Account Number: ");
    String accountNumber = sc.nextLine();
    while (accountNumber.trim().isEmpty() || accountNumber.trim().length() < 5) {
        System.out.println("Account number must contain at least 5 characters.");
        System.out.print("Enter Account Number: ");
        accountNumber = sc.nextLine();
    }
    System.out.print("Enter Account Holder Name: ");
    String accountHolderName = sc.nextLine();
    while (accountHolderName.trim().isEmpty() || accountHolderName.trim().length() < 3) {
        System.out.println("Name must contain at least 3 characters.");
        System.out.print("Enter Account Holder Name: ");
        accountHolderName = sc.nextLine();
    }
    System.out.print("Enter Initial Balance: ");
    double initialBalance = sc.nextDouble();
    while (initialBalance < 0) {
        System.out.println("Initial balance cannot be negative.");
        System.out.print("Enter Initial Balance: ");
        initialBalance = sc.nextDouble();
    }
    BankAccount account = new BankAccount(accountNumber, accountHolderName, initialBalance);
    account.displayAccountDetails();
    System.out.print("Depositing: ");
    double depositAmount = sc.nextDouble();
    account.deposit(depositAmount);
    System.out.print("Withdrawal: ");
    double withdrawalAmount = sc.nextDouble();
    account.withdraw(withdrawalAmount);
    System.out.println("Updated Balance: " + account.getBalance());
    sc.close();
}
}
