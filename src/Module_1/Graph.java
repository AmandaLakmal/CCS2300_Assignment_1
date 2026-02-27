package Module_1;

import java.util.*;

/*
 * Graph
 * Represents roads using adjacency list
 */
public class Graph {

    private Map<String, List<String>> adjList = new HashMap<>();

    // Add location
    public void addLocation(String location) {
        adjList.putIfAbsent(location, new ArrayList<>());
    }
    // Add road (Undirected)
    public void addRoad(String source, String destination) {

        if (!adjList.containsKey(source) || !adjList.containsKey(destination)) {
            System.out.println("One or both locations not found.");
            return;
        }

        adjList.get(source).add(destination);
        adjList.get(destination).add(source);

        System.out.println("Road added successfully.");
    }

    // Display connections
    public void displayConnections() {

        System.out.println("Road Connections:");

        for (String location : adjList.keySet()) {
            System.out.println(location + " -> " + adjList.get(location));
        }
    }
    // BFS Traversal
    public void bfs(String start) {

        if (!adjList.containsKey(start)) {
            System.out.println("Location not found.");
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
