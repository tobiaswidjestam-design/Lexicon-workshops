package se.lexicon.workshops.week45;
// This fruit is not fresh
public class oldFruit extends Product {
    private String origin;

    public oldFruit(int id, String name, int price, int quantity, String origin) {
        super(id, name, price, quantity);
        this.origin = origin;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String describe() {
        return getName() + " (Fruit, " + origin + ")";
    }
}
