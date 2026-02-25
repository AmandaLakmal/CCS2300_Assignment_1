import java.util.Scanner;
import module_3.LocationBST;
import module_3.PerformanceAnalyzer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Initialize your Module 3 components
        LocationBST locationTree = new LocationBST();
        PerformanceAnalyzer analyzer = new PerformanceAnalyzer();
        boolean running = true;

        System.out.println("==================================================");
        System.out.println("   Smart City & Sorting Data App (Assignment 1)   ");
        System.out.println("==================================================");

        // The Menu-Driven Interface
        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Test Location Tree (BST)");
            System.out.println("2. Run Algorithm Performance Analyzer");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n-- Testing Location BST --");
                    // Hardcoding some test data to prove your tree works
                    locationTree.insert(102, "Kandy");
                    locationTree.insert(101, "Colombo");
                    locationTree.insert(103, "Galle");
                    locationTree.displayLocations(); 
                    break;
                case 2:
                    System.out.println("\n-- Running Performance Analyzer --");
                    // Runs your binary search timer and prints the table
                    analyzer.analyzeSearchPerformance();
                    break;
                case 3:
                    System.out.println("Exiting the application. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }
        scanner.close();
    }
}
