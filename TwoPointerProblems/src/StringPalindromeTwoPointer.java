/*

Problem Statement
Given a string, check whether it's a palindrome.

A string is a palindrome if it reads the same forward and backward.

Approach : Two-Pointer Technique (Optimal & Expected)
How it works:
Use two pointers:
One from the start (left)
One from the end (right)
Compare characters at both ends.
If all matching → palindrome.
If any mismatch → not a palindrome.

Time Complexity: O(n)
Space Complexity: O(1) (no extra space)

*/

public class StringPalindromeTwoPointer {

    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        // Check characters from both ends
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false; // Mismatch found
            }
            left++;   // Move left pointer forward
            right--;  // Move right pointer backward
        }

        return true; // All characters matched
    }

    public static void main(String[] args) {
        String word = "racecar";

        if (isPalindrome(word)) {
            System.out.println(word + " is a palindrome.");
        } else {
            System.out.println(word + " is not a palindrome.");
        }
    }
}
