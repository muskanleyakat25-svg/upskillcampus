import java.util.ArrayList;
import java.util.Scanner;

public class BankingInformationSystem {

    static Scanner sc = new Scanner(System.in);
    static String accountHolder = "Muskan";
    static String accountNumber = "1234567890";
    static double balance = 5000.00;
    static ArrayList<String> transactions = new ArrayList<>();

    // Display account details
    static void accountDetails() {
        System.out.println("\n----- ACCOUNT DETAILS -----");
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.printf("Balance: Rs. %.2f%n", balance);
    }

    // Check account balance
    static void checkBalance() {
        System.out.println("\n----- ACCOUNT BALANCE -----");
        System.out.printf("Available Balance: Rs. %.2f%n", balance);
    }

    // Deposit money
    static void depositMoney() {
        System.out.print("\nEnter deposit amount: Rs. ");

        if (!sc.hasNextDouble()) {
            System.out.println("Invalid amount!");
            sc.nextLine();
            return;
        }

        double amount = sc.nextDouble();
        sc.nextLine();

        if (amount <= 0 || !Double.isFinite(amount)) {
            System.out.println("Please enter a valid positive amount.");
        } else {
            balance += amount;
            transactions.add("Deposited: Rs. " + amount);
            System.out.println("Money deposited successfully!");
            System.out.printf("New Balance: Rs. %.2f%n", balance);
        }
    }

    // Withdraw money
    static void withdrawMoney() {
        System.out.print("\nEnter withdrawal amount: Rs. ");

        if (!sc.hasNextDouble()) {
            System.out.println("Invalid amount!");
            sc.nextLine();
            return;
        }

        double amount = sc.nextDouble();
        sc.nextLine();

        if (amount <= 0 || !Double.isFinite(amount)) {
            System.out.println("Please enter a valid positive amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            transactions.add("Withdrawn: Rs. " + amount);
            System.out.println("Withdrawal successful!");
            System.out.printf("Remaining Balance: Rs. %.2f%n", balance);
        }
    }

    // Display transaction history
    static void transactionHistory() {
        System.out.println("\n----- TRANSACTION HISTORY -----");

        if (transactions.isEmpty()) {
            System.out.println("No transactions available.");
        } else {
            for (int i = 0; i < transactions.size(); i++) {
                System.out.println((i + 1) + ". " + transactions.get(i));
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        int choice = 0;

        System.out.println("==================================");
        System.out.println("  BANKING INFORMATION SYSTEM");
        System.out.println("==================================");
        System.out.println("Welcome, " + accountHolder + "!");

        do {
            System.out.println("\n========== MAIN MENU ==========");
            System.out.println("1. Account Details");
            System.out.println("2. Check Balance");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");
            System.out.println("===============================");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Please enter a number from 1 to 6.");
                sc.nextLine();
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    accountDetails();
                    break;

                case 2:
                    checkBalance();
                    break;

                case 3:
                    depositMoney();
                    break;

                case 4:
                    withdrawMoney();
                    break;

                case 5:
                    transactionHistory();
                    break;

                case 6:
                    System.out.println("\nThank you for using");
                    System.out.println("Banking Information System!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}