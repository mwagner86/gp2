package ueb2;

public class Bifonaccizahlen {

    /**
     * Berechnet die n-te Bifonaccizahl 3. Art iterativ mittels eines Arrays.
     * bifff(n) = bifff(n - 1) + 2 * bifff(n - 2) + 3
     * bifff(0) = 1
     * bifff(1) = 1
     *
     * @param n Der Index der zu berechnenden Zahl (muss >= 0 sein).
     * @return Die n-te Bifonaccizahl.
     * @throws IllegalArgumentException wenn n negativ ist.
     */
    public static long bifff(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Der Index n darf nicht negativ sein.");
        }

        // Basisfälle direkt zurückgeben
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }

        // Array zum Speichern der berechneten Werte
        // Größe n+1, um Index n direkt verwenden zu können
        long[] bifffWerte = new long[n + 1];

        // Initialisieren der Basisfälle im Array
        bifffWerte[0] = 1;
        bifffWerte[1] = 1;

        // Iterative Berechnung der weiteren Werte mittels Schleife
        for (int i = 2; i <= n; i++) {
            // Rekursionsformel anwenden
            bifffWerte[i] = bifffWerte[i - 1] + 2 * bifffWerte[i - 2] + 3;

            // Optional: Überlaufprüfung (wenn sehr große n erwartet werden)
            // Diese einfache Prüfung fängt nicht alle Fälle ab, aber grundlegend:
            if (bifffWerte[i] < 0 && bifffWerte[i-1] > 0) { // Grober Indikator für Überlauf bei positiven Folgen
               System.err.println("Warnung: Möglicher Long-Überlauf bei n = " + i);
               // Man könnte hier auch eine Exception werfen oder abbrechen
            }
        }

        // Das Ergebnis steht am Index n des Arrays
        return bifffWerte[n];
    }

    // Alternative Implementierung mit nur zwei Variablen (Speicheroptimiert)
    public static long bifffOptimiert(int n) {
         if (n < 0) {
            throw new IllegalArgumentException("Der Index n darf nicht negativ sein.");
        }
        if (n == 0) return 1;
        if (n == 1) return 1;

        long prev2 = 1; // entspricht bifff(i-2), initial bifff(0)
        long prev1 = 1; // entspricht bifff(i-1), initial bifff(1)
        long current = 0;

        for (int i = 2; i <= n; i++) {
            current = prev1 + 2 * prev2 + 3;
             // Werte für die nächste Iteration verschieben
            prev2 = prev1;
            prev1 = current;
             // Optional: Überlaufprüfung (wie oben)
            if (current < 0 && prev1 > 0 && prev2 > 0) {
               System.err.println("Warnung: Möglicher Long-Überlauf bei n = " + i);
            }
        }
        return current; // oder prev1 nach der Schleife
    }


    public static void main(String[] args) {
        System.out.println("--- Bifff mit Array ---");
        try {
            System.out.println("bifff(0) = " + bifff(0));   // Erwartet: 1
            System.out.println("bifff(1) = " + bifff(1));   // Erwartet: 1
            System.out.println("bifff(2) = " + bifff(2));   // Erwartet: 1 + 2*1 + 3 = 6
            System.out.println("bifff(3) = " + bifff(3));   // Erwartet: 6 + 2*1 + 3 = 11
            System.out.println("bifff(4) = " + bifff(4));   // Erwartet: 11 + 2*6 + 3 = 26
            System.out.println("bifff(5) = " + bifff(5));   // Erwartet: 26 + 2*11 + 3 = 51
            System.out.println("bifff(10) = " + bifff(10));
            // System.out.println("bifff(-1) = " + bifff(-1)); // Würde Exception auslösen
        } catch (IllegalArgumentException e) {
            System.err.println("Fehler: " + e.getMessage());
        }

         System.out.println("\n--- Bifff optimiert (ohne Array) ---");
         try {
            System.out.println("bifffOptimiert(0) = " + bifffOptimiert(0));   // Erwartet: 1
            System.out.println("bifffOptimiert(1) = " + bifffOptimiert(1));   // Erwartet: 1
            System.out.println("bifffOptimiert(5) = " + bifffOptimiert(5));   // Erwartet: 51
            System.out.println("bifffOptimiert(10) = " + bifffOptimiert(10));
        } catch (IllegalArgumentException e) {
            System.err.println("Fehler: " + e.getMessage());
        }
    }
}