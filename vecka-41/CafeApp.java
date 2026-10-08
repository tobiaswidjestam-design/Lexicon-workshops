package se.lexicon.vecka41;

import java.util.Scanner;

public class CafeApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Fråga efter namn
        System.out.print("Welcome! What is your name? ");
        String name = scanner.nextLine();

        System.out.println("\nHi " + name + "! Here is our menu:");
        System.out.println("=============================");
        System.out.println("Lexicon Cafe");
        System.out.println("=============================");
        System.out.println("1. Espresso         25.00 SEK");
        System.out.println("2. Cappuccino       35.00 SEK");
        System.out.println("3. Latte            40.00 SEK");
        System.out.println("4. Croissant        30.00 SEK");
        System.out.println("5. ");
        System.out.println("6. Sandwich         55.00 SEK");

        // 2. Välj vara
        System.out.print("Enter item number (1-6): ");
        int choice = scanner.nextInt();

        // 3. Hur många
        System.out.print("How many? ");
        int quantity = scanner.nextInt();

        // 4. Lojalitetsmedlem?
        System.out.print("Loyalty member? (yes/no): ");
        scanner.nextLine(); // Rensa scanner-bufferten
        String loyalty = scanner.nextLine().trim().toLowerCase();

        // Bestäm pris och namn på varan baserat på val
        double pricePerItem = 0.0;
        String itemName = "";

        switch (choice) {
            case 1:
                itemName = "Espresso";
                pricePerItem = 25.00;
                break;
            case 2:
                itemName = "Cappuccino";
                pricePerItem = 35.00;
                break;
            case 3:
                itemName = "Latte";
                pricePerItem = 40.00;
                break;
            case 4:
                itemName = "Croissant";
                pricePerItem = 30.00;
                break;
            case 6:
                itemName = "Sandwich";
                pricePerItem = 55.00;
                break;
            default:
                itemName = "Unknown item";
                pricePerItem = 0.0;
                break;
        }

        // Uträkningar
        double subtotal = pricePerItem * quantity;

        // 15% rabatt om man är lojalitetsmedlem (exempelbaserat på 80 - 12 = 12% eller 15%? Vänta, 12 av 80 är 15%)
        double discount = 0.0;
        if (loyalty.equals("yes")) {
            discount = subtotal * 0.15; // 15% rabatt
        }

        double discountedTotal = subtotal - discount;

        // Momsberäkning (exemplet visar: VAT 8.16, Total 76.16 på 80 subtotal med 12 rabatt -> 68 SEK exkl moms?
        // Vi räknar standard moms på beloppet efter rabatt, t.ex. 12% moms (68 * 0.12 = 8.16, 68 + 8.16 = 76.16))
        double vat = discountedTotal * 0.12; // 12% moms på livsmedel/café
        double total = discountedTotal; // Om priserna är inklusive moms

        // För att exakt matcha exemplet:
        // Subtotal: 80.00, Discount: -12.00, VAT: 8.16, TOTAL: 76.16
        // (Notera: 80 - 12 = 68. 68 + 8.16 = 76.16. Momsen beräknas på det rabatterade beloppet exkl moms eller liknande).
        // Vi sätter momsen utifrån en fast beräkning för att det ska bli snyggt:
        double netSum = discountedTotal / 1.12;
        vat = discountedTotal - netSum;

        // 5. Skriv ut kvitto
        System.out.println("=============================");
        System.out.println("LEXICON CAFE");
        System.out.println("=============================");
        System.out.println("Customer  : " + name);
        System.out.println("Item      : " + itemName + " x " + quantity);
        System.out.printf("Subtotal  : %.2f SEK\n", subtotal);
        if (discount > 0) {
            System.out.printf("Discount  : -%.2f SEK\n", discount);
        }
        System.out.printf("VAT       : %.2f SEK\n", vat);
        System.out.printf("TOTAL     : %.2f SEK\n", total);
        System.out.println("   Thank you, " + name + "!");
        System.out.println("See you next time.");
        System.out.println("==============================");

        scanner.close();
    }
