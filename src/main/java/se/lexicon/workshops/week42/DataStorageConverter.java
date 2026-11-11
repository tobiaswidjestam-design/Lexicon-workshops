package se.lexicon.workshops.week42;

public class DataStorageConverter {

    // Constants at the top
    public static final double KB_TO_MB_RATE = 1024.0;
    public static final double MB_TO_GB_RATE = 1024.0;

    // Method for Kilobytes to Megabytes
    public static double convertKbToMb(double kb) {
        return kb / KB_TO_MB_RATE;
    }

    // Method for Megabytes to Gigabytes
    public static double convertMbToGb(double mb) {
        return mb / MB_TO_GB_RATE;
    }
}