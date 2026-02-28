import java.util.Scanner;
import Module_1.Graph; // Importing Module 1
import module_2.DataSorter; // Importing Module 2
import module_3.LocationBST; // Importing Module 3 components
import module_3.PerformanceAnalyzer;

/**
 * Main entry point for the Smart City Data Structures application.
 * Provides a unified menu-driven console interface to integrate and test all modules.
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Initialize Shared/Module components
        Graph graph = new Graph();
        LocationBST locationTree = new LocationBST();
        PerformanceAnalyzer analyzer = new PerformanceAnalyzer();
        boolean running = true;

        System.out.println("==================================================");
        System.out.println("   Smart City & Sorting Data App (Assignment 1)   ");
        System.out.println("==================================================");

        // The Menu-Driven Interface loop
        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Module 1: Smart City Route Planner");
            System.out.println("2. Module 2: Sorting Algorithm Comparison Tool");
            System.out.println("3. Module 3: Algorithm Performance Analyzer (Includes BST Test)");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            // Input validation: Check if the user actually entered a number
            if (!scanner.hasNextInt()) {
                System.out.println("Error: Invalid input. Please enter a valid number.");
                scanner.next(); // Clear the invalid input from the scanner
                continue;       // Restart the loop to show the menu again
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the newline character from the buffer

            switch (choice) {
                case 1:
                    // Launching Module 1 sub-menu
                    runModule1(scanner, graph, locationTree);
                    break;
                    
                case 2:
                    // Launching the Module 2 component
                    System.out.println("\n-- Launching Module 2 (Sorting Tool) --");
                    DataSorter module2 = new DataSorter();
                    module2.runModule();
                    break;
                    
                case 3:
                    System.out.println("\n-- Launching Module 3 --");
                    
                    System.out.println("\n--- Testing Location BST (Hardcoded Data) ---");
                    // Hardcoding test data to demonstrate tree functionality
                    locationTree.insert(102, "Kandy");
                    locationTree.insert(101, "Colombo");
                    locationTree.insert(103, "Galle");
                    locationTree.displayLocations(); 
                    
                    System.out.println("\n--- Running Performance Analyzer ---");
                    // Executes both the searching and sorting performance tests
                    analyzer.analyzeSearchPerformance();
                    analyzer.analyzeSortPerformance();
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

    // =====================================================================
    // SUB-MENU FOR MODULE 1
    // =====================================================================
    private static void runModule1(Scanner scanner, Graph graph, LocationBST bst) {
        int choice = -1;
        do {
            System.out.println("\n--- MODULE 1: SMART CITY ROUTE PLANNER ---");
            System.out.println("1. Add Location");
            System.out.println("2. Add Road");
            System.out.println("3. Display Locations (BST)");
            System.out.println("4. Display Road Connections");
            System.out.println("5. BFS Traversal");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Error: Invalid input.");
                scanner.next(); // clear buffer
                continue;
            }
            
            choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter location ID (number): ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // clear buffer
                    
                    System.out.print("Enter location name: ");
                    String location = scanner.nextLine();
                    
                    // Maps to the Graph and Tree structure as required
                    bst.insert(id, location);
                    graph.addLocation(location);
                    System.out.println("Location '" + location + "' added successfully!");
                    break;
                    
                case 2:
                    System.out.print("Enter source location: ");
                    String source = scanner.nextLine();
                    System.out.print("Enter destination location: ");
                    String destination = scanner.nextLine();
                    
                    graph.addRoad(source, destination);
                    break;
                    
                case 3:
                    System.out.println("\n--- Locations (BST) ---");
                    bst.displayLocations();
                    break;
                    
                case 4:
                    System.out.println("\n--- Road Connections (Graph) ---");
                    graph.displayConnections();
                    break;
                    
                case 5:
                    System.out.print("Enter starting location for BFS: ");
                    String start = scanner.nextLine();
                    
                    graph.bfs(start);
                    break;
                    
                case 0:
                    System.out.println("Returning to Main Menu...");
                    break;
                    
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
    }
}

