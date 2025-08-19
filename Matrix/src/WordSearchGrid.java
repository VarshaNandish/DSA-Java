/*
Given a 2D grid m*n of characters and a word, the task is to find all occurrences of the given word in the grid. A word can be matched in all 8 directions at any point. Word is said to be found in a direction if all characters match in this direction (not in zig-zag form).
The 8 directions are, Horizontally Left, Horizontally Right, Vertically Up, Vertically Down and 4 Diagonal directions.
Note: The returning list should be lexicographically smallest. If the word can be found in multiple directions starting from the same coordinates, the list should contain the coordinates only once.
Examples:
    Input:
    grid = {{G,E,E,K,S,F,O,R,G,E,E,K,S}, {G,E,E,K,S,Q,U,I,Z,G,E,E,K}, {I,D,E,Q,A,P,R,A,C,T,I,C,E}}
    word = "GEEKS"
    Output: {{0,0}, {0,8}, {1,0}}
    Input:
    grid = {{a,b,a,b},{a,b,e,b},{e,b,e,b}}
    word = "abe"
    Output:
    {{0,0},{0,2},{1,0}}
*/
import java.util.*;

public class WordSearchGrid {
    // Directions: 8 possible moves
    static int[] dx = {-1,-1,-1,0,0,1,1,1};
    static int[] dy = {-1,0,1,-1,1,-1,0,1};

    // Check if word starts at (x, y) in direction d
    static boolean searchDir(char[][] grid, int x, int y, String word, int dir) {
        int m = grid.length, n = grid[0].length;
        int len = word.length();

        for (int k = 0; k < len; k++) {
            int newX = x + k * dx[dir];
            int newY = y + k * dy[dir];

            // Boundary check
            if (newX < 0 || newX >= m || newY < 0 || newY >= n)
                return false;

            if (grid[newX][newY] != word.charAt(k))
                return false;
        }
        return true;
    }

    // Main function to find word in grid
    static List<int[]> findWord(char[][] grid, String word) {
        int m = grid.length, n = grid[0].length;
        Set<String> seen = new HashSet<>();
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If first character matches, check all directions
                if (grid[i][j] == word.charAt(0)) {
                    boolean found = false;
                    for (int d = 0; d < 8; d++) {
                        if (searchDir(grid, i, j, word, d)) {
                            found = true;
                            break;
                        }
                    }
                    if (found) {
                        String key = i + "," + j;
                        if (!seen.contains(key)) {
                            seen.add(key);
                            result.add(new int[]{i, j});
                        }
                    }
                }
            }
        }

        // Sort lexicographically
        result.sort((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        return result;
    }

    // Driver code
    public static void main(String[] args) {
        char[][] grid1 = {
                {'G','E','E','K','S','F','O','R','G','E','E','K','S'},
                {'G','E','E','K','S','Q','U','I','Z','G','E','E','K'},
                {'I','D','E','Q','A','P','R','A','C','T','I','C','E'}
        };
        String word1 = "GEEKS";
        List<int[]> ans1 = findWord(grid1, word1);
        for (int[] p : ans1) System.out.println(Arrays.toString(p));

        char[][] grid2 = {
                {'a','b','a','b'},
                {'a','b','e','b'},
                {'e','b','e','b'}
        };
        String word2 = "abe";
        List<int[]> ans2 = findWord(grid2, word2);
        for (int[] p : ans2) System.out.println(Arrays.toString(p));
    }
}