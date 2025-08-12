/*

Given two strings s and p, the task is to find the smallest substring in s that contains all characters of p, including duplicates.
If no such substring exists, return "". If multiple substrings of the same length are found, return the one with the smallest starting index.

Examples:

    Input: s = "timetopractice", p = "toc"
    Output: toprac
    Explanation: "toprac" is the smallest substring in which "toc" can be found.

    Input: s = "zoomlazapzo", p = "oza"
    Output: apzo
    Explanation: "apzo" is the smallest substring in which "oza" can be found.
    
 */

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {
    public static String minWindow(String s, String p) {
        if (s.length() == 0 || p.length() == 0) return "";

        // Step 1: Frequency map for p
        Map<Character, Integer> need = new HashMap<>();
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int needCount = p.length();
        int haveCount = 0;
        Map<Character, Integer> have = new HashMap<>();

        int left = 0, minLen = Integer.MAX_VALUE, minStart = 0;

        // Step 2: Sliding window
        for (int right = 0; right < s.length(); right++) {
            char rc = s.charAt(right);
            have.put(rc, have.getOrDefault(rc, 0) + 1);

            // If this char is in need and still needed, increment haveCount
            if (need.containsKey(rc) && have.get(rc) <= need.get(rc)) {
                haveCount++;
            }

            // Step 3: Try shrinking
            while (haveCount == needCount) {
                int windowLen = right - left + 1;
                if (windowLen < minLen) {
                    minLen = windowLen;
                    minStart = left;
                }

                char lc = s.charAt(left);
                have.put(lc, have.get(lc) - 1);
                if (need.containsKey(lc) && have.get(lc) < need.get(lc)) {
                    haveCount--;
                }
                left++;
            }
        }

        return (minLen == Integer.MAX_VALUE) ? "" : s.substring(minStart, minStart + minLen);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("timetopractice", "toc")); // Output: toprac
        System.out.println(minWindow("zoomlazapzo", "oza"));   // Output: apzo
    }
}
