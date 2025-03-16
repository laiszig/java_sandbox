package graphs;

import java.util.*;

class CompleteGraph {
    private Map<Integer, List<Integer>> adjList;

    public CompleteGraph() {
        this.adjList = new HashMap<>();
    }

    // Add a new node (vertex)
    public void addVertex(int v) {
        adjList.putIfAbsent(v, new ArrayList<>());
    }

    // Add an edge between two nodes (undirected)
    public void addEdge(int v1, int v2) {
        adjList.putIfAbsent(v1, new ArrayList<>());
        adjList.putIfAbsent(v2, new ArrayList<>());

        adjList.get(v1).add(v2);
        adjList.get(v2).add(v1); // Since it's an undirected graph
    }

    public void printGraph() {
        for (int node : adjList.keySet()) {
            System.out.println(node + " -> " + adjList.get(node));
        }
    }

    public static void main(String[] args) {
        CompleteGraph g = new CompleteGraph();

        // Add nodes (vertices)
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);

        // Add edges (connections)
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);

        g.printGraph();
    }
}

