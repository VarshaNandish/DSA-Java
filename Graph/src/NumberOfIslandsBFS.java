/*
Given an n x m grid of 'W' (Water) and 'L' (Land), the task is to count the number of islands. An island is a group of adjacent 'L' cells connected horizontally, vertically, or diagonally, and it is surrounded by water or the grid boundary. The goal is to determine how many distinct islands exist in the grid.

Examples:

    Input: grid[][] = [['L', 'L', 'W', 'W', 'W'],
                                ['W', 'L', 'W', 'W', 'L'],
                              ['L', 'W', 'W', 'L', 'L'],
                             ['W', 'W', 'W', 'W', 'W'],
                            ['L', 'W', 'L', 'L', 'W']]
    Output: 4
    Input: grid[][] = [['W', 'L', 'L', 'L', 'W', 'W', 'W'],
                                ['W', 'W', 'L', 'L', 'W', 'L', 'W']]
    Output: 2
    Input: grid[][] = [['W,' 'W'],
                             ['W', 'W']]
    Output: 0
    All elements are 0, hence no islands.
You’re given an n × m grid of 'L' (land) and 'W' (water).
An island is a connected group of 'L' cells where connectivity is allowed in 8 directions.
You need to count the number of distinct islands.
Approach
We can solve this using:
BFS (queue-based traversal) or
DFS (recursive or iterative stack-based traversal).
We’ll do BFS here:
1. Loop through each cell.
2. If it’s 'L' and not visited yet, it’s the start of a new island.
3. Run BFS to mark all connected 'L' cells as visited.
4. Increase island count by 1.
5. Continue until all cells are processed.
Algorithm (BFS)
1. Initialize visited[n][m] as false.
2. For each cell (i, j):
If grid[i][j] == 'L' and not visited:
Run BFS starting at (i, j).
BFS:
Use a queue.
Push (i, j) into queue and mark visited.
For each cell in queue, explore 8 directions.
If neighbor is 'L' and not visited, mark and push into queue.
Increment count.
3. Return count.
Time & Space Complexity
Time Complexity:
Every cell is visited once ⇒ O(n × m).
Space Complexity:
visited array + queue in worst case ⇒ O(n × m).
*/
import java.util.*;

public class NumberOfIslandsBFS {

    static int countIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0;

        // 8 directions: up, down, left, right, and diagonals
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'L' && !visited[i][j]) {
                    bfs(grid, visited, i, j, dx, dy);
                    count++;
                }
            }
        }
        return count;
    }

    static void bfs(char[][] grid, boolean[][] visited, int startX, int startY, int[] dx, int[] dy) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];

            // Explore all 8 directions
            for (int dir = 0; dir < 8; dir++) {
                int newX = x + dx[dir];
                int newY = y + dy[dir];

                if (isValid(newX, newY, n, m) &&
                        grid[newX][newY] == 'L' &&
                        !visited[newX][newY]) {

                    visited[newX][newY] = true;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
    }

    static boolean isValid(int x, int y, int n, int m) {
        return (x >= 0 && x < n && y >= 0 && y < m);
    }

    // Example usage
    public static void main(String[] args) {
        char[][] grid1 = {
                {'L', 'L', 'W', 'W', 'W'},
                {'W', 'L', 'W', 'W', 'L'},
                {'L', 'W', 'W', 'L', 'L'},
                {'W', 'W', 'W', 'W', 'W'},
                {'L', 'W', 'L', 'L', 'W'}
        };

        System.out.println(countIslands(grid1)); // Output: 4

        char[][] grid2 = {
                {'W', 'L', 'L', 'L', 'W', 'W', 'W'},
                {'W', 'W', 'L', 'L', 'W', 'L', 'W'}
        };
        System.out.println(countIslands(grid2)); // Output: 2

        char[][] grid3 = {
                {'W', 'W'},
                {'W', 'W'}
        };
        System.out.println(countIslands(grid3)); // Output: 0
    }
}
