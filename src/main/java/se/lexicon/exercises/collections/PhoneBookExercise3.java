package se.lexicon.exercises.collections;


import java.util.HashMap;
import java.util.Scanner;

public class PhoneBookExercise3 {

    void main() {
        // 1. Store at least 4 contacts as name -> phone number pairs
        var phoneBook = new HashMap<String, String>();
        phoneBook.put("Alice", "070-1234567");
        phoneBook.put("Bob", "073-9876543");
        phoneBook.put("Charlie", "076-5554433");
        phoneBook.put("Diana", "072-1112233");

        // 2. Ask the user to enter a name and look it up
        var scanner = new Scanner(System.in);
        IO.println("--- Phone Book ---");
        IO.println("Enter a name to search for:");
        var searchName = scanner.nextLine().trim();

        // 3. Print the phone number if found, or "Contact not found." if not
        var phoneNumber = phoneBook.get(searchName);

        if (phoneNumber != null) {
            IO.println("Phone number for " + searchName + ": " + phoneNumber);
        } else {
            IO.println("Contact not found.");
        }
    }
}