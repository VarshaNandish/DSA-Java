/*
You are given n identical eggs and you have access to a k-floored building from 1 to k.
There exists a floor f where 0 <= f <= k such that any egg dropped from a floor higher than f will break, and any egg dropped from or below floor f will not break. There are a few rules given below:
    An egg that survives a fall can be used again.
    A broken egg must be discarded.
    The effect of a fall is the same for all eggs.
    If the egg doesn't break at a certain floor, it will not break at any floor below.
    If the egg breaks on a certain floor, it will break on any floor above.
Your task is to find the minimum number of moves you need to determine the value of f with certainty.
Example:
   Input: n = 2, k = 36
    Output: 8
    Explanation: In all the situations, 8 maximum moves are required to find the maximum floor. Following is the strategy to do so:
        Drop from floor 8 → If breaks, check 1-7 sequentially.
        Drop from floor 15 → If breaks, check 9-14.
        Drop from floor 21  → If breaks, check 16-20.
        Drop from floor 26 → If breaks, check 22-25.
        Drop from floor 30 → If breaks, check 27-29.
        Drop from floor 33 → If breaks, check 31-32.
        Drop from floor 35 → If breaks, check 34.
        Drop from floor 36 → Final check.
    Input: n = 1, k = 36
    Output: 36
    Explanation: Drop the egg from the first-floor window; if it survives, drop it from the second-floor window. Continue upward until it breaks. In the worst case, this method may require 36 droppings.
    Input: n = 2, k = 10
    Output: 4
    Explanation: In all the situations, 4 maximum moves are required to find the maximum floor. Following is the strategy to do so:

        Drop from floor 4 → If breaks, check 1-3 sequentially.
        Drop from floor 7 → If breaks, check 5-6.
        Drop from floor 9 → If breaks, check 8.
        Drop from floor 10 → Final check.
We need to find the minimum number of attempts (moves) required to determine the critical floor f in the worst case, given:
n = number of eggs
k = number of floors
*/
public class EggDropping {

    // Function to return minimum number of moves required
    public static int eggDrop(int eggs, int floors) {
        // dp[e][m] = maximum floors that can be tested with e eggs and m moves
        int[][] dp = new int[eggs + 1][floors + 1];

        int moves = 0;

        // keep increasing moves until we can test at least 'floors' floors
        while (dp[eggs][moves] < floors) {
            moves++;

            for (int e = 1; e <= eggs; e++) {
                dp[e][moves] = 1 + dp[e - 1][moves - 1] + dp[e][moves - 1];
            }
        }

        return moves;
    }

    // Driver code
    public static void main(String[] args) {
        int eggs = 2;
        int floors = 36;

        System.out.println("Minimum number of moves = " + eggDrop(eggs, floors));
    }
}