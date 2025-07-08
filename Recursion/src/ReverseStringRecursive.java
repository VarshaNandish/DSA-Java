/*

Problem:

Reverse a string recursively using char[].

Approach:
Convert the String to a char[] array (since Java String is immutable).
Use a helper recursive function with two pointers:
start at the beginning of the array.
end at the end of the array.

Base case: if start >= end, stop.
Swap char[start] and char[end], and recurse inward.

Dry Run Example:
Let’s take input = "hello" → char[] = {'h','e','l','l','o'}


reverse(0, 4)

  h e l l o

  o e l l h

reverse(1, 3)

  o e l l h

  o l l e h

reverse(2, 2) → stop

  o l l e h

  o l l e h

Time and Space Complexity:
Time: O(n)
Space (stack): O(n)

*/


public class ReverseStringRecursive {

    // Recursive function to reverse a char array
    public static void reverseCharArray(char[] str, int start, int end) {

        // Base case: pointers meet or cross
        if (start >= end) {
            return;
        }

        // Swap characters at start and end
        char temp = str[start];
        str[start] = str[end];
        str[end] = temp;

        // Recur for the rest
        reverseCharArray(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        String input = "hello";

        // Convert String to char array
        char[] charArray = input.toCharArray();

        // Call recursive function
        reverseCharArray(charArray, 0, charArray.length - 1);

        // Convert char array back to string
        String reversed = new String(charArray);

        System.out.println("Original string: " + input);

        System.out.println("Reversed string: " + reversed);

    }
}
