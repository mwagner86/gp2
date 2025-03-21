
import java.io.File;
import java.io.IOException;

public class DateiKopierenAufgabe {
    /**
     * Main-Methode
     *
     * @param args
     *            Uebergabeparamater
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // Uebergabeparameter pruefen
        if (args.length != 3) {
            System.out.println("\nAufruf des Programms:\n"
                    + "java DateiKopierenAufgabe datei quellVerz zielVerz");
            System.out.println("\ndatei: Datei, die kopiert wird.");
            System.out.println("quellVerz: Verzeichnis, in dem die zu "
                    + "kopierende Datei gespeichert ist.");
            System.out.println("zielVerz: Zielverzeichnis, in das die "
                    + "Quelldatei kopiert werden soll.");
            System.exit(1);
        }
        // Datei kopieren
        DateiKopieren.kopiereDatei(args[1]+ File.separatorChar + args[0],
                args[2] + File.separatorChar + args[0]);
    }
}