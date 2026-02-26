import java.util.*;

public class Graph {

    private Map<String, List<String>> adjList = new HashMap<>();

    public void addLocation(String location) {
        adjList.putIfAbsent(location, new ArrayList<>());
        System.out.println("Location added.");
    }

    public void removeLocation(String location) {
        adjList.remove(location);
        for (List<String> neighbours : adjList.values()) {
            neighbours.remove(location);
        }
        System.out.println("Location removed.");
    }

    public void addRoad(String src, String dest) {
        if (adjList.containsKey(src) && adjList.containsKey(dest)) {
            adjList.get(src).add(dest);
            adjList.get(dest).add(src); // undirected
            System.out.println("Road added.");
        } else {
            System.out.println("Location not found!");
        }
    }

    public void removeRoad(String src, String dest) {
        if (adjList.containsKey(src) && adjList.containsKey(dest)) {
            adjList.get(src).remove(dest);
            adjList.get(dest).remove(src);
            System.out.println("Road removed.");
        }
    }

    public void display() {
        for (String key : adjList.keySet()) {
            System.out.println(key + " -> " + adjList.get(key));
        }
    }

    // BFS Traversal (Queue)
    public void bfs(String start) {
        if (!adjList.containsKey(start)) {
            System.out.println("Location not found!");
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