package se.lexicon.workshops.week45;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VendingMachine {


    private List<Product> products;

    private Product beverage;
    private Product fruit;
    private Product snack;
    private int balance;
    private final int[] acceptedCoins = {1, 2, 5, 10, 20, 50};

    // Constructor
    public VendingMachine() {
        products = new ArrayList<>();
        balance = 0;

        beverage = new Beverage(1,"Cola",20,3,330);
        fruit = new Fruit(2, "Apple", 10, 8, "Sweden");
        snack = new Snack(3, "Chips",15,5,130);
        // products.addAll(Collections.nCopies(3, new Beverage(3)));

        products.add(beverage);
        products.add(fruit);
        products.add(snack);

    }


    // Add a product
    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    // Display all products
    public void displayProducts() {
        System.out.println("\n--- Available Products ---");

        for (Product product : products) {
            System.out.println(
                    "ID: " + product.getId() +
                            " | " + product.getName() +
                            " | Price: " + product.getPrice() + " kr" +
                            " | Stock: " + product.getQuantity());
        }
    }

    // Insert a coin
    public void insertCoin(int coin) {
        boolean validCoin = false;

        for (int acceptedCoin : acceptedCoins) {
            if (coin == acceptedCoin) {
                validCoin = true;
                break;
            }
        }

        if (validCoin) {
            balance += coin;
            System.out.println(coin + " kr accepted.");
        } else {
           throw new IllegalArgumentException("Invalid Coin");
        }

        displayBalance();
    }

    public int cancel (){
        int change = balance;
        balance = 0;
        return change;
    }


    // Get current balance
    public int getBalance() {
        return balance;
    }

    // Display balance
    public void displayBalance() {
        System.out.println("Current balance: " + balance + " kr");
    }

    // Return remaining balance
    public void returnBalance() {
        System.out.println("Returning " + balance + " kr.");
        balance = 0;
        displayBalance();
    }

    // Find product by ID
    private Product findProduct(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }

        return null;
    }

    // Check stock
    public boolean checkStock(int id) {
        Product product = findProduct(id);
        return product != null && product.getQuantity() > 0;
    }

    // Purchase product
    public void purchaseProduct(int id) {
        Product product = findProduct(id);

        if (product == null) {
            System.out.println("Product with ID " + id + " does not exist.");
            displayBalance();
            return;
        }

        if (product.getQuantity() <= 0) {
            System.out.println(product.getName() + " is out of stock.");
            displayBalance();
            return;
        }

        if (balance < product.getPrice()) {
            int missing = product.getPrice() - balance;

            System.out.println("Not enough money. You need " +
                    missing + " kr more.");

            displayBalance();
            return;
        }

        // Successful purchase
        balance -= product.getPrice();
        product.reduceQuantity();

        System.out.println("Purchase successful!");
         product.print();

        // Automatically return change
        calculateChange();
    }

    // Return change
    public int calculateChange() {
        int change = balance;

        System.out.println("Returning change: " + change + " kr.");

        balance = 0;
        displayBalance();

        return change;
    }
}

