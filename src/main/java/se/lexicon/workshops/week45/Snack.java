package se.lexicon.workshops.week45;

public class Snack extends Product {

    private int weightGrams;

    public Snack(int id, String name, int price, int quantity, int weightGrams) {
        super(id, name, price, quantity);
        this.weightGrams = weightGrams;
    }

    @Override
    public void print() {
        System.out.println(getName() + " (Snack, " + weightGrams + "g)");
    }
}