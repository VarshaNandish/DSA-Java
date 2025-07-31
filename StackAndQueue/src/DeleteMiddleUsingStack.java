/*
Given a stack with push(), pop(), and empty() operations, The task is to delete the middle element of it without using any additional data structure.

Input: s = [10, 20, 30, 40, 50]
Output: [50, 40, 20, 10]
Explanation: The bottom-most element will be 10 and the top-most element will be 50. Middle element will be element at index 3 from bottom, which is 30. Deleting 30, stack will look like [10, 20, 40, 50].

Input: s = [5, 8, 6, 7, 6, 6, 5, 10, 12, 9]
Output: [9, 12, 10, 5, 6, 7, 6, 8, 5]
 */

import java.util.Stack;

public class DeleteMiddleUsingStack {

    // Function to delete middle of stack
    public static void deleteMiddle(Stack<Integer> stack) {
        int size = stack.size();
        int mid = size / 2;

        Stack<Integer> tempStack = new Stack<>();

        // Step 1: Remove elements until the middle
        for (int i = 0; i < mid; i++) {
            tempStack.push(stack.pop());
        }

        // Step 2: Pop and discard the middle element
        stack.pop();

        // Step 3: Restore elements back to original stack
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    // Helper method to print stack
    public static void printStack(Stack<Integer> stack) {
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    // Main method

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        int[] elements = {10, 20, 30, 40, 50}; // bottom to top
        for (int val : elements) {
            stack.push(val);
        }

        deleteMiddle(stack);

        System.out.print("Stack after deleting middle: ");
        printStack(stack); // Expected Output: 50 40 20 10
    }
}

