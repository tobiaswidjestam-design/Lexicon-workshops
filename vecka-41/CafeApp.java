package se.lexicon.workshops.week41;

import java.util.Scanner;

/**
 * Workshop Week 41 - Lexicon Cafe Application
 *
 * Demonstrates basic input/output, control flow, arithmetic operations,
 * and organizing application logic into focused, single-responsibility methods.
 */
public class CafeApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Greet the customer and request name
        System.out.print("Welcome! What is your name? ");
        String customerName = scanner.nextLine().trim();

        System.out.println("Hi " + customerName + "! Here is our menu:\n");
        displayMenu();

        // 2. Select menu item and quantity
        System.out.print("Enter item number (1-5): ");
        int choice = scanner.nextInt();

        System.out.print("How many? ");
        int quantity = scanner.nextInt();

        // 3. Inquire about loyalty membership
        System.out.print("Loyalty member? (yes/no): ");
        scanner.nextLine(); // Consume trailing newline left by nextInt()
        String loyaltyInput = scanner.nextLine().trim().toLowerCase();
        boolean isMember = loyaltyInput.equals("yes");

        // 4. Perform calculations using dedicated helper methods
        String itemName = getItemName(choice);
        double unitPrice = getItemPrice(choice);
        double subtotal = calculateSubtotal(unitPrice, quantity);
        double discount = calculateDiscount(subtotal, isMember);
        double discountedSubtotal = subtotal - discount;
        double vat = calculateVat(discountedSubtotal);
        double total = calculateTotal(discountedSubtotal, vat);

        // 5. Output the final formatted receipt
        printReceipt(customerName, itemName, quantity, subtotal, discount, vat, total);

        scanner.close();
    }

    // =========================================================================
    // Helper Methods
    // =========================================================================

    /**
     * Displays the complete cafe menu with item numbers, names, and prices.
     */
    public static void displayMenu() {
        System.out.println("==============================");
        System.out.println("       Lexicon Cafe");
        System.out.println("==============================");
        System.out.println("1. Espresso         25.00 SEK");
        System.out.println("2. Cappuccino       35.00 SEK");
        System.out.println("3. Latte            40.00 SEK");
        System.out.println("4. Croissant        30.00 SEK");
        System.out.println("5. Sandwich         55.00 SEK");
        System.out.println("==============================\n");
    }

    /**
     * Resolves the name of the selected menu item based on item number.
     */
    public static String getItemName(int choice) {
        return switch (choice) {
            case 1 -> "Espresso";
            case 2 -> "Cappuccino";
            case 3 -> "Latte";
            case 4 -> "Croissant";
            case 5 -> "Sandwich";
            default -> "Unknown Item";
        };
    }

    /**
     * Resolves the unit price in SEK for the selected menu item.
     */
    public static double getItemPrice(int choice) {
        return switch (choice) {
            case 1 -> 25.00;
            case 2 -> 35.00;
            case 3 -> 40.00;
            case 4 -> 30.00;
            case 5 -> 55.00;
            default -> 0.00;
        };
    }

    /**
     * Computes the base price before any discounts or taxes.
     */
    public static double calculateSubtotal(double price, int quantity) {
        return price * quantity;
    }

    /**
     * Calculates discount based on business rules:
     * - Loyalty members receive 15% off base price (highest priority).
     * - Non-members receive 10% off if order exceeds 150 SEK.
     * - Otherwise, 0% discount.
     */
    public static double calculateDiscount(double subtotal, boolean isMember) {
        if (isMember) {
            return subtotal * 0.15; // 15% loyalty discount
        } else if (subtotal > 150.0) {
            return subtotal * 0.10; // 10% volume discount for non-members
        }
        return 0.0;
    }

    /**
     * Calculates 12% VAT applied after discounts have been deducted.
     */
    public static double calculateVat(double discountedAmount) {
        return discountedAmount * 0.12; // 12% VAT rate
    }

    /**
     * Computes the final total payable amount (discounted amount + VAT).
     */
    public static double calculateTotal(double discountedAmount, double vat) {
        return discountedAmount + vat;
    }

    /**
     * Prints a cleanly formatted receipt matching the assignment specification.
     */
    public static void printReceipt(String customer, String item, int quantity,
                                    double subtotal, double discount, double vat, double total) {
        System.out.println("\n==============================");
        System.out.println("      LEXICON CAFE");
        System.out.println("==============================");
        System.out.println("Customer  : " + customer);
        System.out.println("Item      : " + item + " x " + quantity);
        System.out.printf("Subtotal  : %.2f SEK\n", subtotal);

        // Only display discount row when a discount was actually applied
        if (discount > 0.0) {
            System.out.printf("Discount  : -%.2f SEK\n", discount);
        }

        System.out.printf("VAT       : %.2f SEK\n", vat);
        System.out.println("------------------------------");
        System.out.printf("TOTAL     : %.2f SEK\n", total);
        System.out.println("==============================");
        System.out.println("   Thank you, " + customer + "!");
        System.out.println("   See you next time.");
        System.out.println("==============================");
    }
}
