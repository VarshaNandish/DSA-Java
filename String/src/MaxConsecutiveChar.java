/*
Given a string s, the task is to find the maximum consecutive repeating character in the string.

Note: We do not need to consider the overall count, but the count of repeating that appears in one place.

Examples:

    Input: s = "geeekk"
    Output: e
    Explanation: character e comes 3 times consecutively which is maximum.

    Input: s = "aaaabbcbbb"
    Output: a
    Explanation: character a comes 4 times consecutively which is maximum.

 */

public class MaxConsecutiveChar {
    public static char maxConsecutiveChar(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException("String must not be empty");
        }

        char maxChar = s.charAt(0);
        int maxCount = 1;

        char currentChar = s.charAt(0);
        int currentCount = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == currentChar) {
                // Same character as before, increment current count
                currentCount++;
            } else {
                // Different character found, check and update max if needed
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                    maxChar = currentChar;
                }
                // Reset counters for new character
                currentChar = s.charAt(i);
                currentCount = 1;
            }
        }

        // After loop, check last run
        if (currentCount > maxCount) {
            maxCount = currentCount;
            maxChar = currentChar;
        }

        return maxChar;
    }

    public static void main(String[] args) {
        System.out.println(maxConsecutiveChar("geeekk"));       // Output: e
        System.out.println(maxConsecutiveChar("aaaabbcbbb"));   // Output: a
    }
}
