package taschenrechner;

/**
 * 
 * Klasse die die Studenten schreiben muessen
 * 
 **/

public class Rechenwerk {

    public int rechnen(int zahl1, int zahl2, char op) {

        int ergebnis = 0;

        switch (op) {
        case '+':
            ergebnis = zahl1 + zahl2;
            break;
        case '-':
            ergebnis = zahl1 - zahl2;
            break;
        case '*':
            ergebnis = zahl1 * zahl2;
            break;
        case '/':
            ergebnis = zahl1 / zahl2;
            break;
        }
        return ergebnis;
    }
}