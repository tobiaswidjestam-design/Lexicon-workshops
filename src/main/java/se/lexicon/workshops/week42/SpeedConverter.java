package se.lexicon.workshops.week42;

public class SpeedConverter {

    // Konstant högst upp (3.6 för omvandling mellan km/h och m/s)
    public static final double SPEED_CONVERSION_RATE = 3.6;

    // Metod för km/h till m/s
    public static double convertKmHToMS(double kmh) {
        return kmh / SPEED_CONVERSION_RATE;
    }

    // Metod för m/s till km/h
    public static double convertMSToKmH(double ms) {
        return ms * SPEED_CONVERSION_RATE;
    }
}