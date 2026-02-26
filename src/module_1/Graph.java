import java.util.*;


public class Graph {

    private Map<String, List<String>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    // Add new location (vertex)
    public void addLocation(String location) {
        if (!adjList.containsKey(location)) {
            adjList.put(location, new ArrayList<>());
            System.out.println("Location added successfully.");
        } else {
            System.out.println("Location already exists.");
        }
    }

    // Remove location
    public void removeLocation(String location) {
        if (!adjList.containsKey(location)) {
            System.out.println("Location not found.");
            return;
        }

        adjList.remove(location);

        for (List<String> neighbors : adjList.values()) {
            neighbors.remove(location);
        }

        System.out.println("Location removed successfully.");
    }

    // Add road (edge)
    public void addRoad(String source, String destination) {
        if (!adjList.containsKey(source) || !adjList.containsKey(destination)) {
            System.out.println("One or both locations do not exist.");
            return;
        }

        adjList.get(source).add(destination);
        adjList.get(destination).add(source);

        System.out.println("Road added successfully.");
    }

    // Remove road
    public void removeRoad(String source, String destination) {
        if (!adjList.containsKey(source) || !adjList.containsKey(destination)) {
            System.out.println("One or both locations do not exist.");
            return;
        }

        adjList.get(source).remove(destination);
        adjList.get(destination).remove(source);

        System.out.println("Road removed successfully.");
    }

    // Display all connections
    public void displayConnections() {
        if (adjList.isEmpty()) {
            System.out.println("No locations available.");
            return;
        }

        for (String location : adjList.keySet()) {
            System.out.println(location + " -> " + adjList.get(location));
        }
    }

    // BFS Traversal using Queue
    public void bfs(String start) {
        if (!adjList.containsKey(start)) {
            System.out.println("Start location does not exist.");
            return;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        System.out.println("BFS Traversal:");

        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.print(current + " ");

            for (String neighbor : adjList.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        System.out.println();
    }
}