package se.lexicon.workshops.week44;

import java.util.Objects;

/**
 * Represents a vehicle in the parking system.
 */
public class Vehicle {

    private String vehicleId;
    private String registrationNumber;

    /**
     * Constructs a new Vehicle with ID and registration number.
     * Validates that the registration number matches standard format.
     */
    public Vehicle(String vehicleId, String registrationNumber) {
        this.vehicleId = vehicleId;

        String formattedRegNo = registrationNumber != null ? registrationNumber.trim().toUpperCase() : "";
        if (!isValidRegistrationNumber(formattedRegNo)) {
            throw new IllegalArgumentException("Invalid registration number format: " + registrationNumber);
        }
        this.registrationNumber = formattedRegNo;
    }

    /**
     * Validates if the given registration number matches the standard format
     * (three letters followed by three characters/digits, e.g., ABC 123).
     */
    public static boolean isValidRegistrationNumber(String registrationNumber) {
        if (registrationNumber == null) {
            return false;
        }
        String cleaned = registrationNumber.trim().toUpperCase();
        return cleaned.matches("^[A-ZÅÄÖ]{3}[0-9A-Z]{3}$");
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        String formattedRegNo = registrationNumber != null ? registrationNumber.trim().toUpperCase() : "";
        if (!isValidRegistrationNumber(formattedRegNo)) {
            throw new IllegalArgumentException("Invalid registration number format: " + registrationNumber);
        }
        this.registrationNumber = formattedRegNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(vehicleId, vehicle.vehicleId) &&
                Objects.equals(registrationNumber, vehicle.registrationNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleId, registrationNumber);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId='" + vehicleId + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                '}';
    }
}
