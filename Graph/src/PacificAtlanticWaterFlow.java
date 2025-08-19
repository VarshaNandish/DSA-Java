/*
There is an N x M rectangular island that borders both the Pacific Ocean and the Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.

The island is partitioned into a grid of square cells. The island receives a lot of rain, and the rainwater can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.

Given a matrix mat[][] having N rows and M columns where mat[x][y] represents the height above sea level of the cell at coordinate (x, y), the task is to find the number of coordinates (x, y) such that the rainwater can flow from the cell (x, y) to both the Pacific and Atlantic oceans.

Example:
    Input: mat[][] = {{1, 2, 2, 3, 5},
                                     {3, 2, 3, 4, 4},
                                     {2, 4, 5, 3, 1},
                                     {6, 7, 1, 4, 5},
                                     {5, 1, 1, 2, 4}}
 Output: 7
    Explanation: In the given matrix, there are 7 coordinates through which the water can flow to both the lakes. They are  (0, 4), (1, 3), (1, 4), (2, 2), (3, 0), (3, 1), and (4, 0)

Input: mat[][] = {{2, 2},
                              {2, 2}}
    Output: 4
    Example: In the following example, all cells allow water to flow to both the lakes.
Problem Summary
We have a grid mat of heights.
Water can flow from a cell to another cell if:
They are adjacent (up, down, left, right).
The neighbor’s height is less than or equal to the current cell’s height.
Pacific touches top row & left column.
Atlantic touches bottom row & right column.
We need to find all coordinates (x, y) where water can flow to both oceans.
Optimal Approach — Reverse Thinking
Instead of starting from each cell:
Start from the oceans and move in reverse:
Think "Where can water come from to reach this ocean?"
Steps
1. Pacific search:
Start from top row and left column cells.
DFS/BFS into neighbors where neighborHeight >= currentHeight (reverse of flow condition).
Mark visited cells that can reach Pacific.
2. Atlantic search:
Start from bottom row and right column cells.
Same DFS/BFS rule.
Mark visited cells that can reach Atlantic.
3. Intersection:
A cell is valid if it’s visited in both Pacific and Atlantic sets.
Algorithm (DFS version)
1. Initialize:
pacificReachable[N][M] = false
atlanticReachable[N][M] = false
2. For each cell touching Pacific, call DFS with Pacific’s visited matrix.
3. For each cell touching Atlantic, call DFS with Atlantic’s visited matrix.
4. Scan all cells → if pacificReachable[i][j] && atlanticReachable[i][j] → count.
Time & Space Complexity
Time: O(N×M) — each cell visited at most twice (once for each ocean).
Space: O(N×M) — visited matrices + recursion stack.
*/
import java.util.*;

public class PacificAtlanticWaterFlow {
    int N, M;
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] mat) {
        N = mat.length;
        M = mat[0].length;

        boolean[][] pacific = new boolean[N][M];
        boolean[][] atlantic = new boolean[N][M];

        // Pacific (top row + left col)
        for (int i = 0; i < N; i++) dfs(mat, pacific, i, 0, Integer.MIN_VALUE);
        for (int j = 0; j < M; j++) dfs(mat, pacific, 0, j, Integer.MIN_VALUE);

        // Atlantic (bottom row + right col)
        for (int i = 0; i < N; i++) dfs(mat, atlantic, i, M-1, Integer.MIN_VALUE);
        for (int j = 0; j < M; j++) dfs(mat, atlantic, N-1, j, Integer.MIN_VALUE);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private void dfs(int[][] mat, boolean[][] visited, int r, int c, int prevHeight) {
        if (r < 0 || c < 0 || r >= N || c >= M) return;
        if (visited[r][c]) return;
        if (mat[r][c] < prevHeight) return;

        visited[r][c] = true;

        for (int[] d : directions) {
            dfs(mat, visited, r + d[0], c + d[1], mat[r][c]);
        }
    }

    public static void main(String[] args) {
        PacificAtlanticWaterFlow obj = new PacificAtlanticWaterFlow();
        int[][] mat = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        System.out.println(obj.pacificAtlantic(mat));
    }
}
