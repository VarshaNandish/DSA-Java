/*
Given a snake and ladder board, find the minimum number of dice throws required to reach the destination or last cell from the source or 1st cell. Basically, the player has total control over the outcome of the dice throw and wants to find out the minimum number of throws required to reach the last cell.
If the player reaches a cell which is the base of a ladder, the player has to climb up that ladder and if reaches a cell is the mouth of the snake, and has to go down to the tail of the snake without a dice throw.

We are given:
A board with snakes and ladders.
Player starts from cell 1 and wants to reach cell N (last cell).
If player lands on:
Ladder base → climb up to ladder end.
Snake mouth → go down to snake tail.
Player can choose dice outcome (1–6) optimally.
Find minimum number of dice throws to reach the last cell.
Approach
Idea
This is essentially shortest path in an unweighted graph:
Each cell is a vertex.
Edges connect a cell to the next 1 to 6 cells (dice outcomes).
Ladders and snakes act as instant teleports to another cell.
Shortest path in an unweighted graph → BFS is optimal.
Algorithm
1. Represent the board as an array moves[] of size N:
moves[i] = -1 means no snake/ladder from cell i.
moves[i] = j means there’s a ladder/snake from i to j.
2. Use BFS:
Start from cell 1 (index 0 in array).
For each position, try dice rolls 1–6.
If landing position has ladder/snake, move directly to that cell.
Track visited cells to avoid loops.
3. The BFS level count gives the minimum dice throws.
Time Complexity
O(N) because each cell is processed at most once in BFS.
*/
import java.util.*;

/**
 * Snake and Ladder - corrected BFS implementation
 * Marks visited[dest] = true (destination after snake/ladder) to avoid duplicates.
 */
public class SnakeAndLadderCorrected {

    // Simple container to store queue entries: board index and distance (dice throws)
    static class Cell {
        int vertex; // board index (0-based)
        int dist;   // number of dice throws used to reach this vertex

        Cell(int v, int d) {
            vertex = v;
            dist = d;
        }
    }

    /**
     * Returns minimum number of dice throws required to reach cell N-1 (last cell),
     * or -1 if unreachable.
     *
     * @param moves array where moves[i] = destination index if i has ladder/snake, else -1
     * @param N     number of cells on board
     * @return minimum dice throws to reach last cell
     */
    public static int getMinDiceThrows(int[] moves, int N) {
        if (N <= 0) return -1;
        if (N == 1) return 0; // already at destination

        boolean[] visited = new boolean[N];   // visited[i] means we have enqueued/seen index i
        Queue<Cell> queue = new LinkedList<>();

        // Start from cell 0 (board cell 1) with 0 dice throws
        visited[0] = true;
        queue.add(new Cell(0, 0));

        while (!queue.isEmpty()) {
            Cell curr = queue.poll();
            int v = curr.vertex;

            // Try all possible dice throws from current cell: 1..6
            for (int dice = 1; dice <= 6 && v + dice < N; dice++) {
                int next = v + dice;                          // landing square before snake/ladder
                int dest = (moves[next] != -1) ? moves[next] : next; // final destination after snake/ladder

                // If destination not visited yet, mark and enqueue it
                if (!visited[dest]) {
                    visited[dest] = true; // MARK THE DESTINATION visited (correct)
                    // If we've reached the last cell, return the distance immediately
                    if (dest == N - 1) {
                        return curr.dist + 1;
                    }
                    queue.add(new Cell(dest, curr.dist + 1));
                }
            }
        }

        // If BFS completes without reaching last cell, board is unreachable (rare for valid boards)
        return -1;
    }

    public static void main(String[] args) {
        int N = 30;
        int[] moves = new int[N];
        Arrays.fill(moves, -1);

        // Ladders (index -> destination index)
        moves[2]  = 21; // cell 3 -> cell 22
        moves[4]  = 7;  // cell 5 -> cell 8
        moves[10] = 25; // cell 11 -> cell 26
        moves[19] = 28; // cell 20 -> cell 29

        // Snakes (index -> destination index)
        moves[26] = 0;  // cell 27 -> cell 1
        moves[20] = 8;  // cell 21 -> cell 9
        moves[16] = 3;  // cell 17 -> cell 4
        moves[18] = 6;  // cell 19 -> cell 7

        int minThrows = getMinDiceThrows(moves, N);
        if (minThrows >= 0) {
            System.out.println("Min Dice throws required: " + minThrows);
        } else {
            System.out.println("Destination unreachable.");
        }
    }
}

