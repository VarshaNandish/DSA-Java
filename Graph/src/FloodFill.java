/*
You are given a 2D grid image[][], where each image[i][j] represents the color of a pixel in the image. Also provided is a coordinate(sr, sc) representing the starting pixel (row and column) and a new color value newColor.

Your task is to perform a flood fill starting from the pixel (sr, sc), changing its color and the color of all connected pixels that have the same original color. Two pixels are considered connected if they are adjacent horizontally or vertically (not diagonally) and have the same original color.

Example:

    Input: image = [[1, 1, 1, 0], [0, 1, 1, 1], [1, 0, 1, 1]], sr = 1, sc = 2, newColor = 2
    Output: [[2, 2, 2, 0], [0, 2, 2, 2], [1, 0, 2,2]]
    Explanation: Starting from pixel (1, 2) with value 1, flood fill updates all connected pixels (up, down, left, right) with value 1 to 2, resulting in [[2, 2, 2, 0], [0, 2, 2, 2], [1, 0, 2, 2]].

    Input: image = [[0, 1, 0], [0, 1, 0]], sr = 0, sc = 1, newColor = 0
    Output: [[0, 0, 0], [0, 0, 0]]
    Explanation: Starting from pixel (1, 2) with value 1, flood fill updates all connected pixels (up, down, left, right) with value 1 to 0, resulting in [[0, 0, 0], [0, 0, 0]].
Problem Summary
We are given:
A 2D grid (image[][]) representing pixel colors.
A starting pixel (sr, sc).
A newColor.
We must replace the starting pixel’s color and all connected pixels (up, down, left, right only) that have the same original color with the new color.
Approaches
We can solve this problem using either:
1. DFS (Recursive / Stack-based)
2. BFS (Queue-based)
Both are valid, just different traversal strategies.
*/
import java.util.*;
public class FloodFill {
    // Function to perform flood fill
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];

        // If the old color is already same as newColor, nothing to do
        if (oldColor == newColor) return image;

        // Call DFS helper
        dfs(image, sr, sc, oldColor, newColor);
        return image;
    }

    // DFS helper method
    private void dfs(int[][] image, int row, int col, int oldColor, int newColor) {
        int rows = image.length;
        int cols = image[0].length;

        // Boundary + base condition checks
        if (row < 0 || row >= rows || col < 0 || col >= cols) return; // out of bounds
        if (image[row][col] != oldColor) return; // different color, stop

        // Fill current pixel
        image[row][col] = newColor;

        // Recurse in 4 directions
        dfs(image, row + 1, col, oldColor, newColor); // down
        dfs(image, row - 1, col, oldColor, newColor); // up
        dfs(image, row, col + 1, oldColor, newColor); // right
        dfs(image, row, col - 1, oldColor, newColor); // left
    }

    // Driver
    public static void main(String[] args) {
        FloodFill obj = new FloodFill();

        int[][] image = {{1, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};
        int sr = 1, sc = 2, newColor = 2;

        int[][] result = obj.floodFill(image, sr, sc, newColor);

        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}