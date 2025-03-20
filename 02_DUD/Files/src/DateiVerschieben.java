import java.io.File;
import java.io.IOException;

public class DateiVerschieben {

    /**
     * Main-Methode
     *
     * @param args Uebergabeparamater
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // Uebergabeparameter pruefen
        if (args.length != 3) {
            System.out.println("\nAufruf des Programms:\n"
                    + "java DateiVerschieben datei  quellVerz zielVerz");
            System.out.println("\ndatei:  Datei die verschoben werden soll.");
            System.out.println("quellVerz:  Verzeichnis in der die zu "
                    + "verschiebende Datei gespeichert ist.");
            System.out.println("zielVerz:  Zielverzeichnis in das die "
                    + "Quelldatei verschoben werden soll.");
            System.exit(1);
        }
        // Datei verschieben
        verschiebeDatei(args[0], args[1], args[2]);
    }

    public static void verschiebeDatei(String datei, String quellVerz,
                                       String zielVerz) {
        try {
            DateiKopieren.kopiereDatei(quellVerz + File.separatorChar + datei,
                    zielVerz + File.separatorChar + datei);
            DateiLoeschen.loescheDatei(datei, quellVerz);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}