package se.lexicon.exercises.exercise1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class TemperatureConverter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter temperature in Celsius: ");
        double celsius = Double.parseDouble(reader.readLine());

        // Konvertera till Fahrenheit och Kelvin
        double fahrenheit = celsius * 9.0 / 5 + 32;
        double kelvin = celsius + 273.15;

        // Skriv ut resultaten
        System.out.println("Celsius:    " + celsius + " °C");
        System.out.println("Fahrenheit: " + fahrenheit + " °F");
        System.out.println("Kelvin:     " + kelvin + " K");
    }
}
