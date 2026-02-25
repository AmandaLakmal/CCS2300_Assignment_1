
import java.util.Scanner;
import module_2.DataSorter; // Importing Module 2 (Sorting Algorithms)
import module_3.LocationBST;
import module_3.PerformanceAnalyzer;

/**
 * Main entry point for the Smart City Data Structures application.
 * Provides a menu-driven console interface to integrate and test all modules.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Initialize Module 3 components for integration testing
        LocationBST locationTree = new LocationBST();
        PerformanceAnalyzer analyzer = new PerformanceAnalyzer();
        boolean running = true;

        System.out.println("==================================================");
        System.out.println("   Smart City & Sorting Data App (Assignment 1)   ");
        System.out.println("==================================================");

        // The Menu-Driven Interface loop
        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Test Location Tree (BST)");
            System.out.println("2. Run Algorithm Performance Analyzer");
            System.out.println("3. Sorting Algorithm Comparison Tool");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            // Input validation: Check if the user actually entered a number
            if (!scanner.hasNextInt()) {
                System.out.println("Error: Invalid input. Please enter a valid number.");
                scanner.next(); // Clear the invalid input from the scanner
                continue;       // Restart the loop to show the menu again
            }

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n-- Testing Location BST --");
                    // Hardcoding test data to demonstrate tree functionality
                    locationTree.insert(102, "Kandy");
                    locationTree.insert(101, "Colombo");
                    locationTree.insert(103, "Galle");
                    locationTree.displayLocations(); 
                    break;
                case 2:
                    System.out.println("\n-- Running Performance Analyzer --");
                    // Executes both the searching and sorting performance tests
                    analyzer.analyzeSearchPerformance();
                    analyzer.analyzeSortPerformance();
                    break;
                case 3:
                    // Launching the Module 2 component
                    System.out.println("\n-- Launching Module 2 (Sorting Tool) --");
                    DataSorter module2 = new DataSorter();
                    module2.runModule();
                    break;
                case 4:
                    System.out.println("Exiting the application. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Error: Invalid choice. Please enter 1, 2, 3, or 4.");
            }
        }
        scanner.close();
    }
}
