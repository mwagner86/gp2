import java.io.File;
import java.io.IOException;

/**
 * Testen der Methoden der Klasse File.
 *
 * @author skalt
 * @version 2.0 07/2009
 */
public class TestFile {
    /**
     * Main-Methode.
     *
     * @param args
     *            Uebergabeparameter
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // Datei erzeugen
        File testDatei = erzeugeDatei("TestFile.txt");
        if (testDatei.setReadOnly())
            System.out.println("ReadOnly erfolgreich\n");


        // Dateiinformationen anzeigen
        zeigeFileInfos(testDatei);
    }

    /**
     * Methode zum Erzeugen einer neuen Datei mit dem uebergebenen Dateinamen.
     *
     * @param dateiName
     *            Name der zu erzeugenden Datei
     * @return erzeugtes File-Objekt
     * @throws IOException
     */
    private static File erzeugeDatei(String dateiName) throws IOException {
        // Dateiobjekt mit entsprechendem Namen erzeugen
        File testDatei = new File(dateiName);
        // leere Datei erzeugen
        testDatei.createNewFile();
        testDatei.setWritable(true);
        return testDatei;
    }

    /**
     * Informationen zum uebergebenen File-Objekt unter Verwendung von Methoden
     * der Klasse File anzeigen.
     *
     * @param testDatei
     *            File-Objekt zu dem Informationen angezeigt werden sollen
     */
    private static void zeigeFileInfos(File testFile) {
        System.out.println("\nInformationen:\n");
        System.out.println("Name= " + testFile.getName());
        System.out.println("Path= " + testFile.getPath());
        System.out.println("AbsolutePath= " + testFile.getAbsolutePath());
        System.out.println("Parent= " + testFile.getParent());
        System.out.println("exists= " + testFile.exists());
        System.out.println("canRead= " + testFile.canRead());
        System.out.println("canWrite= " + testFile.canWrite());
        System.out.println("isFile= " + testFile.isFile());
        System.out.println("isDirectory= " + testFile.isDirectory());
    }
    /**
     * Schreibzugriff für uebergebene Datei verweigern.
     *
     * @param testDatei
     */
    private static void verweigereZugriff(File testDatei) {

        System.out.println("Datei Zugriff auf ReadOnly gesetzt\n");
        testDatei.setReadOnly();
    }
}