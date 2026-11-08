package se.lexicon.workshops.week45;

public abstract class Product {

    private String name;
    private int price;
    private int quantity;
    private int id;


    public Product(int id, String name, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }


    public String getName(){return name;}
    public int getPrice(){return price;}
    public int getId(){return id;}
    public int getQuantity(){return quantity;}
    public abstract void print();
    public void reduceQuantity(){quantity--;}


}
