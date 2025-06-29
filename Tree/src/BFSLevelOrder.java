/* Problem: Level Order Traversal (BFS)
Goal:
Traverse the tree level by level from top to bottom, left to right.

Approach: Queue-Based BFS (Standard & Optimal)
Step-by-Step Algorithm:

Use a Queue to process nodes level-by-level.
Enqueue the root node first.
While the queue is not empty:
Dequeue the front node.
Print/store its value.
Enqueue its left child (if exists).
Enqueue its right child (if exists).
This is the expected and optimal approach.

Time & Space Complexity:

Time: O(n) – visit each node once
Space: O(w) – width of tree (max number of nodes at any level); O(n) in worst case

Dry Run on Example Tree:
Queue = [1] → [2, 3] → [3, 4, 5] → [4, 5, 6] → ...
Print = 1 2 3 4 5 6 */

import java.util.LinkedList;

import java.util.Queue;

// Binary tree node class
class TreeeNode {
    int val;
    TreeeNode left, right;

    TreeeNode(int val) {
        this.val = val;
    }
}

// Class for Level Order (BFS) Traversal
public class BFSLevelOrder {
    // Method to perform level-order traversal
    public void levelOrder(TreeNode root) {
        if (root == null) return;

        // Queue to process nodes level-by-level
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);  // Add root to queue

        while (!queue.isEmpty()) {

            // Remove front of queue
            TreeNode current = queue.poll();

            // Print current node's value
            System.out.print(current.val + " ");

            // Add left and right children to queue
            if (current.left != null)
                queue.offer(current.left);

            if (current.right != null)
                queue.offer(current.right);
        }
    }

    // Main method to test the traversal
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        BFSLevelOrder obj = new BFSLevelOrder();

        System.out.print("Level-order Traversal (BFS): ");

        obj.levelOrder(root);

    }
}


