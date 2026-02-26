import java.util.Scanner;


public class RoutePlanner {

    private Graph graph;
    private LocationTree tree;
    private Scanner scanner;

    public RoutePlanner() {
        graph = new Graph();
        tree = new LocationTree();
        scanner = new Scanner(System.in);
    }

    public void start() {

        int choice;

        do {
            System.out.println("\n====== Smart City Route Planner ======");
            System.out.println("1. Add Location");
            System.out.println("2. Remove Location");
            System.out.println("3. Add Road");
            System.out.println("4. Remove Road");
            System.out.println("5. Display Connections");
            System.out.println("6. BFS Traversal");
            System.out.println("7. Display Locations (BST)");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }

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
                    System.out.print("Enter source location: ");
                    String src = scanner.nextLine();
                    System.out.print("Enter destination location: ");
                    String dest = scanner.nextLine();
                    graph.addRoad(src, dest);
                    break;

                case 4:
                    System.out.print("Enter source location: ");
                    src = scanner.nextLine();
                    System.out.print("Enter destination location: ");
                    dest = scanner.nextLine();
                    graph.removeRoad(src, dest);
                    break;

                case 5:
                    graph.displayConnections();
                    break;

                case 6:
                    System.out.print("Enter start location: ");
                    graph.bfs(scanner.nextLine());
                    break;

                case 7:
                    tree.displayLocations();
                    break;

                case 0:
                    System.out.println("Exiting Module 1...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }
}