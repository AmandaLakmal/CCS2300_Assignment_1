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

