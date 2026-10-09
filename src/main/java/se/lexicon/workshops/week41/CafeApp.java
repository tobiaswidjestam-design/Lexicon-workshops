package se.lexicon.workshops.week41;

import java.util.Scanner;

public class CafeApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalCustomers = 0;
        double totalRevenue = 0.0;

        System.out.println("=== WELCOME TO LEXICON CAFE ===");

        // Ask for the first customer immediately
        String customerName = getValidCustomerName(scanner);

        // Loop that runs as long as the customer does not type 'done'
        while (customerName != null) {
            totalCustomers++;
            System.out.println("\nHi " + customerName + "! Here is our menu:\n");
            displayMenu();

            int choice = getValidItemChoice(scanner);
            int quantity = getValidQuantity(scanner);
            boolean isMember = getValidLoyaltyStatus(scanner);

            // Create a new Order object and populate its fields
            Order order = new Order();
            order.setCustomerName(customerName);
            order.setItem(getItemName(choice));
            order.setQuantity(quantity);
            order.setPrice(getItemPrice(choice));
            order.setIsMember(isMember);

            // Add the order's total price to today's revenue
            totalRevenue += order.calculateTotal();

            // Print the receipt using the object (0 parameters!)
            order.printReceipt();

            // Ask for the next customer or 'done' at the end of the loop
            customerName = getNextCustomerOrDone(scanner);
        }

        // End-of-Day Summary when the loop ends
        printEndOfDaySummary(totalCustomers, totalRevenue);

        scanner.close();
    }

    // =========================================================================
    // HELPER METHODS (Inmatning och meny)
    // =========================================================================

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

    public static String getNextCustomerOrDone(Scanner scanner) {
        while (true) {
            System.out.print("\nNext customer name (or 'done' to close): ");
            String name = scanner.nextLine().trim();

            if (name.equalsIgnoreCase("done")) {
                return null;
            }
            if (!name.isEmpty()) {
                return name;
            }
            System.out.println("Error: Name cannot be empty. Please enter a name or type 'done'.");
        }
    }

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

    public static void displayMenu() {
        System.out.println("==============================");
        System.out.println("        Lexicon Cafe");
        System.out.println("==============================");
        System.out.println("1. Espresso         25.00 SEK");
        System.out.println("2. Cappuccino       35.00 SEK");
        System.out.println("3. Latte            40.00 SEK");
        System.out.println("4. Croissant        30.00 SEK");
        System.out.println("5. Sandwich         55.00 SEK");
        System.out.println("==============================\n");
    }

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

    public static void printEndOfDaySummary(int totalCustomers, double totalRevenue) {
        System.out.println("\n==============================================");
        System.out.println("             END-OF-DAY SUMMARY              ");
        System.out.println("==============================================");
        System.out.println("Total customers served : " + totalCustomers);
        System.out.printf("Total revenue          : %.2f SEK\n", totalRevenue);
        System.out.println("==============================================");
        System.out.println(" Café is now closed. Have a great evening!");
        System.out.println("==============================================");
    }
}