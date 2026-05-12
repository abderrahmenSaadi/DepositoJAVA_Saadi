import java.util.ArrayList;
import java.util.Scanner;

public class BankSystem {
    private static ArrayList<BankAccount> accounts = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample accounts
        accounts.add(new BankAccount("Alice", "1234"));
        accounts.add(new BankAccount("Bob", "abcd"));

        System.out.println("=== Bank Login ===");

        System.out.print("Enter account name: ");
        String name = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        BankAccount loggedAccount = login(name, password);

        if (loggedAccount != null) {
            System.out.println("Login successful!");
            runAccountMenu(scanner, loggedAccount);
        } else {
            System.out.println("Invalid credentials.");
        }

        scanner.close();
    }

    // Login method
    public static BankAccount login(String name, String password) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountHolderName().equals(name) && acc.authenticate(password)) {
                return acc;
            }
        }
        return null;
    }

    // Menu
    public static void runAccountMenu(Scanner scanner, BankAccount account) {
        int choice;

        do {
            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Balance");
            System.out.println("4. Exit");
            System.out.print("Choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 3:
                    account.displayBalance();
                    break;

                case 4:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option.");
            }

        } while (choice != 4);
    }
}