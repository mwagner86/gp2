import java.io.*;
import java.util.Objects;

/**
 * Klasse zur Kombination von Ein- und Ausgabestroemen: Text wird ueber die
 * Tastatur eingelesen und in eine Datei geschrieben.
 *
 * @author skalt
 * @version 2.0 07/2009
 */
public class TextInDateiSchreiben {
    /**
     * Main-Methode.
     *
     * @param args Uebergabeparameter
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // Dateiname ohne Pfadangabe
        String dateiName = "TestDatei.txt";
        // Methode zum Schreiben in eine Datei aufrufen
        schreibeTextInDatei(dateiName);
    }

    /**
     * Methode zum Testen Schreiben von Text, der ueber die Tastatur eingegeben
     * wird, in eine Datei.
     *
     * @param dateiName Name der Datei in welche Text geschrieben wird
     * @throws IOException
     */
    public static void schreibeTextInDatei(String dateiName) throws IOException {
        // Benutzerhinweise anzeigen
        System.out.println("Geben Sie einen Text ein und beenden Sie Ihre Eingabe mit Enter.");

        // Eingabestrom erzeugen
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

        // FileWriter im Append-Modus oeffnen
        BufferedWriter bWriter = new BufferedWriter(new FileWriter(dateiName, true));

        boolean continue_writing = true;
        while (continue_writing) {
            // Text von der Tastatur einlesen
            String text = bReader.readLine();

            // Text in die Datei schreiben
            bWriter.write(text);
            bWriter.newLine();
            bWriter.flush();

            // Benutzerhinweise anzeigen
            System.out.println("Wollen Sie noch eine Zeile hinzufuegen? (ja = j, nein = n):");
            String response = bReader.readLine();
            if (!(Objects.equals(response, "ja") || Objects.equals(response, "j"))) {
                continue_writing = false;
            }
        }

        // Resourcen freigeben
        bReader.close();
        bWriter.close();

        System.out.println("Ihre Eingaben wurden in die Datei '" + dateiName + "' gespeichert.");
    }
}
