package se.lexicon.exercises.exercise1;

public class ShoppingReceipt {

    public static void main(String[] args) {
        // Artiklar, kvantiteter och priser
        String item1 = "Apple";
        int qty1 = 2;
        double price1 = 15.00;

        String item2 = "Milk";
        int qty2 = 1;
        double price2 = 22.50;

        String item3 = "Bread";
        int qty3 = 3;
        double price3 = 18.00;

        // Beräkna totalpriser per rad
        double total1 = qty1 * price1;
        double total2 = qty2 * price2;
        double total3 = qty3 * price3;

        // Beräkna grand total
        double grandTotal = total1 + total2 + total3;

        // Utskrift av kvittot
        System.out.println("========================================");
        System.out.println("                Receipt                 ");
        System.out.println("========================================");

        System.out.printf("%-10s %d x %.2f = %.2f SEK%n", item1, qty1, price1, total1);
        System.out.printf("%-10s %d x %.2f = %.2f SEK%n", item2, qty2, price2, total2);
        System.out.printf("%-10s %d x %.2f = %.2f SEK%n", item3, qty3, price3, total3);

        System.out.println("----------------------------------------");
        System.out.printf("Grand Total:              %.2f SEK%n", grandTotal);
        System.out.println("========================================");
    }
}
