package se.lexicon.exercises.oop_exercise_thebank;

public class SavingsAccount extends Account {

    double interestRate;

    SavingsAccount(String holder, double balance, double intrestRate) {

        super(holder, balance);
        this.interestRate = intrestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public void processMonth() {
        double interest = getBalance() * (interestRate  / 100.0);
        deposit(interest);
    }
}
