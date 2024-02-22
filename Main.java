import java.util.Scanner;

// BankAccount class to represent the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true; // Withdrawal successful
        } else {
            return false; // Insufficient balance
        }
    }
}

// ATM class to represent the ATM machine
class ATM {
    private BankAccount bankAccount;
    private Scanner scanner;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        this.scanner = new Scanner(System.in);
    }

    // Display ATM menu and handle user options
    public void displayMenu() {
        boolean exit = false;

        while (!exit) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to check balance
    private void checkBalance() {
        double balance = bankAccount.getBalance();
        System.out.println("Your current balance is: $" + balance);
    }

    // Method to withdraw money
    private void withdraw() {
        System.out.print("Enter amount to withdraw: $");
        double amount = scanner.nextDouble();

        if (bankAccount.withdraw(amount)) {
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    // Method to deposit money
    private void deposit() {
        System.out.print("Enter amount to deposit: $");
        double amount = scanner.nextDouble();
        bankAccount.deposit(amount);
        System.out.println("Deposit successful.");
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a bank account with an initial balance
        BankAccount bankAccount = new BankAccount(1000.0);

        // Create an ATM object with the bank account
        ATM atm = new ATM(bankAccount);

        // Display the ATM menu
        atm.displayMenu();
    }
}

