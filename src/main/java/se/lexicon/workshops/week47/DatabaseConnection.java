package se.lexicon.workshops.week47;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/contacts_db";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        String selectSql = "SELECT id, name, phone, email FROM contacts";
        String insertSql = "INSERT INTO contacts (name, phone, email) VALUES (?, ?, ?)";

        try (Connection connection = getConnection()) {
            // 1. READ: Hämta och skriv ut alla kontakter med ResultSet
            try (var selectStmt = connection.prepareStatement(selectSql);
                 var rs = selectStmt.executeQuery()) {

                System.out.println("--- Kontakter i databasen ---");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String phone = rs.getString("phone");
                    String email = rs.getString("email");
                    System.out.println(id + ": " + name + " | " + phone + " | " + email);
                }
            }

            // 2. CREATE: Lägg in en ny kontakt med PreparedStatement (?)
            try (var insertStmt = connection.prepareStatement(insertSql)) {
                insertStmt.setString(1, "Kalle Karlsson");
                insertStmt.setString(2, "072-1112233");
                insertStmt.setString(3, "kalle@example.com");

                int rowsAffected = insertStmt.executeUpdate();
                System.out.println("\nAntal tillagda rader: " + rowsAffected);
            }

        } catch (SQLException e) {
            System.err.println("Databasfel: " + e.getMessage());
        }
    }




}
