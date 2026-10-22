package se.lexicon.workshops.week43;

/**
 * Modern Java Module Import:
 * Imports the entire 'java.base' module, providing access to
 * Set, LinkedHashSet, IO, String formatting, etc.
 */
import module java.base;

/**
 * Contact Record:
 * Holds the three agreed fields: name, email, and phone.
 * Automatically provides:
 *  - Canonical constructor
 *  - Immutable fields
 *  - Correct equals() & hashCode() based on all 3 fields for HashSet duplicate handling
 */
record Contact(String name, String email, String phone) {
    @Override
    public String toString() {
        return "Name: " + name + " | Email: " + email + " | Phone: " + phone;
    }
}

public class ContactApp {

    // Set for storing contacts (LinkedHashSet maintains insertion order while giving O(1) performance)
    private final Set<Contact> contacts = new LinkedHashSet<>();

    void main() {
        // Pre-populate with some initial sample data
        contacts.add(new Contact("John Smith", "john@example.com", "1234567890"));
        contacts.add(new Contact("Anna Andersson", "anna@example.com", "070-1112223"));
        contacts.add(new Contact("John Smith", "john.work@corp.com", "079-9998877")); // Same name, different email/phone

        boolean running = true;

        while (running) {
            printMenu();
            String choice = IO.readln("Choose an option (1-4): ").trim();

            switch (choice) {
                case "1" -> addContact();
                case "2" -> lookupByName();
                case "3" -> viewAllContacts();
                case "4" -> {
                    IO.println("\nExiting Contact Management App. Goodbye!");
                    running = false;
                }
                default -> IO.println("\n Invalid option. Please choose between 1 and 4.");
            }
        }
    }

    /**
     * Prints the interactive CLI menu as designed by the group.
     */
    private void printMenu() {
        IO.println("\n===== CONTACT MANAGEMENT APP =====");
        IO.println("1. Add Contact");
        IO.println("2. Lookup Contact by Name");
        IO.println("3. View All Contacts");
        IO.println("4. Exit");
    }

    /**
     * Option 1: Add a new contact with name, email, and phone.
     * If an identical contact exists in the Set, it is replaced.
     */
    private void addContact() {
        IO.println("\n--- Add New Contact ---");
        String name = IO.readln("Enter name: ").trim();
        String email = IO.readln("Enter email: ").trim();
        String phone = IO.readln("Enter phone: ").trim();

        if (name.isEmpty() || phone.isEmpty()) {
            IO.println(" Name and phone cannot be empty.");
            return;
        }

        var newContact = new Contact(name, email, phone);

        // If duplicate exists, remove the old one and re-add to satisfy "replace existing"
        if (contacts.contains(newContact)) {
            contacts.remove(newContact);
            IO.println(" Existing identical contact replaced.");
        } else {
            IO.println(" Contact successfully added!");
        }
        contacts.add(newContact);
    }

    /**
     * Option 2: Lookup contacts by name (case-insensitive).
     * If multiple contacts share the same name, all matching contacts are printed.
     */
    private void lookupByName() {
        IO.println("\n--- Lookup Contact by Name ---");
        String searchName = IO.readln("Enter name to search: ").trim();

        if (searchName.isEmpty()) {
            IO.println(" Search query cannot be empty.");
            return;
        }

        // Filter all contacts that match the given name (case-insensitive)
        var matches = contacts.stream()
                .filter(c -> c.name().equalsIgnoreCase(searchName))
                .toList();

        if (matches.isEmpty()) {
            IO.println(" No contacts found with name: " + searchName);
        } else {
            IO.println(" Found " + matches.size() + " contact(s):");
            for (var contact : matches) {
                IO.println("  • " + contact);
            }
        }
    }

    /**
     * Option 3: List all contacts currently saved in the Set.
     */
    private void viewAllContacts() {
        IO.println("\n--- All Contacts (" + contacts.size() + ") ---");
        if (contacts.isEmpty()) {
            IO.println("No contacts stored yet.");
            return;
        }

        int index = 1;
        for (var contact : contacts) {
            IO.println(index++ + ". " + contact);
        }
    }
}
