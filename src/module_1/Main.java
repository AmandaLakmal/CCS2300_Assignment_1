import java.util.Scanner;

public class Main {

    static Graph graph = new Graph();
    static LocationTree tree = new LocationTree();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== SMART CITY ROUTE PLANNER =====");
            System.out.println("1. Add Location");
            System.out.println("2. Remove Location");
            System.out.println("3. Add Road");
            System.out.println("4. Remove Road");
            System.out.println("5. Display Connections");
            System.out.println("6. Traverse (BFS)");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

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
                    loc = scanner.nextLine();
                    graph.removeLocation(loc);
                    break;

                case 3:
                    System.out.print("Enter source: ");
                    String src = scanner.nextLine();
                    System.out.print("Enter destination: ");
                    String dest = scanner.nextLine();
                    graph.addRoad(src, dest);
                    break;

                case 4:
                    System.out.print("Enter source: ");
                    src = scanner.nextLine();
                    System.out.print("Enter destination: ");
                    dest = scanner.nextLine();
                    graph.removeRoad(src, dest);
                    break;

                case 5:
                    graph.display();
                    break;

                case 6:
                    System.out.print("Enter starting location: ");
                    String start = scanner.nextLine();
                    graph.bfs(start);
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);
    }
}
