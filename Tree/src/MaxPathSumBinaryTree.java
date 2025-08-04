/*
Given a binary tree, the task is to find the maximum path sum. The path may start and end at any node in the tree.

Approach:

If the maximum sum path in a binary tree passes through the root, there are four possible cases to consider:

The path consists only the root itself, without involving any children.
The path starts at the root and extends downward through its right child, possibly continuing to the bottom of the right subtree.
The path starts at the root and extends downward through its left child, possibly continuing the bottom of the left subtree.
The path includes the root and spans both the left and right children.
The idea is to keep track of all four paths for each subtree of the tree and pick up the max one in the end.

For a given node, the max path may be:

- Only the node itself
- Node + left subtree
- Node + right subtree
- Node + left + right (node acts as a bridge)

 */// Definition of binary tree node
class Node14 {
    int val;
    Node14 left, right;

    Node14(int val) {
        this.val = val;
    }
}

public class MaxPathSumBinaryTree {

    // Global variable to track maximum path sum
    static int maxSum;

    // Main method to find max path sum
    public static int maxPathSum(Node14 root) {
        maxSum = Integer.MIN_VALUE;  // Initialize with the smallest possible value
        helper(root);                // Start DFS traversal from the root
        return maxSum;               // Return the max found path sum
    }

    // Helper function: returns the max gain from this node upwards
    private static int helper(Node14 node) {
        if (node == null) return 0;  // Base case: null node contributes 0

        // Recursively get the max gain from left and right subtrees
        int leftGain = Math.max(0, helper(node.left));   // We ignore negative gains
        int rightGain = Math.max(0, helper(node.right));

        // Case 4: Path goes through left, current node, and right
        int pathThroughNode = node.val + leftGain + rightGain;

        // Update the global maxSum if this is the largest so far
        maxSum = Math.max(maxSum, pathThroughNode);

        // For parent calls, return the max one-sided gain
        return node.val + Math.max(leftGain, rightGain);
    }

    // Driver code with sample input
    public static void main(String[] args) {
        Node14 root = new Node14(10);
        root.left = new Node14(2);
        root.right = new Node14(10);
        root.left.left = new Node14(20);
        root.left.right = new Node14(1);
        root.right.right = new Node14(-25);
        root.right.right.left = new Node14(3);
        root.right.right.right = new Node14(4);

        System.out.println("Maximum Path Sum: " + maxPathSum(root));  // Output: 42
    }
}
