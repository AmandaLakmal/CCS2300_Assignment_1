package Module_1;

import java.util.Scanner;

public class RoutePlanner {

    private Graph graph = new Graph();
    private LocationTree tree = new LocationTree();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        int choice;

        do {
            System.out.println("\n--- Smart City Route Planner ---");
            System.out.println("1. Add Location");
            System.out.println("2. Remove Location");
            System.out.println("3. Add Road");
            System.out.println("4. Remove Road");
            System.out.println("5. Display Connections");
            System.out.println("6. BFS Traversal");
            System.out.println("7. Display Locations (Tree)");
            System.out.println("0. Exit");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter location name: ");
                    String loc = scanner.nextLine();
                    tree.insert(loc);
                    graph.addLocation(loc);
                    break;

                case 2:
                    System.out.print("Enter location name: ");
                    graph.removeLocation(scanner.nextLine());
                    break;

                case 3:
                    System.out.print("Source: ");
                    String s = scanner.nextLine();
                    System.out.print("Destination: ");
                    String d = scanner.nextLine();
                    graph.addRoad(s, d);
                    break;

                case 4:
                    System.out.print("Source: ");
                    s = scanner.nextLine();
                    System.out.print("Destination: ");
                    d = scanner.nextLine();
                    graph.removeRoad(s, d);
                    break;

                case 5:
                    graph.displayConnections();
                    break;

                case 6:
                    System.out.print("Start location: ");
                    graph.bfs(scanner.nextLine());
                    break;

                case 7:
                    tree.inorder();
                    break;
            }

        } while (choice != 0);
    }
}