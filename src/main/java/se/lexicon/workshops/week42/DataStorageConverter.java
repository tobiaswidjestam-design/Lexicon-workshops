package se.lexicon.workshops.week42;

package se.lexicon.workshops.week42;

public class DataStorageConverter {

    // Konstanter högst upp
    public static final double KB_TO_MB_RATE = 1024.0;
    public static final double MB_TO_GB_RATE = 1024.0;

    // Metod för Kilobytes till Megabytes
    public static double convertKbToMb(double kb) {
        return kb / KB_TO_MB_RATE;
    }

    // Metod för Megabytes till Gigabytes
    public static double convertMbToGb(double mb) {
        return mb / MB_TO_GB_RATE;
    }
}