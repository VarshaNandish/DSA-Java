/*
Given the number of vertices V and a list of directed edges, determine whether the graph contains a cycle or not.
Examples:
    Input:  V = 4, edges[][] = [[0, 1], [0, 2], [1, 2], [2, 0], [2, 3]]
    Cycle: 0 → 2 → 0
    Output:  true
    Input: V = 4, edges[][] = [[0, 1], [0, 2], [1, 2], [2, 3]
    No Cycle
    Output:  false
Kahn’s Algorithm (BFS-based) — Detect Cycle in Directed Graph
Idea
A Directed Acyclic Graph (DAG) always has at least one vertex with in-degree 0.
If we repeatedly remove such vertices (like in Topological Sort) and still process all vertices, there’s no cycle.
If some vertices remain (couldn’t be processed because their in-degree never became 0), there’s a cycle.
Algorithm
1. Build adjacency list and calculate in-degree of each vertex.
2. Add all vertices with in-degree 0 to a queue.
3. While queue not empty:
Remove a vertex from queue, increment count of processed vertices.
For each neighbor:
Reduce its in-degree by 1.
If in-degree becomes 0 → add to queue.
4. After loop:
If count == V → no cycle (processed all vertices).
Else → cycle exists.
Time Complexity
Building adjacency list + in-degree array: O(V + E)
BFS traversal: O(V + E) (each vertex/edge processed once)
Total: O(V + E)
Space Complexity
Adjacency list: O(V + E)
In-degree array: O(V)
Queue: O(V)
Total: O(V + E)
*/
import java.util.*;

public class DirectedGraphCycleKahn {

    public static boolean hasCycle(int V, int[][] edges) {
        // Step 1: Build adjacency list & indegree array
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[V];

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++; // count incoming edges
        }

        // Step 2: Add all vertices with indegree 0 to queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Step 3: Process nodes
        int count = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++; // processed this node

            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--; // remove edge
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Step 4: If not all vertices processed → cycle exists
        return count != V;
    }

    public static void main(String[] args) {
        int V1 = 4;
        int[][] edges1 = { {0, 1}, {0, 2}, {1, 2}, {2, 0}, {2, 3} };
        System.out.println(hasCycle(V1, edges1)); // true

        int V2 = 4;
        int[][] edges2 = { {0, 1}, {0, 2}, {1, 2}, {2, 3} };
        System.out.println(hasCycle(V2, edges2)); // false
    }
}