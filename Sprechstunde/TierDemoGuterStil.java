/**
 * Die Klasse Tier repräsentiert ein Tier mit einer Art.
 * Die Art wird als private Variable gekapselt und über Getter/Setter angesprochen.
 */
class Tier {
    // Private Instanzvariable (guter Stil)
    private String art;

    /**
     * Konstruktor zur Initialisierung eines Tier-Objekts mit einer Art.
     * @param art Die Art des Tieres.
     */
    public Tier(String art) {
        // Direkter Zugriff auf das private Feld innerhalb der Klasse (im Konstruktor) ist ok.
        // 'this.art' unterscheidet das Feld von dem Parameter.
        this.art = art;
    }

    /**
     * Getter-Methode für das Feld 'art'.
     * Ermöglicht das Lesen des Wertes von außen.
     * @return Die Art des Tieres.
     */
    public String getArt() {
        return this.art; // Oder einfach: return art;
    }

    /**
     * Setter-Methode für das Feld 'art'.
     * Ermöglicht das kontrollierte Ändern des Wertes von außen.
     * @param neueArt Die neue Art, die für das Tier gesetzt werden soll.
     */
    public void setArt(String neueArt) {
        // Hier könnte man Validierungslogik einfügen, z.B.:
        // if (neueArt != null && !neueArt.trim().isEmpty()) {
        //     this.art = neueArt;
        // } else {
        //     System.err.println("Fehler: Ungültige Art übergeben.");
        // }
        this.art = neueArt; // Einfache Zuweisung ohne Validierung hier
    }

    /**
     * Eine Methode, die die Art des Tieres ausgibt.
     * Sie greift intern auf das private Feld 'art' zu.
     */
    public void zeigeArt() {
        // Direkter Zugriff auf private Felder innerhalb derselben Klasse ist erlaubt.
        System.out.println("Dieses Tier ist ein(e): " + this.art);
    }
}

/**
 * Hauptklasse zum Demonstrieren der Tier-Klasse mit gutem Stil.
 */
public class TierDemoGuterStil {

    public static void main(String[] args) {
        // Instanz 1: Ein Hund, erzeugt über den Konstruktor
        Tier tier1 = new Tier("Hund");

        // Instanz 2: Eine Katze, erzeugt über den Konstruktor
        Tier tier2 = new Tier("Katze");

        // Datenzugriff über die Getter-Methode
        System.out.println("Tier 1 ist ein(e): " + tier1.getArt());
        tier1.zeigeArt(); // Aufruf der Instanzmethode

        System.out.println("Tier 2 ist ein(e): " + tier2.getArt());
        tier2.zeigeArt(); // Aufruf der Instanzmethode

        System.out.println("\n--- Ändere die Art von Tier 1 ---");
        // Datenänderung über die Setter-Methode
        tier1.setArt("Dackel");

        // Überprüfung der Änderung über den Getter
        System.out.println("Tier 1 ist jetzt ein(e): " + tier1.getArt());
        tier1.zeigeArt();

        // Versuch des direkten Zugriffs (führt jetzt zu Compiler-Fehlern!)
        // System.out.println(tier1.art); // FEHLER: art has private access in Tier
        // tier1.art = "Mops";          // FEHLER: art has private access in Tier
    }
}