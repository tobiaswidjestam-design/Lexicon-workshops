package se.lexicon.exercises.oop_exercise_thebank;

public abstract class Account {

    private String holder;
    private double balance;

    public Account(String holder, double balance) {
        if (holder == null || holder.trim().isEmpty()) {
            throw new IllegalArgumentException("holder name cannot be empty");
        }

        if (balance < 0) {
            throw new IllegalArgumentException("balance cannot be negative");
        }

        this.holder = holder;
        this.balance = balance;
    }

    public String getHolder() {
        return holder;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("amount cannot be negative");
        }
        balance += amount;
    }

    public abstract void processMonth();

    public void printSummary() {
        System.out.println(holder + " | Balance:" + balance + " Kr ");
    }
}
