package ueb2;
// Überlauf-Tests für verschiedene Datentypen in Java 
public class OverflowTest {

    public static void main(String[] args) {
        // --- byte ---
        // Wertebereich: -128 bis 127
        byte maxByte = Byte.MAX_VALUE;
        System.out.println("Maximaler byte-Wert: " + maxByte); // Gibt 127 aus
        // Überlauf provozieren
        byte overflowByte = (byte) (maxByte + 1);
        System.out.println("byte nach Überlauf (max + 1): " + overflowByte); // Gibt -128 aus (Byte.MIN_VALUE)
        System.out.println("Minimaler byte-Wert: " + Byte.MIN_VALUE); // Zum Vergleich

        System.out.println("--------------------");

        // --- int ---
        // Wertebereich: -2.147.483.648 bis 2.147.483.647
        int maxInt = Integer.MAX_VALUE;
        System.out.println("Maximaler int-Wert: " + maxInt); // Gibt 2147483647 aus
        // Überlauf provozieren
        int overflowInt = maxInt + 1; // Hier ist kein expliziter Cast nötig, da das Ergebnis wieder ein int ist
        System.out.println("int nach Überlauf (max + 1): " + overflowInt); // Gibt -2147483648 aus (Integer.MIN_VALUE)
        System.out.println("Minimaler int-Wert: " + Integer.MIN_VALUE); // Zum Vergleich

        System.out.println("--------------------");

        // --- long ---
        // Wertebereich: -9.223.372.036.854.775.808 bis 9.223.372.036.854.775.807
        long maxLong = Long.MAX_VALUE;
        System.out.println("Maximaler long-Wert: " + maxLong); // Gibt 9223372036854775807 aus
        // Überlauf provozieren
        long overflowLong = maxLong + 1;
        System.out.println("long nach Überlauf (max + 1): " + overflowLong); // Gibt -9223372036854775808 aus (Long.MIN_VALUE)
        System.out.println("Minimaler long-Wert: " + Long.MIN_VALUE); // Zum Vergleich
    }
}