package ueb2;

import Tier;

// Definition der Klasse Tier
class Tier {
    // Public Feld (schlechter Stil, besser wäre private + Getter/Setter)
    public String art;

    // Ein einfacher Konstruktor (optional, aber gut für die Initialisierung)
    public Tier(String art) {
        this.art = art;
    }

    // Methode zum Anzeigen der Art (Beispiel)
    public void zeigeArt() {
        System.out.println("Dieses Tier ist ein(e): " + art);
    }
}

// Hauptklasse zum Testen
public class TierDemo {

    public static void main(String[] args) {
        // Instanz 1: Ein Hund
        Tier tier1 = new Tier("Hund");
        // Direkter Zugriff auf das public Feld (möglich, aber nicht empfohlen)
        // tier1.art = "Hund"; // Wäre nötig ohne Konstruktor

        // Instanz 2: Eine Katze
        Tier tier2 = new Tier("Katze");
        // tier2.art = "Katze"; // Wäre nötig ohne Konstruktor

        // Ausgabe der Arten über eine Methode oder direkten Zugriff
        System.out.println("Tier 1 ist ein(e): " + tier1.art);
        tier1.zeigeArt();

        System.out.println("Tier 2 ist ein(e): " + tier2.art);
        tier2.zeigeArt();
    }
}