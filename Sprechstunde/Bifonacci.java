import java.util.Scanner;

public class Bifonacci {

    // Methode zur Berechnung der Bifonaccizahlen 2. Art
    public static int biff(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Der Wert von biff für negative Zahlen ist nicht definiert");
        }
        if (n == 0 || n == 1) {
            return 1; // Basisfälle
        }
        // Rekursive Berechnung
        return biff(n - 1) * biff(n - 2) + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bitte geben Sie eine Zahl n ein: ");
        int n = scanner.nextInt(); // Inputabfrage
        System.out.println("biff(" + n + ") = " + biff(n));
        scanner.close();
    }
}


