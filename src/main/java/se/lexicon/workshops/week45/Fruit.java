package se.lexicon.workshops.week45;
// A Fruit Class Made By Widjestam-Design-2026-11-version-06

public class Fruit extends Product {
    private String origin;

    public Fruit(int id, String name, int price, int quantity, String origin) {
        super(id, name, price, quantity);
        this.origin = origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getOrigin() {
        return origin;
    }


    @Override
    public void print() { System.out.println(getName() + " (Fruit, " + origin + ")");}
}