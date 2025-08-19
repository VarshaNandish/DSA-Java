/*
Given a connected undirected graph represented by adjacency list, adjList[][] with n nodes and m edges, with each node having a distinct label from 0 to n-1, and each adj[i] represents the list of vertices connected to vertex i.

Create a clone of the graph, where each node in the graph contains an integer val and an array (neighbors) of nodes, containing nodes that are adjacent to the current node.

    class Node {
        val: integer
        neighbors: List[Node]
    }


Your task is to clone the given graph and return a reference to the cloned graph.

Note: If you return a correct copy of the given graph, the output will be true; otherwise, if the copy is incorrect, it will print false.

Examples

    Input: n = 4, adjList[][] = [[1, 2], [0, 2], [0, 1, 3], [2]]
    Output: true
    Explanation:
    Since the cloned graph is identical to the original, the output will be true.

    Input: n = 3, adjList[][] = [[1, 2], [0], [0]]
    Output: true
    Explanation:
    Since the cloned graph is identical to the original, the output will be true.

*/

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }

    public Node(int val, List<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}

public class CloneGraphDFS {
    private Map<Node, Node> cloneMap = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        // If already cloned, return clone
        if (cloneMap.containsKey(node)) {
            return cloneMap.get(node);
        }

        // Create clone of the current node
        Node cloneNode = new Node(node.val);
        cloneMap.put(node, cloneNode);

        // Clone all neighbors
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }

        return cloneNode;
    }

    // Helper: Build graph from adjacency list
    public static Node buildGraph(int[][] adjList) {
        if (adjList.length == 0) return null;
        Node[] nodes = new Node[adjList.length];
        for (int i = 0; i < adjList.length; i++) {
            nodes[i] = new Node(i);
        }
        for (int i = 0; i < adjList.length; i++) {
            for (int neighbor : adjList[i]) {
                nodes[i].neighbors.add(nodes[neighbor]);
            }
        }
        return nodes[0]; // Return starting node
    }

    public static void main(String[] args) {
        int[][] adjList1 = {{1, 2}, {0, 2}, {0, 1, 3}, {2}};
        int[][] adjList2 = {{1, 2}, {0}, {0}};

        CloneGraphDFS solver = new CloneGraphDFS();

        Node graph1 = buildGraph(adjList1);
        Node clone1 = solver.cloneGraph(graph1);
        System.out.println(verify(graph1, clone1)); // true

        Node graph2 = buildGraph(adjList2);
        Node clone2 = solver.cloneGraph(graph2);
        System.out.println(verify(graph2, clone2)); // true
    }

    // Verification: Checks if two graphs are identical but independent
    public static boolean verify(Node original, Node clone) {
        Map<Node, Node> visited = new HashMap<>();
        return dfsVerify(original, clone, visited);
    }

    private static boolean dfsVerify(Node o, Node c, Map<Node, Node> visited) {
        if (o == c) return false; // Should not be same reference
        if (o.val != c.val) return false;
        visited.put(o, c);
        if (o.neighbors.size() != c.neighbors.size()) return false;
        for (int i = 0; i < o.neighbors.size(); i++) {
            Node on = o.neighbors.get(i);
            Node cn = c.neighbors.get(i);
            if (visited.containsKey(on)) {
                if (visited.get(on) != cn) return false;
            } else {
                if (!dfsVerify(on, cn, visited)) return false;
            }
        }
        return true;
    }
}

