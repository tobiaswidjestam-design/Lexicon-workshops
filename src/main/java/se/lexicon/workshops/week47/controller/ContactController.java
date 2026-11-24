package se.lexicon.workshops.week47.controller;

import se.lexicon.workshops.week47.data.ContactDAO;
import se.lexicon.workshops.week47.exception.ExceptionHandler;
import se.lexicon.workshops.week47.model.Contact;
import se.lexicon.workshops.week47.view.ContactView;

public class ContactController {
    private final ContactDAO contactDAO;
    private final ContactView contactView;
    private final ExceptionHandler exceptionHandler;

    public ContactController(ContactDAO contactDAO, ContactView contactView, ExceptionHandler exceptionHandler) {
        this.contactDAO = contactDAO;
        this.contactView = contactView;
        this.exceptionHandler = exceptionHandler;
    }

    public void run() {
        boolean running = true;
        while (running) {
            try {
                contactView.displayMenu();
                String choice = contactView.getUserInput("Choose an option: ");
                switch (choice) {
                    case "1" -> addContact();
                    case "2" -> contactView.displayContacts(contactDAO.findAll());
                    case "3" -> searchContact();
                    case "0" ->  running = false;
                    default -> contactView.displayError("Invalid menu option.");
                }
            } catch (Exception e) {
                exceptionHandler.handle(e);
            }
        }
    }

    private void addContact() {
        String name = contactView.getUserInput("Enter name: ");
        String phoneNumber = contactView.getUserInput("Enter phone number: ");
        Contact contact = new Contact(name, phoneNumber);
        contactDAO.save(contact);
        contactView.displayMessage("Contact successfully saved!");
    }

    private void searchContact() {
        String name = contactView.getUserInput("Enter name to search: ");
        Contact contact = contactDAO.findByName(name);
        if (contact == null) {
            contactView.displayMessage("Contact not found.");
        } else {
            contactView.displayMessage(contact.toString());
        }
    }
}
