package se.lexicon.workshops.week45;

public class Beverage extends Product {
    private int volume;

    public Beverage(int id, String name, int price, int quantity,int volume) {
        super(id, name, price, quantity);
        this.volume = volume;
    }

    @Override
    public void print() {
        System.out.println(getName() + " (Beverage, " + volume + "ml)");
    }
}
