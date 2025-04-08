package ueb3;
import java.util.Objects;

// Enum für Richtungen
enum Direction {
    LEFT, RIGHT
}

// Enum für Schaltvorgänge
enum GearChange {
    UP, DOWN
}

/**
 * Interface für fahrbare Objekte.
 * Definiert Methoden zum Abbiegen und Schalten.
 */
interface Drivable {
    void turn(Direction direction);
    void changeGear(GearChange change);
    int getCurrentGear(); // Hilfsmethode, um den aktuellen Gang zu sehen
}

/**
 * Klasse Bike, implementiert Drivable.
 */
class Bike implements Drivable {
    private static final int MAX_GEARS = 21;
    private int currentGear;

    public Bike() {
        // Fahrräder starten oft im niedrigsten Gang
        this.currentGear = 1;
        System.out.println("Bike created in gear " + this.currentGear);
    }

    @Override
    public void turn(Direction direction) {
        // Einfaches Abbiegen ohne Gangwechsel
        System.out.println("Bike turning " + direction + " (currently in gear " + this.currentGear + ")");
    }

    @Override
    public void changeGear(GearChange change) {
        int previousGear = this.currentGear;
        if (change == GearChange.UP && this.currentGear < MAX_GEARS) {
            this.currentGear++;
        } else if (change == GearChange.DOWN && this.currentGear > 1) {
            this.currentGear--;
        }

        if (previousGear != this.currentGear) {
            System.out.println("Bike changing gear " + change + " to " + this.currentGear);
        } else {
            System.out.println("Bike already in " + (change == GearChange.UP ? "highest" : "lowest") + " gear (" + this.currentGear + "). Cannot change " + change + ".");
        }
    }

    @Override
    public int getCurrentGear() {
        return this.currentGear;
    }
}

/**
 * Klasse Car, implementiert Drivable.
 */
class Car implements Drivable {
    private static final int MAX_GEARS = 6;
    private int currentGear;

    public Car() {
        // Autos starten im Standardgang 3
        this.currentGear = 3;
        System.out.println("Car created in gear " + this.currentGear);
    }

    @Override
    public void turn(Direction direction) {
        System.out.println("Car prepares to turn " + direction + "...");
        int originalGear = this.currentGear;

        // Runterschalten vor dem Abbiegen
        changeGearInternal(GearChange.DOWN); // Interner Aufruf ohne redundante Nachricht

        // Abbiegen (Nachricht ausgeben)
        System.out.println("Car TURNING " + direction + " in gear " + this.currentGear);

        // Wieder hochschalten auf den ursprünglichen Gang (oder den höchsten, falls der ursprüngliche nicht mehr erreichbar war)
        // Hier einfachheitshalber: Schalte wieder hoch, aber nicht über den originalen Gang hinaus
        // Bessere Logik: Merken, ob geschaltet wurde, und nur dann zurückschalten.
        // Einfache Version: Gehe zurück zum Originalgang, wenn möglich.
        // Alternative: Schalte einfach einmal hoch nach dem Abbiegen.
        changeGearInternal(GearChange.UP); // Schaltet wieder einen Gang hoch

        // Sicherstellen, dass wir nicht über den originalen Gang hinausgehen, falls wir z.B. in Gang 1 waren.
        // Oder: Setze explizit zurück, falls möglich.
        // Die aktuelle Logik schaltet einfach einmal runter und einmal hoch.

        // Falls der Gang nach "hochschalten" nicht der Originalgang ist und der Originalgang gültig war:
        // if (this.currentGear != originalGear && originalGear >= 1 && originalGear <= MAX_GEARS) {
             // Optional: explizit zurücksetzen, falls die Logik komplexer sein soll.
             // this.currentGear = originalGear;
             // System.out.println("Car returns to original gear " + this.currentGear);
        // }

        System.out.println("Car finished turning " + direction + ", now in gear " + this.currentGear);


    }

    @Override
    public void changeGear(GearChange change) {
        // Diese Methode ist für externe Schaltaufforderungen
        changeGearInternal(change);
        System.out.println("Car explicitly changed gear to " + this.currentGear);
    }

     // Private Hilfsmethode zum Schalten, um Ausgaben zu steuern
    private void changeGearInternal(GearChange change) {
        int previousGear = this.currentGear;
        if (change == GearChange.UP && this.currentGear < MAX_GEARS) {
            this.currentGear++;
            System.out.println("Car shifts UP to gear " + this.currentGear);
        } else if (change == GearChange.DOWN && this.currentGear > 1) {
            this.currentGear--;
             System.out.println("Car shifts DOWN to gear " + this.currentGear);
        } else {
             System.out.println("Car already in " + (change == GearChange.UP ? "highest" : "lowest") + " gear (" + this.currentGear + "). Cannot shift " + change + ".");
        }
    }


    @Override
    public int getCurrentGear() {
        return this.currentGear;
    }
}

/**
 * Demo-Klasse zum Testen von Bike und Car über das Drivable Interface.
 */
public class DriveDemo {

    public static void main(String[] args) {
        Drivable d; // Deklaration mit Interface-Typ

        System.out.println("----- Testing Bike -----");
        d = new Bike(); // Zuweisung einer Bike-Instanz
        System.out.println("Current gear: " + d.getCurrentGear());
        d.turn(Direction.LEFT);
        d.changeGear(GearChange.UP);
        d.changeGear(GearChange.UP);
        d.turn(Direction.RIGHT);
        d.changeGear(GearChange.DOWN);
        d.changeGear(GearChange.DOWN);
        d.changeGear(GearChange.DOWN); // Versuch, unter Gang 1 zu kommen

        System.out.println("\n----- Testing Car -----");
        d = new Car(); // Zuweisung einer Car-Instanz
        System.out.println("Current gear: " + d.getCurrentGear());
        d.turn(Direction.LEFT); // Sollte runterschalten, abbiegen, hochschalten
        System.out.println("Current gear after turn: " + d.getCurrentGear());
        d.changeGear(GearChange.UP); // Explizites Schalten
        System.out.println("Current gear after explicit shift: " + d.getCurrentGear());
        d.turn(Direction.RIGHT); // Wieder abbiegen
        System.out.println("Current gear after 2nd turn: " + d.getCurrentGear());
        d.changeGear(GearChange.UP);
        d.changeGear(GearChange.UP);
        d.changeGear(GearChange.UP); // Versuch über Gang 6 zu kommen


    }
}