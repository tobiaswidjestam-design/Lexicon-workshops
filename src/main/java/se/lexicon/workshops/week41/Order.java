package se.lexicon.workshops.week41;

public class Order {
    // 1. Fält för all orderdata
    private String customerName;
    private String item;
    private int quantity;
    private double price;
    private boolean isMember;

    // Setters för att kunna sätta värdena från main
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setIsMember(boolean isMember) {
        this.isMember = isMember;
    }

    // 2. Beräkningar
    public double calculateSubtotal() {
        return price * quantity;
    }

    public double calculateDiscount() {
        double subtotal = calculateSubtotal();
        if (isMember) {
            return subtotal * 0.15; // 15% rabatt för medlemmar
        } else if (subtotal > 150.0) {
            return subtotal * 0.10; // 10% mängdrabatt över 150 kr
        }
        return 0.0;
    }

    public double calculateVat() {
        double discountedAmount = calculateSubtotal() - calculateDiscount();
        return discountedAmount * 0.12; // 12% moms
    }

    public double calculateTotal() {
        double discountedAmount = calculateSubtotal() - calculateDiscount();
        return discountedAmount + calculateVat();
    }

    // 3. Kvittoutskrift (0 parametrar!)
    public void printReceipt() {
        double subtotal = calculateSubtotal();
        double discount = calculateDiscount();
        double vat = calculateVat();
        double total = calculateTotal();

        System.out.println("\n==============================");
        System.out.println("      LEXICON CAFE");
        System.out.println("==============================");
        System.out.println("Customer  : " + customerName);
        System.out.println("Item      : " + item + " x " + quantity);
        System.out.printf("Subtotal  : %.2f SEK\n", subtotal);

        if (discount > 0.0) {
            System.out.printf("Discount  : -%.2f SEK\n", discount);
        }

        System.out.printf("VAT       : %.2f SEK\n", vat);
        System.out.println("------------------------------");
        System.out.printf("TOTAL     : %.2f SEK\n", total);
        System.out.println("==============================");
        System.out.println("    Thank you, " + customerName + "!");
        System.out.println("==============================");
    }
}