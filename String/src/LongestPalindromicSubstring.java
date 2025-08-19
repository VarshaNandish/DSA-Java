/*
Given a string s, find the longest substring which is a palindrome. If there are multiple answers, then find the first appearing substring.

Examples:

    Input: s = "forgeeksskeegfor"
    Output: "geeksskeeg"
    Explanation: The longest substring that reads the same forward and backward is "geeksskeeg". Other palindromes like "kssk" or "eeksskee" are shorter.

    Input: s = "Geeks"
    Output: "ee"
    Explanation: The substring "ee" is the longest palindromic part in "Geeks". All others are shorter single characters.

    Input: s = "abc"
    Output: "a"
    Explanation: No multi-letter palindromes exist. So the first character "a" is returned as the longest palindromic substring.
*/
public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            // Odd length palindrome
            int len1 = expandFromCenter(s, i, i);
            // Even length palindrome
            int len2 = expandFromCenter(s, i, i + 1);

            int len = Math.max(len1, len2);

            // Update only if strictly longer to preserve first occurrence
            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    // Helper to expand around a given center
    private static int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // Length of palindrome
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("forgeeksskeegfor")); // geeksskeeg
        System.out.println(longestPalindrome("Geeks")); // ee
        System.out.println(longestPalindrome("abc")); // a
    }
}
