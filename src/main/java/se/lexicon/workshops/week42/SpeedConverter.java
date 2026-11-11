package se.lexicon.workshops.week42;

public class SpeedConverter {

    // Constant at the top (3.6 for conversion between km/h and m/s)
    public static final double SPEED_CONVERSION_RATE = 3.6;

    // Method for km/h to m/s
    public static double convertKmHToMS(double kmh) {
        return kmh / SPEED_CONVERSION_RATE;
    }

    // Method for m/s to km/h
    public static double convertMSToKmH(double ms) {
        return ms * SPEED_CONVERSION_RATE;
    }
}