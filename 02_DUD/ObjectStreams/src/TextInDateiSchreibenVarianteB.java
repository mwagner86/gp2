import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Klasse zur Kombination von Ein- und Ausgabestroemen: Text wird ueber die
 * Tastatur eingelesen und in eine Datei geschrieben.
 *
 * @author skalt
 * @version 2.0 07/2009
 */

public class TextInDateiSchreibenVarianteB {
    /**
     * Main-Methode.
     *
     * @param args
     *            Uebergabeparameter
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // Dateiname ohne Pfadangabe
        String dateiName = "TestDatei.txt";
        // Methode zum Schreiben in eine Datei aufrufen
        schreibeTextInDatei(dateiName);
    }

    /**
     * Methode zum Testen 
     * Schreiben von Text, der ueber die Tastatur eingegeben wird, in eine Datei.
     *
     * @param dateiName
     *            Name der Datei in die Text geschrieben wird
     * @throws IOException
     */
    public static void schreibeTextInDatei(String dateiName) throws IOException {
        // Benutzerhinweise anzeigen
        System.out.println("Geben Sie einen Text ein und beenden Sie Ihre "
                + "Eingabe mit Enter.");
        // Eingabestroeme erzeugen und miteinander verbinden
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        // Datenfluss: Programm <-- bReader <-- InputStreamReader <-- Standardeingabe

        // Ausgabestroeme erzeugen und miteinander verbinden
        BufferedWriter bWriter = new BufferedWriter(new FileWriter(dateiName));
        // Datenfluss: Programm --> bWriter --> FileWriter --> Datei

        String text;
        String antwort;

        do {
            // ueber Tastatur eingegebenen Text zwischenspeichern
            text = bReader.readLine();
            // Zeichenfolge aus der Variable text wird in die Datei geschrieben
            bWriter.write(text + "\n");
            // Abfrage ob Benutzer weitere daten eingeben will
            System.out.print("Wollen Sie noch eine Zeile hinzufuegen? "
                    + "(ja = j, nein = n): ");
            // Antwort des Benutzers einlesen
            antwort = bReader.readLine();
        } while (antwort.equals("j"));

        // Eingabestrom wird geschlossen
        bReader.close();
        // Ausgabestrom wird geschlossen
        bWriter.close();
        // Benutzerhinweise anzeigen
        System.out.println("Ihre Eingaben wurden in die Datei '" + dateiName + "' gespeichert.");
    }
}