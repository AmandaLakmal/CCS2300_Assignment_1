package Module_1;

import java.util.*;

public class Graph {
    private Map<String, List<String>> adjList = new HashMap<>();

    public void addLocation(String location) {
        adjList.putIfAbsent(location, new ArrayList<>());
    }

    public void addRoad(String source, String destination) {
        if (!adjList.containsKey(source) || !adjList.containsKey(destination)) {
            System.out.println("One or both locations not found.");
            return;
        }

        adjList.get(source).add(destination);
        adjList.get(destination).add(source);
        System.out.println("Road added successfully between " + source + " and " + destination + ".");
    }
public void displayConnections() {

        System.out.println("Road Connections:");

        for (String location : adjList.keySet()) {

            System.out.println(location + " -> " + adjList.get(location));

        }

    }



    public void bfs(String start) {

        if (!adjList.containsKey(start)) {

            System.out.println("Location not found.");

            return;

        }



        Set<String> visited = new HashSet<>();

        Queue<String> queue = new LinkedList<>();



        visited.add(start);

        queue.add(start);



        System.out.print("BFS Traversal starting from " + start + ": ");



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
