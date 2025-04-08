package ueb1;
public class Fibonacci {
    
    // Rekursive Methode
    public static int fibonacciRecursive(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Methode (effizienter)
    public static int fibonacciIterative(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;

        int a = 0, b = 1, temp;
        for (int i = 2; i <= n; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        int n = 10; // Beispiel: Fibonacci-Zahl an der Position 10

        System.out.println("Rekursiv: Fibonacci(" + n + ") = " + fibonacciRecursive(n));
        System.out.println("Iterativ: Fibonacci(" + n + ") = " + fibonacciIterative(n));
    }
}
