package se.lexicon.exercises.exercise2;

public class ReceiptBuilder {

    void main() {
        StringBuilder receipt = new StringBuilder();
        double grandTotal = 0.0;

        // 1. Build the header of the receipt
        receipt.append("==============================\n");
        receipt.append("           Receipt\n");
        receipt.append("==============================\n");

        // 2. Loop to continuously read items and prices until user types 'done'
        while (true) {
            String itemName = IO.readln("Enter item name (or 'done'): ");

            // Check if user wants to finish
            if (itemName.equalsIgnoreCase("done")) {
                break;
            }

            double price = Double.parseDouble(IO.readln("Enter price: "));
            grandTotal += price;

            // Append item row to the receipt (left-align name, right-align price)
            receipt.append(String.format("%-23s%7.2f\n", itemName, price));
        }

        // 3. Build the footer and grand total
        receipt.append("------------------------------\n");
        receipt.append(String.format("%-23s%7.2f\n", "Grand Total:", grandTotal));
        receipt.append("==============================\n");

        // 4. Print the final completed receipt
        IO.println(receipt.toString());
    }
}




