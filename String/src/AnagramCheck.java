/*
Given two non-empty strings s1 and s2 of lowercase letters, determine if they are anagrams — i.e., if they contain the same characters with the same frequencies.
Examples:
Input: s1 = “geeks”  s2 = “kseeg”
Output: true
Explanation: Both the string have same characters with same frequency. So, they are anagrams.
Input: s1 = "allergy", s2 = "allergyy"
Output: false
Explanation: Although the characters are mostly the same, s2 contains an extra 'y' character. Since the frequency of characters differs, the strings are not anagrams.
Input: s1 = "listen", s2 = "lists"
Output: false
Explanation: The characters in the two strings are not the same — some are missing or extra. So, they are not anagrams.
*/
public class AnagramCheck {

    public static boolean areAnagrams(String s1, String s2) {
        // Step 1: If lengths differ, not anagrams
        if (s1.length() != s2.length()) {
            return false;
        }

        // Step 2: Frequency array for lowercase letters
        int[] freq = new int[26];

        // Step 3: Increment for s1, decrement for s2
        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }

        // Step 4: Check if all counts are zero
        for (int count : freq) {
            if (count != 0) {
                return false; // mismatch found
            }
        }

        return true; // all counts matched
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println(areAnagrams("geeks", "kseeg"));     // true
        System.out.println(areAnagrams("allergy", "allergyy"));// false
        System.out.println(areAnagrams("listen", "lists"));    // false
    }
}
