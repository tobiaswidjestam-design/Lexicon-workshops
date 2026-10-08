package se.lexicon.workshops.week41;

import java.util.Scanner;

/**
 * Workshop Week 41 - Lexicon Cafe Application
 *
 * Includes Challenge 2: Input Validation & Error Handling.
 * Guards user input against non-numeric text (e.g. typing "tre" instead of 3),
 * out-of-range choices, non-positive quantities, and invalid loyalty answers.
 */
public class CafeApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Greet customer with validated non-empty name
        String customerName = getValidCustomerName(scanner);
        System.out.println("Hi " + customerName + "! Here is our menu:\n");
        displayMenu();

        // 2. Select menu item and quantity (safe from crashes!)
        int choice = getValidItemChoice(scanner);
        int quantity = getValidQuantity(scanner);

        // 3. Inquire about loyalty membership (strictly yes/no)
        boolean isMember = getValidLoyaltyStatus(scanner);

        // 4. Perform calculations via dedicated helper methods
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
    // Challenge 2: Safe Input Validation Methods (No more crashes!)
    // =========================================================================

    /**
     * Prompts for customer name and ensures it is not left blank.
     */
    public static String getValidCustomerName(Scanner scanner) {
        while (true) {
            System.out.print("Welcome! What is your name? ");
            String name = scanner.nextLine().trim();
            if (!name.isEmpty()) {
                return name;
            }
            System.out.println("Error: Name cannot be empty. Please enter your name.\n");
        }
    }

    /**
     * Safely reads the menu item number (1-5).
     * Catches words like "tre" or invalid numbers and asks again instead of crashing.
     */
    public static int getValidItemChoice(Scanner scanner) {
        while (true) {
            System.out.print("Enter item number (1-5): ");
            String input = scanner.nextLine().trim();
            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= 5) {
                    return choice;
                }
                System.out.println("Error: '" + choice + "' is not on the menu. Please enter a number between 1 and 5.\n");
            } catch (NumberFormatException e) {
                System.out.println("Error: '" + input + "' is not a valid number. Please type a number (1-5).\n");
            }
        }
    }

    /**
     * Safely reads the quantity.
     * Ensures input is numeric and greater than 0.
     */
    public static int getValidQuantity(Scanner scanner) {
        while (true) {
            System.out.print("How many? ");
            String input = scanner.nextLine().trim();
            try {
                int qty = Integer.parseInt(input);
                if (qty > 0) {
                    return qty;
                }
                System.out.println("Error: Quantity must be at least 1.\n");
            } catch (NumberFormatException e) {
                System.out.println("Error: '" + input + "' is not a valid number. Please type a whole number.\n");
            }
        }
    }

    /**
     * Safely reads loyalty status. Only accepts 'yes' or 'no'.
     */
    public static boolean getValidLoyaltyStatus(Scanner scanner) {
        while (true) {
            System.out.print("Loyalty member? (yes/no): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("yes") || input.equals("y")) {
                return true;
            } else if (input.equals("no") || input.equals("n")) {
                return false;
            }
            System.out.println("Error: Please answer 'yes' or 'no'.\n");
        }
    }

    // =========================================================================
    // Menu & Calculation Helper Methods
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
