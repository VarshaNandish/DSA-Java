/*

Graph

Problem: A simple edge list representation of an undirected or directed graph using Java classes.

Plan:

Graph creation using an Edge[] array,
Encapsulation of an inner class Edge,
        A Graph class to manage vertices and edges.


Time & Space Complexity:

Time Complexity:
addEdge() → O(1)
displayEdges() → O(E) where E = totalEdges

Space Complexity:
O(E) for storing edges

*/

// Class to represent a Graph
public class Graph {

    // Inner class to represent an Edge
    static class Edge {

        int src;   // Starting vertex of the edge
        int dest;  // Ending vertex of the edge

        // Constructor
        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    int vertex;       // Total number of vertices
    Edge[] edges;     // Array to store edges
    int edgeCount = 0; // Current number of added edges

    // Constructor to initialize graph with given vertices and edges
    Graph(int vertex, int totalEdges) {
        this.vertex = vertex;
        edges = new Edge[totalEdges]; // Allocate space for edge objects
    }

    // Method to add an edge to the graph
    void addEdge(int src, int dest) {
        if (edgeCount < edges.length) {
            edges[edgeCount++] = new Edge(src, dest);
        } else {
            System.out.println("Cannot add more edges. Limit reached.");
        }
    }

    // Method to display all edges
    void displayEdges() {
        System.out.println("Graph Edges:");
        for (Edge e : edges) {
            if (e != null)
                System.out.println(e.src + " - " + e.dest);
        }
    }

    // Main method
    public static void main(String[] args) {
        int vertex = 5;
        int totalEdges = 8;

        Graph graph = new Graph(vertex, totalEdges);

        // Adding edges using the addEdge method
        graph.addEdge(1, 2);

        graph.addEdge(1, 3);

        graph.addEdge(1, 4);

        graph.addEdge(2, 4);

        graph.addEdge(2, 5);

        graph.addEdge(3, 4);

        graph.addEdge(3, 5);

        graph.addEdge(4, 5);

        // Displaying the edges
        graph.displayEdges();
    }
}
