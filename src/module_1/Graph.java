package smartcity;

import java.util.*;

public class Graph {

    private Map<String, List<String>> adjList = new HashMap<>();

    public void addLocation(String location) {
        adjList.putIfAbsent(location, new ArrayList<>());
    }

    public void removeLocation(String location) {
        adjList.remove(location);
        for (String key : adjList.keySet()) {
            adjList.get(key).remove(location);
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

    public void bfs(String start) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

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

    public void dfs(String start) {
        Set<String> visited = new HashSet<>();
        Stack<String> stack = new Stack<>();

        stack.push(start);

        while (!stack.isEmpty()) {
            String current = stack.pop();

            if (!visited.contains(current)) {
                visited.add(current);
                System.out.print(current + " ");
            }

            for (String neighbor : adjList.get(current)) {
                if (!visited.contains(neighbor)) {
                    stack.push(neighbor);
                }
            }
        }
        System.out.println();
    }
}