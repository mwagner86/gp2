import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Bytes werden aus Bild-Datei gelesen; einzelne Bytes werden veraendert und
 * wieder in Datei gespeichert.
 *
 * @author skalt
 * @version 2.0 07/2009
 */
public class BinaerDatenManipulierenB {

    /**
     * Main-Methode.
     *
     * @param args
     *            Namen der Bilddateien
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        // Pruefen, ob zwei Uebergabeparameter bei Programmaufruf angegeben
        // wurden
        if (args.length != 2) {
            System.out
                    .println("Fehler!\nAufruf des Programms ohne Dateiangaben.");
            System.exit(1);
        }

        // Dateinamen aus Uebergabeparametern lesen
        String bildDateiOriginal = args[0];
        String bildDateiGeand = args[1];

        // Methode zum Manipulieren von Bytes im Originalbild aufrufen
        manipuliereBytesInBild(bildDateiOriginal, bildDateiGeand);
    }

    /**
     * Methode zum Manipuliere einzelner Bytes in einem Bild. Das manipulierte
     * Bild wird unter dem uebergebenen neuen Dateinamen abgespeichert.
     *
     * @param bildDateiOriginal
     *            Dateiname des Originalbildes
     * @param bildDateiGeand
     *            Dateiname des Bildes mit den manipulierten Bytes
     * @throws IOException
     */
    public static void manipuliereBytesInBild(String bildDateiOriginal,
                                              String bildDateiGeand) throws IOException {
        // Datei einlesen - Eingabestroeme oeffnen
        FileInputStream fiStream = new FileInputStream(bildDateiOriginal);
        DataInputStream diStream = new DataInputStream(fiStream);

        // File Objekt erzeugen
        File originalDatei = new File(bildDateiOriginal);
        // Dateigroesse ermitteln
        int dateiGroesse = (int) originalDatei.length();

        // Byte-Array entsprechend der Groesse der Originalbilddatei in Bytes
        // erzeugen
        byte[] byteA = new byte[dateiGroesse];

        // Bytes mittels read() in das Byte-Array einlesen
        diStream.read(byteA);
        // Eingabestrom schliessen
        diStream.close();

        // Bytes an einzelnen Positionen aendern
        byteA[60] = -126;
        byteA[1060] = 126;
        byteA[1400] = -112;

        // neue Datei erzeugen - Ausgabestroeme oeffnen
        FileOutputStream foStream = new FileOutputStream(bildDateiGeand);
        DataOutputStream doStream = new DataOutputStream(foStream);

        // Bytes in neue Datei speichern
        doStream.write(byteA);
        // Bytes aus internem Puffer in den FileOutputStream schreiben
        doStream.flush();
        // Ausgabestrom schliessen
        doStream.close();

        // Benutzerausgabe
        System.out.println("Geaendertes Bild wurde in die Datei '"
                + bildDateiGeand + "' gespeichert.");
    }
}