/*

Problem:

Write a recursive Java function to copy one array to another.

You are given two arrays:

source[]: contains the original data
destination[]: an empty array of the same size
Your task is to copy elements from source[] to destination[] using recursion (no loops).

Approach:

Logic:

Use a helper function that takes:
source[], destination[], and an index.

Base case: If index reaches the end of the array → stop.

Recursive case:
Copy source[index] to destination[index]
Recurse with index + 1

Time and Space Complexity:

Time: O(n)
Space (stack): O(n)

where n is the number of elements in the array

*/

public class ArrayCopyRecursive {

    // Recursive function to copy elements from source to destination
    public static void copyArray(int[] source, int[] destination, int index) {

        // Base case: stop when index reaches array length
        if (index == source.length) {
            return;
        }

        // Copy element at current index
        destination[index] = source[index];

        // Recursive call for next index
        copyArray(source, destination, index + 1);
    }



    public static void main(String[] args) {

        int[] source = {10, 20, 30, 40, 50};

        int[] destination = new int[source.length];  // Empty array of same size

        // Start recursive copy from index 0
        copyArray(source, destination, 0);

        // Print copied array
        System.out.print("Copied array: ");
        for (int val : destination) {
            System.out.print(val + " ");

        }
    }
}