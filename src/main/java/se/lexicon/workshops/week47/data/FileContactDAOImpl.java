package se.lexicon.workshops.week47.data;

import se.lexicon.workshops.week47.exception.ContactStorageException;
import se.lexicon.workshops.week47.exception.DuplicateContactException;
import se.lexicon.workshops.week47.model.Contact;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileContactDAOImpl implements ContactDAO {

    private final Path filePath;

    public FileContactDAOImpl(Path filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Contact> findAll() throws ContactStorageException {
        List<Contact> contacts = new ArrayList<>();

        if (Files.notExists(filePath)) {
            return contacts;
        }

        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) continue;
                String[] parts = line.split(";", 2);
                if (parts.length == 2) {
                    contacts.add(new Contact(parts[0].trim(), parts[1].trim()));
                }
            }
        } catch (IOException e) {
            throw new ContactStorageException("Failed to read contacts from file: " + filePath + " (" + e.getMessage() + ")");
        }

        return contacts;
    }

    @Override
    public void save(Contact contact) throws ContactStorageException, DuplicateContactException {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }

        if (findByName(contact.getName()) != null) {
            throw new DuplicateContactException("Contact already exists with name: " + contact.getName());
        }

        try {
            if (filePath.getParent() != null) {
                Files.createDirectories(filePath.getParent());
            }

            try (BufferedWriter writer = Files.newBufferedWriter(
                    filePath,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND)) {
                writer.write(contact.getName() + ";" + contact.getPhoneNumber());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new ContactStorageException("Failed to save contacts to file: " + filePath + " (" + e.getMessage() + ")");
        }
    }

    @Override
    public Contact findByName(String name) throws ContactStorageException {
        if (name == null || name.isBlank()) {
            return null;
        }

        for (Contact contact : findAll()) {
            if (contact.getName().equalsIgnoreCase(name.trim())) {
                return contact;
            }
        }
        return null;
    }
}
