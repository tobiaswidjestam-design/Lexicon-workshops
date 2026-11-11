package se.lexicon.sandbox;


import java.util.List;
public class lambda {

    public static void main(String[] args) {

        books bok = new books("Fundamentals1", 200, 1);
        books bok2 = new books("Fundamentals2", 500, 2);
        books bok3 = new books("Fundamentals3", 600, 3);

        List<books> allBooks = List.of(bok,bok2,bok3);
        allBooks.stream()
        .forEach(e -> System.out.println("Bok: " + e.name + ", Pris: " + e.price));

        books mostExpansive = allBooks.stream()
                .max((b1, b2) -> Integer.compare(b1.price, b2.price))
                .orElse(null);

        System.out.println("Dyraste boken: " + mostExpansive.name + " (" + mostExpansive.price + " kr)");
    }

}
class books{

    String name;
    int price;
    int quantity;

    books(String name, int price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}