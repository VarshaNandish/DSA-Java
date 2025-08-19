/*
Given n dices each with m faces, numbered from 1 to m, the task is to find the number of ways to get sum x. x is the summation of values on each face when all the dice are thrown.
Examples:
    Input: m = 6, n = 3, x = 12
    Output: 25
    Explanation: There are 25 total ways to get the Sum 12 using 3 dices with faces from 1 to 6.

    Input: m = 2, n = 3, x = 6
    Output: 1
    Explanation: There is only 1 way to get the Sum 6 using 3 dices with faces from 1 to 2. All the dices will have to land on 2.
*/
import java.util.*;

public class DiceSumWays1D {
    public static long countWays(int m, int n, int x) {
        if (n <= 0 || m <= 0 || x < 0) return 0;
        if (x < n || x > n * m) return 0;

        long[] prev = new long[x + 1];
        prev[0] = 1;

        for (int d = 1; d <= n; d++) {
            long[] curr = new long[x + 1];
            int sMin = d;
            int sMax = Math.min(x, d * m);
            for (int s = sMin; s <= sMax; s++) {
                long ways = 0;
                for (int f = 1; f <= m && f <= s; f++) {
                    ways += prev[s - f];
                }
                curr[s] = ways;
            }
            prev = curr; // roll
        }
        return prev[x];
    }

    public static void main(String[] args) {
        System.out.println(countWays(6, 3, 12)); // 25
        System.out.println(countWays(2, 3, 6));  // 1
    }
}
