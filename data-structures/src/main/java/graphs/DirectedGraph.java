package graphs;

import java.util.*;

class DirectedGraph {
    private Map<Integer, List<Integer>> adjList;

    public DirectedGraph() {
        adjList = new HashMap<>();
    }

    // Add a node (vertex)
    public void addVertex(int v) {
        adjList.putIfAbsent(v, new ArrayList<>());
    }

    // Add a directed edge from vertex v1 to vertex v2
    public void addEdge(int v1, int v2) {
        adjList.putIfAbsent(v1, new ArrayList<>());
        adjList.putIfAbsent(v2, new ArrayList<>());

        adjList.get(v1).add(v2);
    }

    public void printGraph() {
        for (int node : adjList.keySet()) {
            System.out.print(node + " -> ");
            List<Integer> edges = adjList.get(node);
            System.out.println(edges);
        }
    }

    public static void main(String[] args) {
        DirectedGraph g = new DirectedGraph();

        // Add nodes (vertices)
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        g.addVertex(5);
        g.addVertex(6);

        // Add directed edges
        g.addEdge(1, 2);
        g.addEdge(1, 5);
        g.addEdge(2, 1);
        g.addEdge(2, 4);
        g.addEdge(5, 4);
        g.addEdge(5, 6);
        g.addEdge(6, 1);
        g.addEdge(6, 3);

        g.printGraph();
    }
}

