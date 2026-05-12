import java.util.Objects;

public class BankAccount {
    private String accountHolderName;
    private double balance;
    private String passwordHash;

    // Constructor
    public BankAccount(String accountHolderName, String password) {
        this.accountHolderName = accountHolderName;
        this.balance = 0.0;
        this.passwordHash = Integer.toString(password.hashCode());
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (balance - amount < 0) {
            System.out.println("Insufficient funds. Withdrawal denied.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful: " + amount);
        }
    }

    // Display balance
    public void displayBalance() {
        System.out.println("Current balance: " + balance);
    }

    // Credential check
    public boolean authenticate(String password) {
        return passwordHash.equals(Integer.toString(password.hashCode()));
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    // toString override
    @Override
    public String toString() {
        return "BankAccount{" +
                "accountHolderName='" + accountHolderName + '\'' +
                ", balance=" + balance +
                '}';
    }

@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    BankAccount that = (BankAccount) o;
    return Objects.equals(accountHolderName, that.accountHolderName);
}

    // hashCode override
    @Override
    public int hashCode() {
        return Objects.hash(accountHolderName);
    }
}