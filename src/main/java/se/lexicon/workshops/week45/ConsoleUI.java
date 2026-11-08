package se.lexicon.workshops.week45;

import java.util.Scanner;

/**
 * Console user interface for the application. A user can interact with the application through this interface.
 */
public class ConsoleUI {
    private final Scanner scanner = new Scanner(System.in);
    private final VendingMachine vendingMachine = new VendingMachine();
    private boolean isDone = false;

    public void run() {
        vendingMachine.displayProducts();
        vendingMachine.displayBalance();

        while (!isDone) {
            System.out.println("Please select an option:");
            System.out.println("1. Insert coin");
            System.out.println("2. Select product");
            System.out.println("3. Cancel");

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    insertCoin();
                    break;
                case "2":
                    selectProduct();
                    break;
                case "3":
                    cancel();
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    /**
     * Put a coin in the vending machine's slot.
     */
    private void insertCoin() {
        System.out.println("Insert coin: ");
        try {
            int coin = Integer.parseInt(scanner.nextLine());
            vendingMachine.insertCoin(coin);
        } catch (NumberFormatException e) {
            System.out.println("Invalid coin. Only 1, 2, 5, 10, 20, 50 kr accepted.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void selectProduct() {
        try {
            System.out.println("Select product: ");
            int productId = Integer.parseInt(scanner.nextLine());
            if (productId >= 1 && productId <= 3) {
                vendingMachine.purchaseProduct(productId);
            } else {
                throw new IllegalArgumentException("You can only select product 1 to 3");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Cancels the current operation and exits the application.
     * A user gets his coins back when canceling the payment.
     */
    private void cancel() {
        vendingMachine.returnBalance();
        isDone = true;
        System.out.println("Exiting the application. Goodbye!");
    }
}
