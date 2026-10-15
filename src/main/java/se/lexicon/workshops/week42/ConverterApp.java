package se.lexicon.workshops.week42;

import java.util.Scanner;

public class ConverterApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;

        while (keepRunning) {
            printMainMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    handleLengthConverter(scanner);
                    break;
                case "2data": // eller bara 2
                case "2":
                    handleDataConverter(scanner);
                    break;
                case "3":
                    handleSpeedConverter(scanner);
                    break;
                case "4":
                    System.out.println("Goodbye!");
                    keepRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice, please select between 1 and 4.");
            }

            if (keepRunning) {
                System.out.print("\nContinue? (yes/no): ");
                String continueChoice = scanner.nextLine().trim().toLowerCase();
                if (!continueChoice.equals("yes")) {
                    System.out.println("Goodbye!");
                    keepRunning = false;
                }
            }
        }
        scanner.close();
    }

    public static void printMainMenu() {
        System.out.println("\n==================================");
        System.out.println("      LEXICON CONVERTER APP       ");
        System.out.println("==================================");
        System.out.println("1. Length Converter");
        System.out.println("2. Data Storage Converter");
        System.out.println("3. Speed Converter");
        System.out.println("4. Exit");
        System.out.println("==================================");
        System.out.print("Choose an option: ");
    }

    public static void handleLengthConverter(Scanner scanner) {
        System.out.println("\n--- Length Converter ---");
        System.out.println("1. Centimeters to Meters");
        System.out.println("2. Meters to Kilometers");
        System.out.print("Your choice: ");
        String subChoice = scanner.nextLine();

        if (subChoice.equals("1")) {
            System.out.print("Enter value in Centimeters: ");
            double cm = Double.parseDouble(scanner.nextLine());
            double result = LengthConverter.convertCmToM(cm);
            System.out.printf("Result: %.2f cm = %.2f m\n", cm, result);
        } else if (subChoice.equals("2")) {
            System.out.print("Enter value in Meters: ");
            double m = Double.parseDouble(scanner.nextLine());
            double result = LengthConverter.convertMToKm(m);
            System.out.printf("Result: %.2f m = %.4f km\n", m, result);
        } else {
            System.out.println("Invalid sub-choice.");
        }
    }

    public static void handleDataConverter(Scanner scanner) {
        System.out.println("\n--- Data Storage Converter ---");
        System.out.println("1. Kilobytes to Megabytes");
        System.out.println("2. Megabytes to Gigabytes");
        System.out.print("Your choice: ");
        String subChoice = scanner.nextLine();

        if (subChoice.equals("1")) {
            System.out.print("Enter value in KB: ");
            double kb = Double.parseDouble(scanner.nextLine());
            double result = DataStorageConverter.convertKbToMb(kb);
            System.out.printf("Result: %.2f KB = %.2f MB\n", kb, result);
        } else if (subChoice.equals("2")) {
            System.out.print("Enter value in MB: ");
            double mb = Double.parseDouble(scanner.nextLine());
            double result = DataStorageConverter.convertMbToGb(mb);
            System.out.printf("Result: %.2f MB = %.4f GB\n", mb, result);
        } else {
            System.out.println("Invalid sub-choice.");
        }
    }

    public static void handleSpeedConverter(Scanner scanner) {
        System.out.println("\n--- Speed Converter ---");
        System.out.println("1. km/h to m/s");
        System.out.println("2. m/s to km/h");
        System.out.print("Your choice: ");
        String subChoice = scanner.nextLine();

        if (subChoice.equals("1")) {
            System.out.print("Enter speed in km/h: ");
            double kmh = Double.parseDouble(scanner.nextLine());
            double result = SpeedConverter.convertKmHToMS(kmh);
            System.out.printf("Result: %.2f km/h = %.2f m/s\n", kmh, result);
        } else if (subChoice.equals("2")) {
            System.out.print("Enter speed in m/s: ");
            double ms = Double.parseDouble(scanner.nextLine());
            double result = SpeedConverter.convertMSToKmH(ms);
            System.out.printf("Result: %.2f m/s = %.2f km/h\n", ms, result);
        } else {
            System.out.println("Invalid sub-choice.");
        }
    }
}