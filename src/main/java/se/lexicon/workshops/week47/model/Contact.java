
package se.lexicon.workshops.week47.model;

public class Contact {

    private String name;
    private String phoneNumber;

    // Constructor
    public Contact(String name, String phoneNumber) {
        setName(name);
        setPhoneNumber(phoneNumber);
    }

    // Validate and set name
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        this.name = name;
    }

    // Validate and set phone number
    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || !phoneNumber.matches("^\\d{10}$")) {
            throw new IllegalArgumentException(
                    "Phone number must contain exactly 10 digits"
            );
        }

        this.phoneNumber = phoneNumber;
    }

    // Get name
    public String getName() {
        return name;
    }

    // Get phone number
    public String getPhoneNumber() {
        return phoneNumber;
    }


    @Override
    public String toString() {
        return name + " (" + phoneNumber + ")";
    }
}
