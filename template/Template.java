/*
 * Java Project Template
 *
 * This template provides a basic structure for a Java project.
 * It includes a main class, a utility class, and a simple example of object-oriented programming.
 */

// Package declaration (modify based on your project structure)
package template;

// Import statements (add necessary imports as needed)
import java.util.Scanner;

/**
 * Main class that serves as the entry point of the application.
 */
public class Template {
    
    /**
     * Main method: This is where the program execution starts.
     *
     * @param args Command-line arguments (not used in this example)
     */
    public static void main(String[] args) {
        // Print a welcome message
        System.out.println("Welcome to the Java Project Template!");
        
        // Create an instance of the Utility class
        Utility utility = new Utility();
        
        // Call a method to get user input
        String userInput = utility.getUserInput();
        
        // Display the user's input
        System.out.println("You entered: " + userInput);
    }
}

/**
 * A utility class that provides helper methods.
 */
class Utility {
    
    // Scanner object for reading user input
    private Scanner scanner;
    
    /**
     * Constructor: Initializes the scanner.
     */
    public Utility() {
        scanner = new Scanner(System.in);
    }
    
    /**
     * Method to get user input from the console.
     *
     * @return The user's input as a String.
     */
    public String getUserInput() {
        System.out.print("Enter something: ");
        return scanner.nextLine();
    }
}
