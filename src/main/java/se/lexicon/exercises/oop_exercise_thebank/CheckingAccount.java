package se.lexicon.exercises.oop_exercise_thebank;

public class CheckingAccount extends Account {

    private double overDraftLimit;


    public CheckingAccount(String holder, double balance, double overDraftLimit) {
        super(holder, balance);
        this.overDraftLimit = overDraftLimit;
    }

    public double getOverDraftLimit() {
        return overDraftLimit;
    }

    @Override
    public void processMonth() {
        // Checking accounts might not earn interest in the same way,
        // or you could add logic for potential fees here.
    }

}