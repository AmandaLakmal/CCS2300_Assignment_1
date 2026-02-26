import java.util.*;

public class Graph {
    private Map<String, List<String>> adjList = new HashMap<>();

    public void addLocation(String location) {
        adjList.putIfAbsent(location, new ArrayList<>());
    }

    public void removeLocation(String location) {
        adjList.remove(location);
        for (List<String> neighbors : adjList.values()) {
            neighbors.remove(location);
        }
    }

    public void addRoad(String source, String destination) {
        adjList.get(source).add(destination);
        adjList.get(destination).add(source);
    }

    public void removeRoad(String source, String destination) {
        adjList.get(source).remove(destination);
        adjList.get(destination).remove(source);
    }

    public void displayConnections() {
        for (String location : adjList.keySet()) {
            System.out.println(location + " -> " + adjList.get(location));
        }
    }

    // BFS Traversal using Queue
    public void bfs(String start) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            String location = queue.poll();
            System.out.print(location + " ");

            for (String neighbor : adjList.get(location)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }
}
