/*
Given an undirected Graph, The task is to find the Bridges in this Graph.

    An edge in an undirected connected graph is a bridge if removing it disconnects the graph. For a disconnected undirected graph, the definition is similar, a bridge is an edge removal that increases the number of disconnected components.
Optimal Approach (Tarjan’s Algorithm using DFS)
Idea
Use DFS discovery times and low-link values.
For each node:
disc[u]: Time when vertex u is first discovered.
low[u]: Earliest visited vertex reachable from u (via back edges).
An edge (u, v) is a bridge if:
low[v] > disc[u]
→ Meaning v (and its subtree) cannot reach back to u or its ancestors without using edge (u, v).
Algorithm
1. Initialize:
disc[] = -1, low[] = -1, visited[] = false
time = 0
2. For each unvisited vertex u:
Run DFS(u, parent=-1).
On visiting u:
Set disc[u] = low[u] = ++time
For each neighbor v:
If not visited → recurse DFS(v, u), update low[u] = min(low[u], low[v]).
If low[v] > disc[u] → edge (u,v) is a bridge.
Else if v != parent → update low[u] = min(low[u], disc[v]).
3. Collect bridges.
Time Complexity
DFS runs once → O(V + E)
Updating low-link values is constant work per edge.
Space Complexity
O(V + E) for adjacency list
O(V) for disc[], low[], visited[], recursion stack.
*/
import java.util.*;

public class BridgeFinder {

    static class Graph {
        int V;
        List<List<Integer>> adj;

        Graph(int V) {
            this.V = V;
            adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
        }

        void addEdge(int u, int v) {
            adj.get(u).add(v);
            adj.get(v).add(u); // undirected graph
        }
    }

    private static int time = 0; // global timer

    public static List<int[]> findBridges(Graph g) {
        int V = g.V;
        boolean[] visited = new boolean[V];
        int[] disc = new int[V]; // discovery times
        int[] low = new int[V];  // low-link values
        List<int[]> bridges = new ArrayList<>();

        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);

        // Run DFS for all components
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, -1, visited, disc, low, g.adj, bridges);
            }
        }
        return bridges;
    }

    private static void dfs(int u, int parent, boolean[] visited, int[] disc, int[] low,
                            List<List<Integer>> adj, List<int[]> bridges) {
        visited[u] = true;
        disc[u] = low[u] = ++time;

        for (int v : adj.get(u)) {
            if (v == parent) continue; // skip edge to parent
            if (!visited[v]) {
                dfs(v, u, visited, disc, low, adj, bridges);
                low[u] = Math.min(low[u], low[v]);

                // Check bridge condition
                if (low[v] > disc[u]) {
                    bridges.add(new int[]{u, v});
                }
            } else {
                // Back edge
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    // Driver
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(3, 4);

        List<int[]> bridges = findBridges(g);
        for (int[] bridge : bridges) {
            System.out.println(bridge[0] + " - " + bridge[1]);
        }
        // Expected Output: 3 - 4 and 1 - 3 are bridges
    }
}
