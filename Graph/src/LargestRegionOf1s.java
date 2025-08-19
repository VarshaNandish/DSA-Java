/*
Given a binary 2D matrix, find area of the largest region of 1s which are connected horizontally, vertically or diagonally.
Examples:
    Input: M[][]= {{1, 0, 0, 0, 1, 0, 0},
                             {0, 1, 0, 0, 1, 1, 0},
                             {1, 1, 0, 0, 0, 0, 0},
                             {1, 0, 0, 1, 1, 0, 0},
                             {1, 0, 0, 1, 0, 1, 1}}
    Output: 6
    Explanation: The region in red has the largest area of 6 cells.
*/
import java.util.*;

public class LargestRegionOf1s {

    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1}; // 8 directions
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static int largestRegion(int[][] M) {
        int n = M.length, m = M[0].length;
        boolean[][] visited = new boolean[n][m];
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (M[i][j] == 1 && !visited[i][j]) {
                    int area = dfs(M, visited, i, j, n, m);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private static int dfs(int[][] M, boolean[][] visited, int x, int y, int n, int m) {
        visited[x][y] = true;
        int area = 1; // current cell

        for (int k = 0; k < 8; k++) {
            int newX = x + dx[k];
            int newY = y + dy[k];

            if (isValid(newX, newY, n, m) && M[newX][newY] == 1 && !visited[newX][newY]) {
                area += dfs(M, visited, newX, newY, n, m);
            }
        }
        return area;
    }

    private static boolean isValid(int x, int y, int n, int m) {
        return (x >= 0 && y >= 0 && x < n && y < m);
    }

    public static void main(String[] args) {
        int[][] M = {
                {1, 0, 0, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0},
                {1, 1, 0, 0, 0, 0, 0},
                {1, 0, 0, 1, 1, 0, 0},
                {1, 0, 0, 1, 0, 1, 1}
        };

        System.out.println("Largest region size: " + largestRegion(M));
    }
}