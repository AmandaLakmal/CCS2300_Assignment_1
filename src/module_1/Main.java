package smartcity;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BST bst = new BST();
        Graph graph = new Graph();

        int choice = 0;

        do {
            System.out.println("\n--- Smart City Route Planner ---");
            System.out.println("1. Add Location(s)");
            System.out.println("2. Remove Location");
            System.out.println("3. Add Road");
            System.out.println("4. Remove Road");
            System.out.println("5. Display Connections");
            System.out.println("6. BFS Traversal");
            System.out.println("7. DFS Traversal");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            // Safe input handling
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine(); // clear buffer
            } else {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine();
                continue;
            }

            switch (choice) {

                case 1:
                    System.out.println("Enter location names separated by commas (e.g., Colombo,Kandy,Galle): ");
                    String input = sc.nextLine();

                    String[] locations = input.split(",");

                    for (String loc : locations) {
                        loc = loc.trim();

                        if (!loc.isEmpty()) {
                            if (!bst.search(loc)) {
                                bst.insert(new Location(loc));
                                graph.addLocation(loc);
                                System.out.println(loc + " added successfully.");
                            } else {
                                System.out.println(loc + " already exists!");
                            }
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter location name to remove: ");
                    String removeLoc = sc.nextLine();

                    if (bst.search(removeLoc)) {
                        graph.removeLocation(removeLoc);
                        System.out.println(removeLoc + " removed successfully.");
                    } else {
                        System.out.println("Location not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter source location: ");
                    String src = sc.nextLine();

                    System.out.print("Enter destination location: ");
                    String dest = sc.nextLine();

                    if (!bst.search(src) || !bst.search(dest)) {
                        System.out.println("One or both locations do not exist!");
                        break;
                    }

                    graph.addRoad(src, dest);
                    System.out.println("Road added successfully.");
                    break;

                case 4:
                    System.out.print("Enter source location: ");
                    String rsrc = sc.nextLine();

                    System.out.print("Enter destination location: ");
                    String rdest = sc.nextLine();

                    graph.removeRoad(rsrc, rdest);
                    System.out.println("Road removed successfully.");
                    break;

                case 5:
                    graph.displayConnections();
                    break;

                case 6:
                    System.out.print("Enter starting location for BFS: ");
                    String bfsStart = sc.nextLine();

                    if (bst.search(bfsStart)) {
                        graph.bfs(bfsStart);
                    } else {
                        System.out.println("Location not found!");
                    }
                    break;

                case 7:
                    System.out.print("Enter starting location for DFS: ");
                    String dfsStart = sc.nextLine();

                    if (bst.search(dfsStart)) {
                        graph.dfs(dfsStart);
                    } else {
                        System.out.println("Location not found!");
                    }
                    break;

                case 8:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 8);

        sc.close();
    }
}