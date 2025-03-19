import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * Diese Klasse zeigt, wie Zahlen binaer in eine Datei gespeichert werden
 * koennen, und auch wieder gelesen werden.
 *
 * @author Agathe Merceron
 *
 */

public class IntBinaerSpeichern {

    /**
     * schreibt ein Array aus int Zahlen binaer in eine Datei
     *
     * @param dateiName Name der Datei, um die Zahlen als binaer zu speichern
     * @param bA        das int-Array dessen Zahlen in die Datei gespeichert
     *                  werden
     * @throws IOException
     */

    public static void intToBinaryDatei(String dateiName, int[] bA)
            throws IOException {
        // Ausgabestroeme erzeugen
        FileOutputStream foStream = new FileOutputStream(dateiName);
        DataOutputStream doStream = new DataOutputStream(foStream);

        try {
            // Schleife ueber Array
            for (int i = 0; i < bA.length; i++) {
                doStream.writeInt(bA[i]);
                System.out.print(bA[i] + ", "); // als Kontrolle
            }
            // Dateigroesse in Bytes auf der Konsole ausgeben
            // als Ueberpruefung
            System.out.println("\nDateigroesse: " + doStream.size() + " Bytes");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        // Ausgabestrom schliessen
        finally {
            doStream.close();
        }
    }

    /**
     * Liste int Zahlen aus einer Datei und gibt sie als Array zurueck Die
     * Datei muss mindestens so viele Zahlen enthalten wie im Parameter anzahl
     * eingegeben, sonst wird die Methode und das Programm ohne Ergebnis
     * beendet.
     *
     * @param dateiName Name der Datei, die int-Zahlen binaer gespeichert
     *                  enthaelt
     * @param anzahl    die Zahlen die gelesen werden
     * @return
     */

    public static int[] intFromBinaryDatei(String dateiName, int anzahl) {
        int[] zahlen = new int[anzahl];
        try {
            FileInputStream fiStream = new FileInputStream(dateiName);
            DataInputStream diStream = new DataInputStream(fiStream);

            // Schleife ueber Array
            for (int i = 0; i < anzahl; i++) {
                zahlen[i] = diStream.readInt();
            }

            diStream.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.exit(0);
        }
        return zahlen;
    }

    /**
     * Main-Methode.
     *
     * @param args Uebergabeparameter
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // Variablen deklarieren
        int[] bA = { 10, 20, 30, 40, 50, 60 };
        // Methode zum Testen des Ausgabestroms aufrufen

        intToBinaryDatei(
                "/home/mwagner/ITS/gp2/02_DUD/DoubleBinaer/Dateien/intInBinary",
                bA);
        int[] result = intFromBinaryDatei(
                "/home/mwagner/ITS/gp2/02_DUD/DoubleBinaer/Dateien/intInBinary",
                bA.length);

        // einfach visuell ueberpruefen, ob das Ergebnis stimmt
        System.out.println(Arrays.toString(result));
    }
}
