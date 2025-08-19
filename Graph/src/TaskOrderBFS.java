/*
There are a total of n tasks you have to pick, labelled from 0 to n-1. Some tasks may have prerequisites[][] tasks, for example to pick task 0 you have to first finish tasks 1, which is expressed as a pair: [0, 1]
Given the total number of n tasks and a list of prerequisite pairs of size m. Find a ordering of tasks you should pick to finish all tasks.
Note: There may be multiple correct orders, you just need to return any one of them. If it is impossible to finish all tasks, return an empty array. Returning any correct order will give the output as true, whereas any invalid order will give the output false.

Examples:

Input: n = 2, prerequisites[][] = [[1, 0]]
Output: true
Explanation: Only possible order is [0, 1].

Input: n = 4, prerequisites[][] = [[1, 0], [2, 0], [3, 1], [3, 2]]
Output: true
Explanation: There are a total of 4 tasks to pick. To pick task 3 you should have finished both tasks 1 and 2. Both tasks 1 and 2 should be pick after you finished task 0. So one correct task order is [0, 1, 2, 3]. Another correct ordering is [0, 2, 1, 3]. Returning any of these order will result in an output of true.
BFS (Kahn’s Algorithm)
Idea:
Convert prerequisites into a directed graph (adjacency list).
Compute in-degree for each node (number of prerequisites).
Start with nodes having in-degree = 0 (no prerequisites).
Process them, reducing in-degree of their neighbors.
If a neighbor’s in-degree becomes 0, push it to the queue.
If we process all nodes → valid ordering; else → cycle exists.
Algorithm
1. Build adjacency list graph from prerequisites.
2. Build inDegree[] array counting prerequisites for each task.
3. Initialize queue with all tasks having inDegree == 0.
4. While queue not empty:
Remove task u from queue.
Add u to order list.
For each neighbor v of u:
Decrease inDegree[v] by 1.
If inDegree[v] == 0, push to queue.
5. If order.size() == n, return order; else return empty array.
Time Complexity: O(n + m)
n = number of tasks, m = number of prerequisites
Build graph: O(m)
BFS traversal: O(n + m)
Space Complexity: O(n + m)
Adjacency list + queue + inDegree array.


*/
import java.util.*;

public class TaskOrderBFS {
    public static int[] findOrder(int n, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        int[] inDegree = new int[n];

        // Build graph & inDegree array
        for (int[] pre : prerequisites) {
            int task = pre[0];
            int prereq = pre[1];
            graph.get(prereq).add(task);
            inDegree[task]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        int[] order = new int[n];
        int idx = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            order[idx++] = curr;

            for (int neighbor : graph.get(curr)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) queue.offer(neighbor);
            }
        }

        // If cycle detected
        if (idx != n) return new int[0];

        return order;
    }

    public static void main(String[] args) {
        int n1 = 2;
        int[][] prereq1 = {{1, 0}};
        System.out.println(Arrays.toString(findOrder(n1, prereq1)));

        int n2 = 4;
        int[][] prereq2 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(Arrays.toString(findOrder(n2, prereq2)));
    }
}

