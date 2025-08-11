/*
Given a string s having lowercase characters, find the length of the longest substring without repeating characters.

Examples:

Input: s = "geeksforgeeks"
Output: 7
Explanation: The longest substrings without repeating characters are "eksforg” and "ksforge", with lengths of 7.

Input: s = "aaa"
Output: 1
Explanation: The longest substring without repeating characters is "a"

Input: s = "abcdefabcbb"
Output: 6
Explanation: The longest substring without repeating characters is "abcdef".

Idea:
Use two pointers (start, end) to create a window that contains unique characters.

Move end forward to expand the window.

If a duplicate is found, move start forward to remove duplicates.

Algorithm:

Initialize a HashMap (or int array) to store the last index of characters.

Use two pointers:

start = beginning of current window

end = end of current window

Iterate through string with end:

If s[end] is in map and its last index ≥ start, update start to lastIndex + 1 to skip repeated char.

Update map with s[end]'s current index.

Calculate max window length end - start + 1.

Return max length found.

Time Complexity: O(n) — each character visited at most twice.
Space Complexity: O(min(m, n)) — store characters in the map, m = charset size.
 */


import java.util.*;

public class LongestUniqueSubstring {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charIndexMap = new HashMap<>();
        int maxLength = 0;
        int start = 0; // Left pointer of window

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            // If current char seen and inside current window, move start
            if (charIndexMap.containsKey(currentChar) && charIndexMap.get(currentChar) >= start) {
                start = charIndexMap.get(currentChar) + 1;
            }

            // Update last index of current char
            charIndexMap.put(currentChar, end);

            // Calculate window size and update maxLength
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s1 = "geeksforgeeks";
        String s2 = "aaa";
        String s3 = "abcdefabcbb";

        System.out.println(lengthOfLongestSubstring(s1)); // 7
        System.out.println(lengthOfLongestSubstring(s2)); // 1
        System.out.println(lengthOfLongestSubstring(s3)); // 6
    }
}
