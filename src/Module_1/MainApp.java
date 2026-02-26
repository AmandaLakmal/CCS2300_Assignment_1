package Module_1;

import Module_1.Graph;
import Module_1.LocationBST;
import java.util.Scanner;

/*
 * MainApp
 * Module 1 - Smart City Route Planner
 *
 * Features:
 * - Add locations (BST + Graph)
 * - Add roads between locations
 * - Display sorted locations
 * - Display road connections
 * - BFS traversal
 */

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LocationBST bst = new LocationBST();
        Graph graph = new Graph();

        int choice;

        do {
            System.out.println("\n===== SMART CITY ROUTE PLANNER =====");
            System.out.println("1. Add Location");
            System.out.println("2. Add Road");
            System.out.println("3. Display Locations (Sorted - BST)");
            System.out.println("4. Display Road Connections");
            System.out.println("5. BFS Traversal");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    System.out.print("Enter location name: ");
                    String location = sc.nextLine();

                    bst.insert(location);
                    graph.addLocation(location);

                    System.out.println("Location added successfully!");
                    break;

                case 2:
                    System.out.print("Enter source location: ");
                    String source = sc.nextLine();

                    System.out.print("Enter destination location: ");
                    String destination = sc.nextLine();

                    graph.addRoad(source, destination);
                    break;

                case 3:
                    System.out.println("\n--- Locations (BST InOrder) ---");
                    bst.displayInOrder();
                    break;

                case 4:
                    System.out.println("\n--- Road Connections ---");
                    graph.displayConnections();
                    break;

                case 5:
                    System.out.print("Enter starting location: ");
                    String start = sc.nextLine();

                    graph.bfs(start);
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 0);

        sc.close();
        System.out.println("Program Ended.");
    }
}
