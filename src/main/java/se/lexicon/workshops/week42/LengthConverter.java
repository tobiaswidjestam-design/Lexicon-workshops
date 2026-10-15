package se.lexicon.workshops.week42;

public class LengthConverter {

    // Konstanter högst upp
    public static final double CM_TO_M_RATE = 100.0;
    public static final double M_TO_KM_RATE = 1000.0;

    // Metod för Centimeter till Meter
    public static double convertCmToM(double cm) {
        return cm / CM_TO_M_RATE;
    }

    // Metod för Meter till Kilometer
    public static double convertMToKm(double m) {
        return m / M_TO_KM_RATE;
    }
}