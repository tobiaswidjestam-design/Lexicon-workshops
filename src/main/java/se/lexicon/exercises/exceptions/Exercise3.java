package se.lexicon.exercises.exceptions;

public class Exercise3 {

    void main() {
        BankAccount account = new BankAccount("Tobias", 1000.0);

        try {
            account.deposit(500.0);
            account.withdraw(300.0);
            account.withdraw(2000.0); // Triggar InsufficientBalanceException
        } catch (InsufficientBalanceException | IllegalArgumentException e) {
            IO.println("Transaction failed: " + e.getMessage());
        }

        IO.println("Final balance for " + account.getAccountHolder() + ": " + account.getBalance() + " kr");
    }
}

class BankAccount {
    private final String accountHolder;
    private double balance;

    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        balance += amount;
        IO.println("Deposited: " + amount + " kr | New balance: " + balance + " kr");
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException(
                    "Insufficient funds! Attempted to withdraw " + amount + " kr, but balance is only " + balance + " kr."
            );
        }
        balance -= amount;
        IO.println("Withdrew: " + amount + " kr | New balance: " + balance + " kr");
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}