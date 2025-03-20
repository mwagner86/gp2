import java.io.File;
import java.io.IOException;

/**
 * Testen der Methoden der Klasse File.
 *
 * @author skalt
 * @version 2.0 07/2009
 */
public class TestDirectory {
    /**
     * Main-Methode.
     *
     * @param args
     *            Uebergabeparamater
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // neues Verzeichnis anlegen
        File testVerz = erstelleVerzeichnis("NeuesVerzeichnis/VFH");
        // temporaere Datei erzeugen
        File tempDatei = erzeugeTempDatei("Temp_Datei", ".tmp", testVerz);
        // Verzeichnisinformationen anzeigen
        zeigeFileInfos(testVerz);
        // Dateiinformationen anzeigen
        zeigeFileInfos(tempDatei);
    }

    /**
     * Methode zum Anlegen einer Verzeichnisstruktur.
     *
     * @param dateiName
     *            Name der zu erzeugenden Datei
     * @return erzeugtes File-Objekt
     * @throws IOException
     */
    private static File erstelleVerzeichnis(String pfad) throws IOException {
        // File-Objekt fuer uebergebenen Pfad erzeugen
        File verz = new File(pfad);
        // Verzeichnisstruktur anlegen
        verz.mkdirs();
        return verz;
    }

    /**
     * Methode zum Erzeugen einer temporaeren Datei.
     *
     * @param dateiPrefix
     *            Prefix fuer temp. Dateiname
     * @param dateiPrefix
     *            Datei-Endung fuer temp. Datei
     * @param verz
     *            Verzeichnis in dem temp. Datei erzeugt wird
     * @return erzeugtes File-Objekt
     * @throws IOException
     */
    private static File erzeugeTempDatei(String dateiPrefix, String dateiEndung,
                                         File verz) throws IOException {
        File tmp = File.createTempFile(dateiPrefix, dateiEndung, verz);
        return tmp;
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
}