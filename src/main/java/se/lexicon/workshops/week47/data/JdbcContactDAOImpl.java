
package se.lexicon.workshops.week47.data;

import se.lexicon.workshops.week47.DatabaseConnection;
import se.lexicon.workshops.week47.exception.ContactStorageException;
import se.lexicon.workshops.week47.exception.DuplicateContactException;
import se.lexicon.workshops.week47.model.Contact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcContactDAOImpl implements ContactDAO {

    @Override
    public List<Contact> findAll() throws ContactStorageException {
        List<Contact> contacts = new ArrayList<>();
        String sql = "SELECT name, phone_number FROM contacts";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                String name = rs.getString("name");
                String phoneNumber = rs.getString("phone_number");
                contacts.add(new Contact(name, phoneNumber));
            }
            return contacts;

        } catch (SQLException e) {
            throw new ContactStorageException("Failed to fetch contacts from database: " + e.getMessage());
        }
    }

    @Override
    public void save(Contact contact) throws ContactStorageException, DuplicateContactException {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }

        String sql = "INSERT INTO contacts (name, phone_number) VALUES (?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, contact.getName());
            statement.setString(2, contact.getPhoneNumber());
            statement.executeUpdate();

        } catch (SQLException e) {
            // MySQL felkod 1062 = Duplicate entry för en UNIQUE-kolumn (phone_number)
            if (e.getErrorCode() == 1062) {
                throw new DuplicateContactException(
                        "A contact with phone number " + contact.getPhoneNumber() + " already exists."
                );
            }
            throw new ContactStorageException("Failed to save contact to database: " + e.getMessage());
        }
    }

    @Override
    public Contact findByName(String name) throws ContactStorageException {
        if (name == null || name.trim().isEmpty()) {
            return null;
        }

        String sql = "SELECT name, phone_number FROM contacts WHERE name = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, name.trim());

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    return new Contact(
                            rs.getString("name"),
                            rs.getString("phone_number")
                    );
                }
                return null;
            }

        } catch (SQLException e) {
            throw new ContactStorageException("Failed to find contact by name: " + e.getMessage());
        }
    }
}
