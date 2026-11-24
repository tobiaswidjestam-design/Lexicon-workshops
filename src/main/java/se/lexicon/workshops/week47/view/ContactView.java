package se.lexicon.workshops.week47.view;

import se.lexicon.workshops.week47.model.Contact;

import java.util.Scanner;
import java.util.List;

public class ContactView {
    private final Scanner scanner;

    public ContactView() {
        this.scanner = new Scanner(System.in);
    }

    public String getUserInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine().trim();
    }

    public void displayMenu() {
        System.out.println("\n--- CONTACT BOOK ---");
        System.out.println("1. Add contact");
        System.out.println("2. View all contacts");
        System.out.println("3. Search contact");
        System.out.println("4. Delete contact");
        System.out.println("0. Exit");
    }

    public void displayContacts(List<Contact> contacts) {
        if (contacts == null || contacts.isEmpty()) {
            System.out.println("No contacts to display");
            return;
        }

        System.out.println("\n--- CONTACT LIST ---");
        for (int i = 0; i < contacts.size(); i++){
            System.out.println((i + i) + ". " + contacts.get(i).toString());
        }
    }

    public void displayMessage(String message){
        System.out.println(message);
    }
    public void displayError(String message){
        System.err.println("Error: " + message);
    }
}
