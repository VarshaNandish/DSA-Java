/*
Given a graph with V vertices numbered from 0 to V-1 and a list of edges, determine whether the graph is bipartite or not.
Note: A bipartite graph is a type of graph where the set of vertices can be divided into two disjoint sets, say U and V, such that every edge connects a vertex in U to a vertex in V, there are no edges between vertices within the same set.
Example:
    Input: V = 4, edges[][]= [[0, 1], [0, 2], [1, 2], [2, 3]]
    Output: false
    Explanation: The graph is not bipartite because no matter how we try to color the nodes using two   colors, there exists a cycle of odd length (like 1–2–0–1), which leads to a situation where two adjacent nodes end up with the same color. This violates the bipartite condition, which requires that no two connected nodes share the same color.
    Input: V = 4, edges[][] = [[0, 1], [1, 2], [2, 3]]
    Output: true
    Explanation: The given graph can be colored in two colors so, it is a bipartite graph.

We are given a graph with V vertices and edges. We need to check whether it is Bipartite.
A graph is Bipartite if we can color its vertices using two colors (say Red & Blue) such that no two adjacent vertices have the same color.
BFS / DFS Coloring (Optimal)
Treat this as a graph coloring problem.
Use BFS (or DFS) to traverse the graph.
Assign alternate colors (0 and 1) to neighbors.
If at any point a neighbor already has the same color → Not bipartite.
Time Complexity: O(V + E)
Space Complexity: O(V) (color array + queue/stack)
Algorithm (BFS coloring)
1. Initialize a color[] array of size V with -1 (meaning uncolored).
2. For each unvisited node:
Assign it a color (0).
Perform BFS:
For each neighbor:
If not colored → assign opposite color.
If already colored with same color → return false.
3. If traversal completes without conflict → return true.
*/
import java.util.*;

public class BipartiteGraph {
    public static boolean isBipartite(int V, int[][] edges) {
        // Step 1: Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]); // undirected graph
        }

        int[] color = new int[V];
        Arrays.fill(color, -1); // uncolored

        // Step 2: Check all components (graph may be disconnected)
        for (int start = 0; start < V; start++) {
            if (color[start] == -1) {
                if (!bfsCheck(start, adj, color)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean bfsCheck(int src, List<List<Integer>> adj, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        color[src] = 0; // start with color 0

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int neighbor : adj.get(node)) {
                if (color[neighbor] == -1) {
                    // assign opposite color
                    color[neighbor] = 1 - color[node];
                    q.add(neighbor);
                } else if (color[neighbor] == color[node]) {
                    // conflict found
                    return false;
                }
            }
        }
        return true;
    }

    // Driver
    public static void main(String[] args) {
        int V1 = 4;
        int[][] edges1 = {{0,1}, {0,2}, {1,2}, {2,3}};
        System.out.println(isBipartite(V1, edges1)); // false

        int V2 = 4;
        int[][] edges2 = {{0,1}, {1,2}, {2,3}};
        System.out.println(isBipartite(V2, edges2)); // true
    }
}