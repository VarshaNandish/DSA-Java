/*
Given a string s and y a dictionary of n words dictionary, check if s can be segmented into a sequence of valid words from the dictionary, separated by spaces.

Examples:

Input:  s = "ilike", dictionary[] = ["i", "like", "gfg"]
Output: true
Explanation: The string can be segmented as "i like".

Input:  s = "ilikegfg", dictionary[] = ["i", "like", "man", "india", "gfg"]
Output: true
Explanation: The string can be segmented as "i like gfg".

Input: "ilikemangoes", dictionary = ["i", "like", "gfg"]
Output: false
Explanation: The string cannot be segmented.

Approach: Dynamic Programming (Tabulation)
Key Idea:
We use a boolean DP array dp[], where dp[i] is true if the substring s[0..i-1] can be segmented into valid dictionary words.

Steps:
Initialize a boolean array dp of size s.length() + 1, set dp[0] = true (empty string is always segmentable).

For every index i from 1 to s.length():
For every j from 0 to i:
If dp[j] == true and s.substring(j, i) is in dictionary, set dp[i] = true.

Finally, return dp[s.length()].

Dry Run:

s = "ilikegfg"
dict = {"i", "like", "gfg"}

dp = [T, F, F, F, F, F, F, F, F, F]

Check all substrings:
"i" → in dict → dp[1] = T
"like" → dp[1]=T && "like" in dict → dp[5] = T
"gfg" → dp[5]=T && "gfg" in dict → dp[8] = T

Final dp = [T, T, F, F, F, T, F, F, T]
dp[8] = T → return true 
 */

import java.util.*;

public class WordBreak {

    public static boolean wordBreak(String s, Set<String> dict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // base case

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // no need to check further
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Set<String> dict = new HashSet<>(Arrays.asList("i", "like", "gfg", "man", "mango", "goes", "mangoes"));

        String s1 = "ilike";
        String s2 = "ilikegfg";
        String s3 = "ilikemangoes";

        System.out.println(wordBreak(s1, dict)); // true
        System.out.println(wordBreak(s2, dict)); // true
        System.out.println(wordBreak(s3, dict)); // false
    }
}
